package com.simlink.common.web;

import com.google.common.collect.Maps;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 全局异常处理
 * Created by zql on 2016/6/22 0022.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    @ExceptionHandler(value=ShiroException.class)
    @ResponseBody
    public Map<String,Object> authenticationExceptionHandler(Exception e, HttpServletRequest request){

        Map<String,Object> errMsg = Maps.newHashMap();
        String contextPath = request.getContextPath();
        errMsg.put("error","您没有权限访问该资源！请重新登录：<a href='"+contextPath+"'>登录</a>");
        errMsg.put("authcError",true);
        logger.error(e.toString(),e);
        return errMsg;
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
