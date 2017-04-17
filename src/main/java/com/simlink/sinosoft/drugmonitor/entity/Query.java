package com.simlink.sinosoft.drugmonitor.entity;

import com.simlink.common.entity.BaseEntity;

import java.util.Date;

/**
 * 查询包装
 * Created by Administrator on 2017/4/14 0014.
 */
public class Query extends BaseEntity<Query>{
    private static final long serialVersionUID = 1L;
    private String instoreType;
    private String outstoreType;
    private String institution;
    private Date startDate;
    private Date endDate;
    private String drugName;
    private String period;
    private String index;
    private String supporter;
    private String prescriptionType;
    private String vaccine;
    private String drugType;
    private Date monthDate;
    public String getInstoreType() {
        return instoreType;
    }

    public void setInstoreType(String instoreType) {
        this.instoreType = instoreType;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getOutstoreType() {
        return outstoreType;
    }

    public void setOutstoreType(String outstoreType) {
        this.outstoreType = outstoreType;
    }

    public String getSupporter() {
        return supporter;
    }

    public void setSupporter(String supporter) {
        this.supporter = supporter;
    }

    public String getPrescriptionType() {
        return prescriptionType;
    }

    public void setPrescriptionType(String prescriptionType) {
        this.prescriptionType = prescriptionType;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public Date getMonthDate() {
        return monthDate;
    }

    public void setMonthDate(Date monthDate) {
        this.monthDate = monthDate;
    }
}
