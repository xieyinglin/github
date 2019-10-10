package io.github.xieyinglin.vo;

import java.util.List;

import lombok.Data;

/**
 * Github project indicator
 */
@Data
public class GithubIndicatorVo {

    /**
     * github userId
     */
    private String userId;

    /**
     * github projectName
     */
    private String projectName;

    /**
     * query date collction with format yyyy-MM-dd
     */
    private List<String> xDate;

    /**
     * watch
     */
    private IndicatorVo watch;

    /**
     * star
     */
    private IndicatorVo star;

    /**
     * issues
     */
    private IndicatorVo issues;

    /**
     * fork
     */
    private IndicatorVo fork;

}