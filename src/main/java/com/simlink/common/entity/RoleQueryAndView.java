package com.simlink.common.entity;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class RoleQueryAndView extends Role {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String roleId;

    public RoleQueryAndView() {
        super();
    }

    public RoleQueryAndView(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
