package com.colin.ctravel.entity.result;

import java.io.Serializable;

public class UserResult implements Serializable {
    private Integer id;

    private String account;

    private String nickname;

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
        this.account = account;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
