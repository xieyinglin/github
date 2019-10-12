package io.github.xieyinglin.controller;

import java.io.IOException;
import java.text.ParseException;

import io.github.xieyinglin.service.GithubService;
import io.github.xieyinglin.vo.GithubIndicatorVo;
import io.github.xieyinglin.vo.ResultMsg;

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

}