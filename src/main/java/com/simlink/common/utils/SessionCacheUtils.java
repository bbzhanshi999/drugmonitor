package com.simlink.common.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
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

    /*private static RoleDao roleDao = SpringContextHolder.getBean(RoleDao.class);*/



    private static final String CURRENTROLE_MENULIST="menuList";
    private static final String CURRENTROLE_PATIENTLISTS="patientLists";
    private static final String BLTREE="blTree";

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



    /**
     * 清空当前角色相关缓存内容
     */
    public static void flushCurrRoleRelated(HttpSession session){
        session.removeAttribute(CURRENTROLE_MENULIST);
        session.removeAttribute(CURRENTROLE_PATIENTLISTS);
    }


}
