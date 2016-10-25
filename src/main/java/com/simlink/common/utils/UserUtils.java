package com.simlink.common.utils;


import com.simlink.common.dao.SystemDao;
import com.simlink.common.entity.Menu;
import com.simlink.common.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 用户工具类
 * Created by Administrator on 2016/5/3 0003.
 */
@Service
public class UserUtils {

    public static final String KEY_ACTIVE_USERS = "activeUsers";
    public static final String USERS = "users";
    private static SystemDao systemDao = SpringContextHolder.getBean(SystemDao.class);
    protected static Logger logger = LoggerFactory.getLogger(UserUtils.class);


    /**
     * 根据用户名获得user
     * @param userName
     * @return
     */
    public static User getUser(String userName){
        User user = (User) JedisUtils.hget(USERS, userName);
        if(user==null) {
            user = systemDao.getUser(userName);
        }
        if(user!=null) addUser(user,false);
        return user;
    }

    /**
     * 载入所有user信息
     */
    public static void loadAllUsers(){
        List<User> allUsers = systemDao.getAllUsers();
        JedisUtils.del(USERS);
        for(User user:allUsers){
            JedisUtils.hset(USERS,user.getUserName(),user);
        }
    }

    /**
     * 添加user
     * @param persist 是否持久化
     */
    public static void addUser(User user,Boolean persist){
        JedisUtils.hset(USERS,user.getUserName(),user);
        if(persist) systemDao.addUser(user);
    }

    /**
     * 添加user
     * @param userName
     * @return
     */
    public static void addUser(String userName){
        User user = systemDao.getUser(userName);
        if(user!=null) addUser(user,false);
    }


    /**
     * 从当前线程当中获取线程user
     * @return
     */
    public static User getCurrentUser() {
        User user = (User) SessionCacheUtils.getSecuritySession().getAttribute("user");
        return user;
    }

    /**
     * 从当前线程当中获取线程user
     * @return
     */
    public static User getCurrentUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return user;
    }

    /**
     * 获得在线用户
     * @param id
     * @return
     */
    public static User getActiveUser(String id){

        User user =null ;
        try {
            user = (User)JedisUtils.hget(KEY_ACTIVE_USERS,id);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return user;
    }

    /**
     * 验证用户是否在线
     * @param guid
     * @return
     */
    public static boolean activeExists(String guid){
        return JedisUtils.hexists(KEY_ACTIVE_USERS,guid);
    }

    /**
     * 移除当前在线用户
     */
    public static void logoutUser(){
        String userid = getCurrentUser().getId();
        JedisUtils.hdel(KEY_ACTIVE_USERS,userid);
        getSubject().logout();
    }


    /**
     * 获取授权主要对象
     */
    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    /**
     * 移除指定用户
     * @param guid
     */
    public static void logoutUser(String guid,String sessionId){

        JedisUtils.hdel(KEY_ACTIVE_USERS,guid);

        // TODO: 2016/5/19 0019 指定用户退出在线状态(根据sessionid找到session并使其失效)
    }

    /**
     * 获取所有在线用户
     * @return
     */
    public static Map<String, Object> getActiveUsers() {


        Map<String, Object> activeUsers = JedisUtils.getObjectMap(KEY_ACTIVE_USERS);
        return activeUsers;
    }


    /**
     * 添加在线用户
     * @param user
     */
    public static void addActiveUser(User user){

        Session session = SessionCacheUtils.getSecuritySession();
        session.setAttribute("user",user);
        long result = JedisUtils.hset(KEY_ACTIVE_USERS,user.getId(),user);
        logger.debug("addUser {},{}",user.getId(),String.valueOf(result));
    }

}
