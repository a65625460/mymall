package com.dong.mymall.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

// 实体类的基类
public class BaseDO implements Serializable {
    private static final long serialVersionUID = -3860636077719382941L;
    private String createUser;
    private Date createTime;
    private String modifiedUser;
    private Date modifiedTime;

    public BaseDO() {
    }

    public BaseDO(String createUser, Date createTime, String modifiedUser, Date modifiedTime) {
        this.createUser = createUser;
        this.createTime = createTime;
        this.modifiedUser = modifiedUser;
        this.modifiedTime = modifiedTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDO baseDO = (BaseDO) o;
        return Objects.equals(createUser, baseDO.createUser) &&
                Objects.equals(createTime, baseDO.createTime) &&
                Objects.equals(modifiedUser, baseDO.modifiedUser) &&
                Objects.equals(modifiedTime, baseDO.modifiedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createUser, createTime, modifiedUser, modifiedTime);
    }

    @Override
    public String toString() {
        return "BaseDO{" +
                "createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
