package com.colin.ctravel.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Comment implements Serializable {
    private Integer id;

    private String content;

    private Integer postid;

    private Integer senduid;

    private Timestamp createtime;

    private Integer atuid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public Integer getSenduid() {
        return senduid;
    }

    public void setSenduid(Integer senduid) {
        this.senduid = senduid;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public Integer getAtuid() {
        return atuid;
    }

    public void setAtuid(Integer atuid) {
        this.atuid = atuid;
    }
}