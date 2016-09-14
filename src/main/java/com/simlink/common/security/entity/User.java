package com.simlink.common.security.entity;

/**
 * 用户
 * Created by zql on 2016/5/3 0003.
 */
public class User {

    private static final long serialVersionUID = 1L;
    private String dlm;//登录名
    private String dlmm;//登录密码
    private String yxdz;//邮箱地址
    private String gh ;//工号
    private String salt;


    public String getDlm() {
        return dlm;
    }

    public void setDlm(String dlm) {
        this.dlm = dlm;
    }

    public String getDlmm() {
        return dlmm;
    }

    public void setDlmm(String dlmm) {
        this.dlmm = dlmm;
    }

    public String getYxdz() {
        return yxdz;
    }

    public void setYxdz(String yxdz) {
        this.yxdz = yxdz;
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}

