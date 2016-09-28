package com.simlink.sinosoft.drugmonitor.entity;

import com.simlink.common.entity.BaseEntity;

/**
 * 地区bean
 * Created by Administrator on 2016/9/27 0027.
 */
public class Area extends BaseEntity<Area> {

    private static final long serialVersionUID = 1L;
    private String areaName;
    private String areaEname;
    private String areaCode;

    public Area() {
        super();
    }

    public Area(String id, String areaName) {
        this.id = id;
        this.areaName = areaName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaEname() {
        return areaEname;
    }

    public void setAreaEname(String areaEname) {
        this.areaEname = areaEname;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
