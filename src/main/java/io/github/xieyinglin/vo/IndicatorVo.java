package io.github.xieyinglin.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * basic indicator
 */
@Data
@AllArgsConstructor
public class IndicatorVo {
    
    /**
     * data sum
     */
    private Integer total;

    /**
     * data collection
     */
    private List<Integer> data;


}