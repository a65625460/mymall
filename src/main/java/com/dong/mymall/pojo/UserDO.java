package com.dong.mymall.pojo;

import java.util.Date;
import java.util.Objects;

/**
 * 用户实体类
 */
public class UserDO extends BaseDO {
    private static final long serialVersionUID = -6379780257821412055L;
    private Long id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String nickname;
    private String phone;
    private Integer gender;
    private Integer age;
    private Integer isDelete;
    private String avatar;

    public UserDO() {
    }

    public UserDO(String createUser, Date createTime, String modifiedUser, Date modifiedTime, Long id, String username, String password, String salt, String email, String nickname, String phone, Integer gender, Integer age, Integer isDelete, String avatar) {
        super(createUser, createTime, modifiedUser, modifiedTime);
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
        this.isDelete = isDelete;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserDO userDO = (UserDO) o;
        return Objects.equals(id, userDO.id) &&
                Objects.equals(username, userDO.username) &&
                Objects.equals(password, userDO.password) &&
                Objects.equals(salt, userDO.salt) &&
                Objects.equals(email, userDO.email) &&
                Objects.equals(nickname, userDO.nickname) &&
                Objects.equals(phone, userDO.phone) &&
                Objects.equals(gender, userDO.gender) &&
                Objects.equals(age, userDO.age) &&
                Objects.equals(isDelete, userDO.isDelete) &&
                Objects.equals(avatar, userDO.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, username, password, salt, email, nickname, phone, gender, age, isDelete, avatar);
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", isDelete=" + isDelete +
                ", avatar='" + avatar + '\'' +
                "} " + super.toString();
    }
}
