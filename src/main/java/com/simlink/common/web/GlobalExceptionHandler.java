package com.simlink.common.web;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 全局异常处理
 * Created by zql on 2016/6/22 0022.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Map<String,Object> throwableHandler(Exception e){

        Map<String,Object> errMsg = Maps.newHashMap();
        errMsg.put("errMsg",e.toString());
        logger.error(e.toString(),e);
        return errMsg;
    }

}
