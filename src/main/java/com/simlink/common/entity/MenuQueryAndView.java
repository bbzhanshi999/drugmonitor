package com.simlink.common.entity;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class MenuQueryAndView extends Menu {
    private static final long serialVersionUID = 1L;
    private String roleId;
    private String menuId;

    public MenuQueryAndView(){
        super();
    }

    public MenuQueryAndView(String roleId, String menuId) {
        this.menuId = menuId;
        this.roleId = roleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
