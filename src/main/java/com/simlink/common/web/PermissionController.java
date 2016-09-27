package com.simlink.common.web;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.simlink.common.entity.Menu;
import com.simlink.common.entity.Role;
import com.simlink.common.service.SystemService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 权限控制器
 * Created by Administrator on 2016/9/25 0025.
 */
@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseController{

    @Autowired
    SystemService systemService;

    @RequestMapping("role")
    @RequiresPermissions("system:permission:role")
    public String role(Role role){
        return "permission/roleManage";
    }


    /**
     * 获取角色
     * @return
     */
    @RequestMapping("getRoles")
    @RequiresPermissions("system:permission:role")
    @ResponseBody
    public Map<String,Object> getRoles(Integer page,Integer rows,Role role){
        Map<String,Object> result = Maps.newHashMap();
        String order = "UPDATE_TIME.asc";
        PageBounds pb= new PageBounds(page,rows, Order.formString(order));
        List<Role> roles = systemService.getRoles(role,pb);
        PageList pageList = (PageList)roles;
        Integer totalCount = pageList.getPaginator().getTotalCount();
        result.put("total",totalCount);
        result.put("rows",roles);
        return result;
    }


    @RequestMapping("getMenus")
    @RequiresPermissions("system:permission:role")
    @ResponseBody
    public List<Menu> getMenus(){
        List<Menu> origin = systemService.getAllMenus();
        List<Menu> menus = Menu.buildList(origin);
        return menus;
    }


    /**
     * 创建角色
     * @return
     */
    @RequestMapping("createRole")
    @RequiresPermissions("system:permission:role")
    @ResponseBody
    public Map<String,Object> createRole(Role role, String[] menuList){
        Map<String,Object> results = Maps.newHashMap();
        List<Menu> menus = Lists.newArrayList();
        for(int x=0;x<menuList.length;x++){
            Menu m = new Menu();
            m.setId(menuList[x]);
            menus.add(m);
        }
        role.setMenus(menus);
        systemService.createRole(role);
        results.put("success",true);
        return results;
    }

    /**
     * 创建角色
     * @return
     */
    @RequestMapping("updateRole")
    @RequiresPermissions("system:permission:role")
    @ResponseBody
    public Map<String,Object> updateRole(Role role, String[] menuList){
        Map<String,Object> results = Maps.newHashMap();
        List<Menu> menus = Lists.newArrayList();
        for(int x=0;x<menuList.length;x++){
            Menu m = new Menu();
            m.setId(menuList[x]);
            menus.add(m);
        }
        role.setMenus(menus);
        systemService.updateRole(role);
        results.put("success",true);
        return results;
    }

    @RequestMapping("deleteRole")
    @RequiresPermissions("system:permission:role")
    @ResponseBody
    public Map<String,Object> deleteRole(String id){
        Map<String,Object> results = Maps.newHashMap();
        systemService.deleteRole(id);
        results.put("success",true);
        return results;
    }
}
