package com.simlink.common.dao;

import com.simlink.common.annotation.MyBatisDao;
import com.simlink.common.entity.Menu;
import com.simlink.common.entity.Role;
import com.simlink.common.entity.User;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface SystemDao {

    public User getUser(String userName);

    public List<Role> getRoles(User user);

    public List<Menu> getMenus(Role role);

    public List<User> getAllUsers();

    public void addUser(User user);

    public void updateRoles(Map<String,String> map);

    public void updateMenu(Map<String,String> map);

    public List<Menu> findMenusByUserId(Menu menu);
}
