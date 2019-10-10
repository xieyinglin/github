package com.taosdata.github.controller;

import java.io.IOException;
import java.text.ParseException;

import com.taosdata.github.service.GithubService;
import com.taosdata.github.vo.GithubIndicatorVo;
import com.taosdata.github.vo.ResultMsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/github")
public class GithubController {

	@Autowired
	private GithubService githubService;

	/**
	 *
	 * query the github indicator of the specified user project
	 * 
	 * @param userId
	 * @param projectName
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping("/{userId}/{projectName}/{startDate}/{endDate}")
	public ResultMsg<GithubIndicatorVo> index(@PathVariable() String userId, @PathVariable String projectName,
			@PathVariable(required = false) String startDate, @PathVariable(required = false) String endDate)
			throws ParseException, IOException {

		log.info("userId {}, projectName {}, startDate {}, endDate {}", userId, projectName, startDate, endDate);

		GithubIndicatorVo githubIndicatorVo = githubService.getGithubIndicator(userId, projectName, startDate, endDate);

		return new ResultMsg<GithubIndicatorVo>(githubIndicatorVo);

	}

	@PostMapping("/{userId}/{projectName}")
	public ResultMsg<GithubIndicatorVo> crawl(@PathVariable() String userId, @PathVariable String projectName) throws Exception {

		log.info("userId {}, projectName {}", userId, projectName);

		GithubIndicatorVo githubIndicatorVo = githubService.crawlGithubIndicator(userId, projectName);

		return new ResultMsg<GithubIndicatorVo>(githubIndicatorVo);
    }




    /**
     *  String resultMsg = "{
			'code': 'Success',
			'msg': '',
			'data': {
				'xDate': ['2019-08-06', '2019-08-07', '2019-08-08', '2019-08-09', '2019-08-10', '2019-08-11', '2019-08-12'],
				'watch': {
					'total': 50,
					'data': [19.55, 20.43, 57.46, 48.87, 26.33, 57.38, 42.1]
				},
				'star': {
					'total': 50,
					'data': [22.18, 24.76, 20.37, 28.09, 22.25, 26.75, 20.14]
				},
				'issues': {
					'total': 5360,
					'data': [599, 302, 753, 695, 673, 558, 779]
				},
				'fork': {
					'total': 450,
					'data': [59, 32, 73, 69, 63, 58, 79]
				}
			}
		}";
     */
}