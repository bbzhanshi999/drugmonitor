package com.simlink.sinosoft.drugmonitor.entity;
import com.simlink.common.entity.BaseEntity;

/**
 * 组织机构
 * Created by Administrator on 2016/9/27 0027.
 */
public class Organization extends BaseEntity<Organization> {

    private static final long serialVersionUID = 1L;
    private String organCode;
    private String organName;
    private String organEname;

    public Organization(){
        super();
    }

    public Organization(String id, String organName) {
        this.id = id;
        this.organName = organName;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getOrganEname() {
        return organEname;
    }

    public void setOrganEname(String organEname) {
        this.organEname = organEname;
    }
}
