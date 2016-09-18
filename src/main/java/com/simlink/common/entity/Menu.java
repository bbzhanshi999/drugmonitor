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
    private String userId;
    private String type;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
