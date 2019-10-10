package com.taosdata.github.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * http config
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "http")
public class HttpConfig {

    /**
     * maxConnection
     * 
     * */
    private Integer maxTotal;
    
    /**
     * maxConnPerRoute
     */
    private Integer defaultMaxPerRoute;
    
    /**
     * max create connection timeout
     */
    private Integer connectTimeout;

    /**
     * max time get from connection pool
     */
    private Integer connectionRequestTimeout;

    /**
     * max time of data trans
     */
    private Integer socketTimeout;


    /**
     * test conn before get 
     */
    private boolean staleConnectionCheckEnabled;


}