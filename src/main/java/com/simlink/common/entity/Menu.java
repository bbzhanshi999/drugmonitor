package com.simlink.common.entity;

/**
 * 菜单节点
 * Created by Administrator on 2016/9/14 0014.
 */
public class Menu extends TreeEntity<Menu,Menu>{

    private static final long serialVersionUID = 1L;
    private String menuName;
    private String url;//访问地址
    private String permission;//shiro权限标识

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public Menu getParent() {
        return parent;
    }

    @Override
    public void setParent(Menu parent) {
        this.parent = parent;
    }
}
