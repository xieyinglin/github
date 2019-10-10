package com.taosdata.github.exception;

import lombok.Data;

/**
 * business exception
 */
@Data
public class BusinessException extends Exception {

    /**
     * exception code
     */
    String code;

    /**
     * exception params
     */
    Object[] params;

}