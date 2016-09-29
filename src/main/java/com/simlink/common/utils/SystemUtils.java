package com.simlink.common.utils;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.simlink.common.config.Global;
import com.simlink.common.dao.SystemDao;
import com.simlink.common.entity.Menu;
import com.simlink.common.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 系统工具类
 * Created by Administrator on 2016/9/20 0020.
 */
@Service
@Lazy(false)
public class SystemUtils {
    protected static Logger logger = LoggerFactory.getLogger(SystemUtils.class);
    private static SystemDao systemDao = SpringContextHolder.getBean(SystemDao.class);

    private static final String MENULIST ="menus";
    private static final String ROLELIST="roles";


    /**
     * 初始化相关系统及权限信息入缓存
     */
    @PostConstruct
    public static void initLoad(){
        setAllMenus();
        setAllRoles();
    }

    public static List<Role> getAllRoles(){
        List<Role> roles =(List<Role>) JedisUtils.hgetAll(ROLELIST);
        if(Collections3.isEmpty(roles)){
            setAllRoles();
            roles =(List<Role>) JedisUtils.hgetAll(ROLELIST);
        }
        return roles;
    }

    public static void setAllRoles(){
        List<Role> roles = systemDao.getRoles(null,new PageBounds());
        for(Role role:roles){
            JedisUtils.hset(ROLELIST,role.getId(),role);
        }
    }

    public static List<Menu> getAllMenus(){
        List<Menu> menus =(List<Menu>) JedisUtils.hgetAll(MENULIST);
        if(Collections3.isEmpty(menus)){
            setAllMenus();
            menus =(List<Menu>) JedisUtils.hgetAll(MENULIST);
        }
        return menus;
    }

    public static void setAllMenus(){
        List<Menu> menus = systemDao.getMenus(null);
        for(Menu menu:menus){
            JedisUtils.hset(MENULIST,menu.getId(),menu);
        }
    }

    /**
     * 清空当前角色相关缓存内容
     */
    public static void flushCurrRoleRelated(HttpSession session){
        session.removeAttribute(MENULIST);
    }


    /**
     * 设置系统超时时间
     * @param interval
     */
    public static void setSessionInteval(Integer interval) {
        RedisOperationsSessionRepository sessionRepository = SpringContextHolder.getBean("sessionRepository");
        sessionRepository.setDefaultMaxInactiveInterval(interval);
        JedisUtils.setObject("sessionInterval",interval,0);
    }

    public static Integer getSessionInterval() {
        Integer sessionInterval = (Integer) JedisUtils.getObject("sessionInterval");
        if(sessionInterval==null){
            sessionInterval = Integer.parseInt(Global.getConfig("session.maxInactiveInterval"));
        }
        return sessionInterval;
    }
}
