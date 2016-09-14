package com.simlink.common.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * session缓存读取工具,获取权限个人信息的简单封装
 * Created by zql on 2016/5/19 0019.
 */
public class SessionCacheUtils {


    protected static Logger logger = LoggerFactory.getLogger(SessionCacheUtils.class);


    /**
     * 获得当前线程的session
     * @return
     */
    public static HttpSession getSession(){
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
    }


    /**
     * 获取授权主要对象
     */
    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }
}
