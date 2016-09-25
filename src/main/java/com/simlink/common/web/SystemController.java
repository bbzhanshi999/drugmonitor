package com.simlink.common.web;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.simlink.common.entity.Menu;
import com.simlink.common.entity.Role;
import com.simlink.common.entity.User;
import com.simlink.common.service.SystemService;
import com.simlink.common.utils.StringUtils;
import com.simlink.common.utils.SystemUtils;
import com.simlink.common.utils.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 系统管理业务控制器
 * Created by Administrator on 2016/9/19 0019.
 */
@Controller
@RequestMapping("/system")
public class SystemController extends BaseController{

    @Autowired
    SystemService systemService;

    @RequestMapping("user/create")
    @RequiresPermissions("system:user:create")
    public String createUser(HttpServletResponse response, User user, String[] role){
        if(user==null||StringUtils.isBlank(user.getUserName())){
            return "system/createUser";
        }
        Map<String,Object> result = Maps.newHashMap();
        if(role ==null || role.length<=0){
            result.put("error","角色未选择。");
            renderString(response,result);
            return null;
        }


        List<Role> roles = Lists.newArrayList();
        for(int x=0;x<role.length;x++){
            Role r = new Role();
            r.setId(role[x]);
            roles.add(r);
        }
        user.setRoles(roles);
        systemService.createUser(user);
        result.put("message","用户创建成功。");
        renderString(response,result);
        return null;
    }

    @RequestMapping("userNameValidate")
    @ResponseBody
    public Boolean userNameValidate(String userName){
        User u = UserUtils.getUser(userName);
        if(u!=null&&StringUtils.isNotBlank(u.getId())){
            return false;
        }
        return true;
    }


    @RequestMapping("user")
    @RequiresPermissions("system:user")
    public Map<String,Object> user(){
        // TODO: 2016/9/19 0019
        return null;
    }

    @RequestMapping("menu")
    @ResponseBody
    public List<Menu> menu(HttpServletRequest request){
        List<Menu> origin = UserUtils.getCurrentUser(request).getMenus();
        List<Menu> menus = Menu.buildList(origin);
        return menus;
    }

    @RequestMapping("getAllRoles")
    @ResponseBody
    public List<Role> getAllRoles(){
        List<Role> roles = SystemUtils.getAllRoles();
        return roles;
    }

    @RequestMapping("getAllMenus")
    @ResponseBody
    public List<Menu> getAllMenus(){
        List<Menu> menus = SystemUtils.getAllMenus();
        return menus;
    }
}
