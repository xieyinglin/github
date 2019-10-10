package io.github.xieyinglin.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * custom http result
 */
@Data
@AllArgsConstructor
public class HttpResult {

    /**
     * resp status code
     */
    private int code;

    /**
     * resp body 
     */
    private String body;

}