package io.github.xieyinglin.vo;

import lombok.Data;

/**
 * Rest result msg format
 * @param <T>
 */
@Data
public class ResultMsg<T> {

    /**
     * return code
     */
    private String code = "success";

    /**
     * return result msg
     */
    private String msg = "";

    /**
     * return data
     */
    private T data;


    public ResultMsg(T data){
        this.data = data;
    }

    public ResultMsg(String code, T data){
        this.code = code;
        this.data = data;
    }
}