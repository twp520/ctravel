package com.colin.ctravel.entity.result;

import java.io.Serializable;
import java.sql.Timestamp;

public class PostResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private String destination;

    private String departure;

    private Timestamp startTime;

    private String contact;

    private Integer userid;

    private String content;

    private String imgs;

    private Timestamp createTime;

    private UserResult user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp starttime) {
        this.startTime = starttime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public UserResult getUser() {
        return user;
    }

    public void setUser(UserResult user) {
        this.user = user;
    }
}
