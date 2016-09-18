package com.simlink.common.entity;

import java.util.List;

/**
 * 用户
 * Created by zql on 2016/5/3 0003.
 */
public class User extends BaseEntity<User> {

    private static final long serialVersionUID = 1L;
    private String userName;//登录名
    private String password;//登录密码
    private String salt;
    private List<Role> roles;
    private List<Menu> menus;
    private List<String> roleNames;//用于权限注入
    private List<String> menuNames;//用于权限注入

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }

    public List<String> getMenuNames() {
        return menuNames;
    }

    public void setMenuNames(List<String> menuNames) {
        this.menuNames = menuNames;
    }
}
