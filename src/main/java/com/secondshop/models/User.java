package com.secondshop.models;

import java.text.SimpleDateFormat;

/**
 * 用户表
 *
 * @author WEN
 *
 */
public class User {
    //用户ID
    private int id;
    //用户昵称
    private String name;
    //手机号
    private String mobile;
    //邮箱
    private String email;
    //密码
    private String password;
    //密码
    private String password2;
    //用户标签
    private String code;
    //头像地址
    private String photoUrl;
    //角色编号
    private int roleId;
    //状态编号
    private int statusId;
    //性别
    private String gender;
    //头像地址
    private String registerDate;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(java.sql.Timestamp registerDate) {//注册时间成员函数
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.registerDate = sdf.format(registerDate);
    }

}
