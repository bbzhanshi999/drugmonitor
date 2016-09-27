package com.simlink.common.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.google.common.collect.Lists;
import com.simlink.common.dao.SystemDao;
import com.simlink.common.entity.*;
import com.simlink.common.utils.StringUtils;
import com.simlink.common.utils.UserUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 系统服务类
 * Created by Administrator on 2016/9/14 0014.
 */
@Service
@Transactional(readOnly = true)
public class SystemService {

    @Autowired(required = true)
    public SystemDao systemDao;

    @Value("${initPassword}")
    private String initPassword;

    /**
     * 根据用户名取得用户信息
     * @param userName
     * @return
     */
    @Transactional(readOnly = false)
    public User getUser(String userName){
        User user = UserUtils.getUser(userName);
        return user;
    }

    /**
     * 添加新用户
     * @param user
     */
    @Transactional(readOnly = false)
    public void createUser(User user) {
        user.preInsert();
        if(StringUtils.isBlank(user.getPassword())){
            user.setPassword(initPassword);
        }else{
            String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
            SimpleHash hash = new SimpleHash("md5",user.getPassword(),user.getUserName()+salt,2);
            user.setPassword(hash.toString());
            user.setSalt(salt);
        }
        systemDao.addUser(user);
        assginRole(user);
        UserUtils.addUser(user.getUserName());

    }

    @Transactional(readOnly = false)
    public void assginRole(User user){
        for(Role role:user.getRoles()){
            RoleQueryAndView rqv = new RoleQueryAndView(user.getId(),role.getId());
            rqv.preInsert();
            systemDao.assignRole(rqv);
        }
    }

    public String getInitPassword() {
        return initPassword;
    }

    public void setInitPassword(String initPassword) {
        this.initPassword = initPassword;
    }

    /**
     * 更新user
     * @param user
     */
    @Transactional(readOnly = false)
    public void updateUser(User user) {
        user.preUpdate();
        if(user.getUpdater()==null){
            user.setUpdater(user);
        }
        systemDao.updateUser(user);
        UserUtils.addUser(user,false);
    }

    /**
     * 更新初始化密码
     * @param initPasswordUser
     * @param initPassword
     */
    @Transactional(readOnly = false)
    public void updatePassword(String initPasswordUser, String initPassword) {
        User user = systemDao.getUser(initPasswordUser);
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        SimpleHash hash = new SimpleHash("md5",initPassword,user.getUserName()+salt,2);
        user.setPassword(hash.toString());
        user.setSalt(salt);
        updateUser(user);
    }

    /**
     * 获得角色列表
     * @param roleQuery
     * @param pb
     * @return
     */
    public List<Role> getRoles(Role roleQuery, PageBounds pb) {
        List<Role> roles = systemDao.getRoles(roleQuery,pb);
        for(Role role:roles){
            List<Menu> menus = systemDao.getMenusByRoleId(role.getId());
            role.setMenus(menus);
            List<String> menuNames  = Lists.newArrayList();
            for(Menu menu:menus){
                menuNames.add(menu.getMenuName());
            }
            role.setMenuNames(menuNames);
        }
        return  roles;
    }

    /**
     * 获取所有菜单权限
     * @return
     */
    public List<Menu> getAllMenus() {
        return systemDao.getMenus(new Menu());
    }

    /**
     * 创建新角色
     * @param role
     */
    @Transactional(readOnly = false)
    public void createRole(Role role) {
        role.preInsert();
        systemDao.addRole(role);
        assginMenu(role);
    }


    @Transactional(readOnly = false)
    private void assginMenu(Role role) {
        systemDao.deleteMenuRole(role.getId());
        for(Menu menu:role.getMenus()){
            MenuQueryAndView mqv = new MenuQueryAndView(role.getId(),menu.getId());
            mqv.preInsert();
            systemDao.assignMenu(mqv);
        }
    }

    public void updateRole(Role role) {
        role.preUpdate();
        systemDao.updateRole(role);
        assginMenu(role);
        UserUtils.loadAllUsers();
    }

    public void deleteRole(String id){
        systemDao.deleteRole(id);
        UserUtils.loadAllUsers();
    }
}
