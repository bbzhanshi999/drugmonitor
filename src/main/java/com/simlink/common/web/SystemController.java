package com.simlink.common.web;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.simlink.common.entity.Menu;
import com.simlink.common.entity.Role;
import com.simlink.common.entity.User;
import com.simlink.common.service.SystemService;
import com.simlink.common.utils.StringUtils;
import com.simlink.common.utils.SystemUtils;
import com.simlink.common.utils.UserUtils;
import com.simlink.sinosoft.drugmonitor.entity.DataClient;
import com.simlink.sinosoft.drugmonitor.entity.Organization;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("")
    @RequiresPermissions("system:config")
    public String system(Model model){
        model.addAttribute("sessionInterval",SystemUtils.getSessionInterval());
        return "system/config";
    }

    @RequestMapping(value="config/{key}")
    @RequiresPermissions("system:config")
    @ResponseBody
    public Map<String,Object> systemConfig(@PathVariable("key") String key,String value){
        Map<String,Object> result = Maps.newHashMap();
        if(StringUtils.isNotBlank(key)){
            if("sessionInterval".equals(key)){
                Integer interval = Integer.parseInt(value);
                SystemUtils.setSessionInteval(interval);
            }
        }
        result.put("success",true);
        return result;
    }

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
    public Boolean userNameValidate(String userName,String id){
        if(StringUtils.isBlank(id)){
            User u = UserUtils.getUser(userName);
            if(u!=null&&StringUtils.isNotBlank(u.getId())){
                return false;
            }
        }else{
            User u = UserUtils.getUser(userName);
            if(!id.equals(u.getId())){
                return false;
            }
        }
        return true;
    }


    /**
     * 用户管理页面
     * @return
     */
    @RequestMapping("user")
    @RequiresPermissions("system:user:edit")
    public String user(){
        return "system/userEdit";
    }

    /**
     * 获得用户
     * @return
     */
    @RequestMapping("user/getUsers")
    @RequiresPermissions("system:user:edit")
    @ResponseBody
    public Map<String,Object> getUsers(Integer page,Integer rows,User user){
        Map<String,Object> result = Maps.newHashMap();
        PageBounds pb= new PageBounds(page,rows);
        List<User> users = systemService.getUsers(user,pb);
        PageList pageList = (PageList)users;
        Integer totalCount = pageList.getPaginator().getTotalCount();
        result.put("total",totalCount);
        result.put("rows",users);
        return result;
    }

    /**
     * 更新用户
     * @return
     */
    @RequestMapping("user/updateUser")
    @RequiresPermissions("system:user:edit")
    @ResponseBody
    public Map<String,Object> updateUser(User user, String[] role){
        Map<String,Object> result = Maps.newHashMap();
        if(role ==null || role.length<=0){
            result.put("error","角色未选择。");
            return result;
        }
        List<Role> roles = Lists.newArrayList();
        for(int x=0;x<role.length;x++){
            Role r = new Role();
            r.setId(role[x]);
            roles.add(r);
        }
        user.setRoles(roles);
        systemService.updateUser(user,true);
        result.put("message","用户修改成功。");
        result.put("success",true);
        return result;
    }

    /**
     * 删除用户
     * @return
     */
    @RequestMapping("user/deleteUser")
    @RequiresPermissions("system:user:edit")
    @ResponseBody
    public Map<String,Object> deleteUser(String id){
        Map<String,Object> result = Maps.newHashMap();
        systemService.deleteUser(id);

        result.put("success",true);
        return result;
    }

    /**
     * 重置密码
     * @return
     */
    @RequestMapping("user/resetPassword")
    @RequiresPermissions("system:user:edit")
    @ResponseBody
    public Map<String,Object> resetPassword(String id){
        Map<String,Object> result = Maps.newHashMap();
        systemService.resetPassword(id);

        result.put("success",true);
        return result;
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
