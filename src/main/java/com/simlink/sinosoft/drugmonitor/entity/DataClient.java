package com.simlink.sinosoft.drugmonitor.entity;

import com.simlink.common.entity.BaseEntity;

/**
 * 数据用户bean
 * Created by Administrator on 2016/9/27 0027.
 */
public class DataClient extends BaseEntity<DataClient> {

    private static final long serialVersionUID = 1L;
    private String clientName;//登录名
    private String password;//登录密码
    private Organization organization;//机构id
    private Area area;//地区id
    private String organId;
    private String organName;
    private String areaId;
    private String areaName;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
