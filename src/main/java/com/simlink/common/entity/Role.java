package com.simlink.common.entity;

import java.util.List;

/**
 * 角色名
 * Created by Administrator on 2016/9/14 0014.
 */
public class Role extends TreeEntity<Role,Role>{

    private static final long serialVersionUID = 1L;
    private String name;
    private String ename;
    private String type;
    private List<Menu> menus;


    @Override
    public Role getParent() {
        return parent;
    }

    @Override
    public void setParent(Role parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

}
