package com.simlink.common.web;

import com.google.common.collect.Maps;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 全局异常处理
 * Created by zql on 2016/6/22 0022.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    @ExceptionHandler(value=AuthenticationException.class)
    public String authenticationExceptionHandler(Exception e,Model model){

        Map<String,Object> errMsg = Maps.newHashMap();
        errMsg.put("error",e.toString());
        logger.error(e.toString(),e);
        model.addAttribute("error","您没有访问资源权限！");
        return "error/500";
    }

    @ExceptionHandler(value=Exception.class)
    public String throwableHandler(Exception e,Model model){

        Map<String,Object> errMsg = Maps.newHashMap();
        errMsg.put("error",e.toString());
        logger.error(e.toString(),e);
        model.addAttribute("error",e.getMessage());
        return "error/500";
    }

}
