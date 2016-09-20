package com.simlink.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

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
    private String isShow;
    private String isDefault;


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

    @JsonIgnore
    public static void sortList(List<Menu> list, List<Menu> sourcelist, String parentId, boolean cascade){
        for (int i=0; i<sourcelist.size(); i++){
            Menu e = sourcelist.get(i);
            if (e.getParentId()!=null && e.getParent().getId()!=null
                    && e.getParent().getId().equals(parentId)){
                list.add(e);
                if (cascade){
                    // 判断是否还有子节点, 有则继续获取子节点
                    for (int j=0; j<sourcelist.size(); j++){
                        Menu child = sourcelist.get(j);
                        if (child.getParent()!=null && child.getParent().getId()!=null
                                && child.getParent().getId().equals(e.getId())){
                            sortList(list, sourcelist, e.getId(), true);
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * 建立完整的同部树
     * @param orginList
     * @return
     */
    @JsonIgnore
    public static List<Menu> buildList(List<Menu> orginList){
        List<Menu> list = Lists.newArrayList();

        for(Menu m:orginList){
            if(StringUtils.isBlank(m.getParentId())||ROOTNODE.equals(m.getParentId())){
                buildChildren(orginList,m);
                list.add(m);
            }
        }

        return list;
    }


    @JsonIgnore
    public static void buildChildren(List<Menu> orginList,Menu menu) {
        List<Menu> children  = Lists.newArrayList();
        for(Menu m :orginList){
            if(menu.getId().equals(m.getParentId())){
                children.add(m);
                if(TreeEntity.NO.equals(m.getType())){
                    buildChildren(orginList, m);
                }
            }
        }
        if(children.size()>0){
            menu.setChildren(children);
        }else{
            menu.setLoaded(true);//防止异步
        }
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

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String show) {
        isShow = show;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}
