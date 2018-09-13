package com.colin.ctravel.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;

    private String account;

    private String nickname;

    private String passworld;

    private Integer gender;

    private String headUrl;

    private Boolean fromWx;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld == null ? null : passworld.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public Boolean getFromWx() {
        return fromWx;
    }

    public void setFromWx(Boolean fromWx) {
        this.fromWx = fromWx;
    }
}