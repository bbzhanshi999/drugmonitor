package com.simlink.common.web;

import com.simlink.common.entity.Menu;
import com.simlink.common.service.SystemService;
import com.simlink.common.utils.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 系统管理业务控制器
 * Created by Administrator on 2016/9/19 0019.
 */
@Controller
@RequestMapping("/system")
public class SystemController {

    @Autowired
    SystemService systemService;

    @RequestMapping("user/create")
    @RequiresPermissions("system:user:create")
    public String createUser(){

        return "system/createUser";
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

}
