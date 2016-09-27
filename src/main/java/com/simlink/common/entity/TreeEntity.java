/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.simlink.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * 数据Entity类
 * @author zql
 */
public abstract class TreeEntity<T,C> extends BaseEntity<T> {

    private static final long serialVersionUID = 1L;

    public static String ROOTNODE="0";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    protected String text; //节点显示名称
    protected T parent;    // 父级节点
    protected String pids; // 所有父级编号
    protected String parentId;//父节点编号
    protected Integer index;        // 排序
    protected String leaf;//是否为子节点
    protected Boolean checked = false;//是否为子节点
    protected String iconCls;//图标样式
    protected String id;//id
    protected Boolean expandable =true;//是否可扩展
    protected Boolean loaded=false;//前台treelist必要属性，默认表示已经加载完毕
    protected List<C> children = Lists.newArrayList(); //子节点集合
    protected Map<String,Object> attributes = Maps.newHashMap(); //属性集合


    public List<C> getChildren() {
        return children;
    }

    public void setChildren(List<C> children) {
        this.children = children;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getLeaf() {
        return leaf;
    }

    public void setLeaf(String leaf) {
        this.leaf = leaf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getExpandable() {
        return expandable;
    }

    public void setExpandable(Boolean expandable) {
        this.expandable = expandable;
    }

    public Boolean getLoaded() {
        return loaded;
    }

    public void setLoaded(Boolean loaded) {
        this.loaded = loaded;
    }



    public TreeEntity() {
        super();
        this.index = 30;
    }

    public TreeEntity(String guid) {
        super(guid);
    }

    /**
     * 父对象，只能通过子类实现，父类实现mybatis无法读取
     *
     * @return
     */
    @JsonBackReference
    @NotNull
    public abstract T getParent();

    /**
     * 父对象，只能通过子类实现，父类实现mybatis无法读取
     *
     * @return
     */
    public abstract void setParent(T parent);

    @Length(min = 1, max = 2000)
    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }


    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getParentId() {
       return parentId;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
