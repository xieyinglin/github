package io.github.xieyinglin.handler;

import javax.servlet.http.HttpServletRequest;

import io.github.xieyinglin.exception.BusinessException;
import io.github.xieyinglin.util.JsonUtil;
import io.github.xieyinglin.vo.ResultMsg;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultMsg<String> exceptionHandler(HttpServletRequest req, Exception e) throws Exception {

        String code = null;
        Object[] params = null;
        if (e instanceof BusinessException){
            // business exception
            BusinessException businessException = (BusinessException)e;

            code = businessException.getCode();
            params = businessException.getParams();

        }else{
            //other exception
            code = "500";
            params = new String[]{e.getMessage()};
        }

        log.error("occur exception, code {}, params {}", code, params);

        String data = JsonUtil.toJson(params);

        //return exception msg
        return new ResultMsg<String>(code, data);

    }

}