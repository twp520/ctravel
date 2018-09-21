package com.colin.ctravel.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable {
    private Integer id;

    private String content;

    private Integer postId;

    private Integer sendUid;

    private Timestamp createTime;

    private Integer atUid;

    private Long time;

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

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getSendUid() {
        return sendUid;
    }

    public void setSendUid(Integer sendUid) {
        this.sendUid = sendUid;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getAtUid() {
        return atUid;
    }

    public void setAtUid(Integer atUid) {
        this.atUid = atUid;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}