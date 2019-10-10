package io.github.xieyinglin.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.github.xieyinglin.dao.GithubIndicatorMapper;
import io.github.xieyinglin.domain.GithubIndicator;
import io.github.xieyinglin.util.DateUtil;
import io.github.xieyinglin.util.JsonUtil;
import io.github.xieyinglin.vo.GithubIndicatorVo;
import io.github.xieyinglin.vo.IndicatorVo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class GithubService {

    private static final String githubUrl = "https://github.com/%s/%s";

    @Autowired
    private HttpService httpService;

    @Autowired
    private GithubIndicatorMapper githubIndicatorMapper;

    /**
     * query project indicator between startYYYYMMDD and endYYYYMMDD
     * 
     * @param userId
     * @param projectName
     * @param startYYYYMMDD   include
     * @param endYYYYMMDD     include
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public GithubIndicatorVo getGithubIndicator(String userId, String projectName, String startYYYYMMDD,
            String endYYYYMMDD) throws ParseException, IOException {

        Date startDate = DateUtil.parseDate(startYYYYMMDD, DateUtil.yyyyMMdd);
        Date endDate = DateUtil.parseDate(endYYYYMMDD, DateUtil.yyyyMMdd);

        endDate = DateUtil.addDate(endDate, 1);//end query date

        //execute query
        List<GithubIndicator> resultList = githubIndicatorMapper.selectMaxByDay(userId, projectName, startDate, endDate);

        log.info("getGithubIndicator userId {}, projectName {}, startDate {}, endDate {}, result {}", userId, projectName, startYYYYMMDD, endYYYYMMDD, JsonUtil.toJson(resultList));

        if(CollectionUtils.isEmpty(resultList)){
            return null;
        }

        //build vo
        GithubIndicatorVo githubIndicatorVo = buildGithubIndicatorVo(userId, projectName, startYYYYMMDD, endYYYYMMDD, resultList);
        
        return githubIndicatorVo;
    }

    private GithubIndicatorVo buildGithubIndicatorVo(String userId, String projectName, String startYYYYMMDD, String endYYYYMMDD, List<GithubIndicator> resultList) throws ParseException {
       
        List<String> dateList = DateUtil.getDateList(startYYYYMMDD, endYYYYMMDD, DateUtil.yyyyMMdd, DateUtil.yyyy_MM_dd);
        log.info("dateList {}", dateList);

        if(CollectionUtils.isEmpty(dateList)){
            return null;
        }

        GithubIndicatorVo githubIndicatorVo = new GithubIndicatorVo();
        githubIndicatorVo.setUserId(userId);
        githubIndicatorVo.setProjectName(projectName);
        githubIndicatorVo.setXDate(dateList);

        //watch
        Integer watchTotal = 0;
        List<Integer> watchDataList = new ArrayList<Integer>(dateList.size());
        IndicatorVo watch = new IndicatorVo(watchTotal, watchDataList);
        githubIndicatorVo.setWatch(watch);

        //star
        Integer starTotal = 0;
        List<Integer> starDataList = new ArrayList<Integer>(dateList.size());
        IndicatorVo star = new IndicatorVo(starTotal, starDataList);
        githubIndicatorVo.setStar(star);

        //issues
        Integer issuesTotal = 0;
        List<Integer> issuesDataList = new ArrayList<Integer>(dateList.size());
        IndicatorVo issues = new IndicatorVo(issuesTotal, issuesDataList);
        githubIndicatorVo.setIssues(issues);

        //fork
        Integer forkTotal = 0;
        List<Integer> forkDataList = new ArrayList<Integer>(dateList.size());
        IndicatorVo fork = new IndicatorVo(forkTotal, forkDataList);
        githubIndicatorVo.setFork(fork);

        for(String dateStr : dateList){

            GithubIndicator githubIndicator = getGithubIndicator(dateStr, resultList);

            //default value
            Integer watchValue = 0;
            Integer starValue = 0;
            Integer issuesValue = 0;
            Integer forkValue = 0;
            if(githubIndicator != null){
                
                watchValue = githubIndicator.getWatch();
                starValue = githubIndicator.getStar();
                issuesValue = githubIndicator.getIssues();
                forkValue = githubIndicator.getFork();
            }

            watch.getData().add(watchValue);

            star.getData().add(starValue);

            issues.getData().add(issuesValue);

            fork.getData().add(forkValue);

        }

        //set add user num between query date
        watch.setTotal(watch.getData().get(watch.getData().size()-1) -  watch.getData().get(0));
        star.setTotal(star.getData().get(star.getData().size()-1) -  star.getData().get(0));
        issues.setTotal(issues.getData().get(issues.getData().size()-1) -  issues.getData().get(0));
        fork.setTotal(fork.getData().get(fork.getData().size()-1) -  fork.getData().get(0));
        
        return githubIndicatorVo;
    }



    private GithubIndicator  getGithubIndicator(String yyyy_MM_dd, List<GithubIndicator> resultList){

        if(StringUtils.isEmpty(yyyy_MM_dd)){
            return null;
        }

        for(GithubIndicator githubIndicator : resultList){
            if(yyyy_MM_dd.equals(DateUtil.format(githubIndicator.getFetchTime(), DateUtil.yyyy_MM_dd))){
                return githubIndicator;
            }
        }

        return null;
    }

    /**
     * fetch github indicators 
     * @param userId
     * @param projectName
     * @throws Exception
     */
    public GithubIndicatorVo crawlGithubIndicator(String userId, String projectName) throws Exception {

        String githubProjectUrl = String.format(githubUrl, userId, projectName);    

        String resp = httpService.doGet(githubProjectUrl);

        // log.info("send a post to {}, and resp is {}", githubProjectUrl, resp);

        GithubIndicator githubIndicator = parseGithubIndicator(resp);
        
        if(githubIndicator == null){
            log.error("parse githubProjectUrl {} empty", githubProjectUrl);
            return null;
        }

        githubIndicator.setUserId(userId);
        githubIndicator.setProjectName(projectName);
        githubIndicator.setFetchTime(new Date());

        // save githubIndicator
        int insertResult = githubIndicatorMapper.insertSelective(githubIndicator);

        log.info("insertResult {}", insertResult == 1 ? "success" : "failed");

        String today = DateUtil.format(new Date(), DateUtil.yyyyMMdd);

        List<GithubIndicator> indicatorList = new ArrayList<>(1);
        indicatorList.add(githubIndicator);

        if (insertResult == 1){
            return buildGithubIndicatorVo(userId, projectName, today, today, indicatorList);
        }

        return null;
    }

    /**
     * parse github indicators
     * @param response
     * @return
     */
    private GithubIndicator parseGithubIndicator(String response){

        if(StringUtils.isEmpty(response)){
            return null;
        }

        Document doc = Jsoup.parse(response);

        Elements elements = doc.select("ul[class=pagehead-actions]").select("li");

        if(elements == null || elements.isEmpty()){
            return null;
        }

        //get watch
        String watchStr = elements.get(0).select("a[class=social-count]").text();

        //get star
        String starStr = elements.get(1).select("a[class=social-count js-social-count]").text();

        //get watch
        String forkStr = elements.get(2).select("a[class=social-count]").text();

        // issues
        Integer issues = -1;//default value;
        Elements spanElements = doc.select("nav[class=hx_reponav reponav js-repo-nav js-sidenav-container-pjax container]").select("span[itemprop=itemListElement]");
        if(spanElements != null && spanElements.size() >= 2){
            String issuesStr = spanElements.get(1).select("span[class=Counter]").text();
            if(!StringUtils.isEmpty(issuesStr)){
                issues = Integer.parseInt(issuesStr.replaceAll(",", ""));
            }
        }

        log.info("parsed watch {}, star {}, fork {}, issues {}", watchStr, starStr, forkStr, issues);

        GithubIndicator githubIndicator = new GithubIndicator();
        githubIndicator.setWatch(Integer.parseInt(watchStr.replaceAll(",", "")));
        githubIndicator.setStar(Integer.parseInt(starStr.replaceAll(",", "")));
        githubIndicator.setFork(Integer.parseInt(forkStr.replaceAll(",", "")));
        githubIndicator.setIssues(issues);

        return githubIndicator;
    }



}