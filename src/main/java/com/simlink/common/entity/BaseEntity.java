package com.simlink.common.entity;


import com.simlink.common.utils.IdGen;
import com.simlink.common.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础bean，
 * Created by Administrator on 2016/4/28 0028.
 */
public class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 删除标记（N：正常；Y：删除）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";

    public static final String YES = "Y";
    public static final String NO = "N";


    public BaseEntity(){
        this.delFlag = DEL_FLAG_NORMAL;
    }

    public BaseEntity(String id) {
        this();
        this.id = id;
    }

    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     */
    protected boolean isNewRecord = false;


    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     *
     * @return
     */
    public boolean getIsNewRecord() {
        return isNewRecord || StringUtils.isBlank(getId());
    }

    public void setIsNewRecord(boolean isNewRecord) {
        this.isNewRecord = isNewRecord;
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert() {
        // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
        if (!this.isNewRecord) {
            setId(IdGen.uuid());
        }
        User user = UserUtils.getCurrentUser();
        if (StringUtils.isNotBlank(user.getId())) {
            this.creator = UserUtils.getCurrentUser();
        }
        this.updateTime = new Date();
        this.createTime = this.updateTime;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate() {
        this.updateTime = new Date();
        this.updater = UserUtils.getCurrentUser();
    }


    protected String id;//id

    protected User creator;//创建人

    protected User updater;//最后修改人

    protected Date updateTime;//最后修改时间

    protected Date createTime;//创建时间

    protected String delFlag;//删除标记位

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getUpdater() {
        return updater;
    }

    public void setUpdater(User updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
