package com.simlink.common.utils;

import com.simlink.common.dao.SystemDao;
import com.simlink.common.entity.Menu;
import com.simlink.common.entity.Role;
import com.simlink.common.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * session和缓存读取工具,获取权限个人信息的简单封装
 * Created by zql on 2016/5/19 0019.
 */
public class SessionCacheUtils {


    protected static Logger logger = LoggerFactory.getLogger(SessionCacheUtils.class);


    /**
     * 获得当前线程的session
     * @return
     */
    public static HttpSession getHttpSession(){
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
    }

    /**
     *
     * @return
     */
    public static Session getSecuritySession(){
        Session session = SecurityUtils.getSubject().getSession();
        return session;
    }



}
