package io.github.xieyinglin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class GithubFetchService {

    @Autowired
    private GithubService githubService;

    @Value("${github.userId}")
    private String userId;

    @Value("${github.projectName}")
    private String projectName;

    @Scheduled(cron = "0/5 0 0 * * *")
    public void fetchGithubIndicator() {
        log.info("======================");
        log.info("start fetch {}/{}", userId, projectName);
        try {
            githubService.crawlGithubIndicator(userId, projectName);
        } catch (Exception e) {
            log.error("fetchGithubIndicator error, userId {}, projectName {}", userId, projectName, e);
        }
        log.info("end fetch {}/{}", userId, projectName);
        log.info("======================");
    }


}