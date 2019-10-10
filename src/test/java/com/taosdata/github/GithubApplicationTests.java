package com.taosdata.github;

import java.net.URL;

import com.taosdata.github.service.GithubService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GithubApplication.class)
public class GithubApplicationTests {

	@Autowired
	private GithubService githubService;

	@Autowired
	private TestRestTemplate restTemplate;

	private URL reqURL;

	@Before
	public void setUp() throws Exception {
		String userId = "taosdata";
		String projectName = "TDengine";
		String startDate = "20190901";
		String endDate = "20190910";

		String url = String.format("http://localhost:8080/tdengine/github/%s/%s/%s/%s", userId, projectName, startDate,
				endDate);

		log.info("req url {}", url);

		this.reqURL = new URL(url);
	}

	@Test
	public void test1() throws Exception {

		ResponseEntity<String> response = this.restTemplate.getForEntity(this.reqURL.toString(), String.class, "");
	
		log.info("response {}", response.getBody());
		
	}


	@Test
	void crawlGithubIndicatorTest() throws Exception {

		String userId = "taosdata";
		String projectName = "TDengine";

		githubService.crawlGithubIndicator(userId, projectName);
		
	}




}
