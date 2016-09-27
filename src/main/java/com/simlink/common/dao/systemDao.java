package com.simlink.common.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.simlink.common.annotation.MyBatisDao;
import com.simlink.common.entity.*;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface SystemDao {

    public User getUser(String userName);

    public List<Role> getRoles(Role role,PageBounds pb);

    public List<Menu> getMenus(Menu menu);

    public List<User> getAllUsers();

    public void addUser(User user);

    public void updateRoles(Map<String,String> map);

    public void updateMenu(Map<String,String> map);

    public List<Menu> findMenusByUserId(Menu menu);

    public void assignRole(RoleQueryAndView role);

    public void updateUser(User user);

    public List<Menu> getMenusByRoleId(String roleId);

    public void addRole(Role role);

    public void assignMenu(MenuQueryAndView mqv);

    public void updateRole(Role role);

    public void deleteMenuRole(String id);

    public void deleteRole(String id);
}
