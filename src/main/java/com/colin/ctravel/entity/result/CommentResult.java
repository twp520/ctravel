package com.colin.ctravel.entity.result;

import com.colin.ctravel.entity.Comment;

import java.io.Serializable;
import java.sql.Timestamp;

public class CommentResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String content;

    private Integer postId;

    private Integer sendUid;

    private UserResult ownUser;

    private Timestamp createTime;

    private Integer atUid;

    private Long time;

    public CommentResult() {

    }

    public CommentResult(Comment comment) {
        setId(comment.getId());
        setContent(comment.getContent());
        setTime(comment.getTime());
        setPostId(comment.getPostId());
        setSendUid(comment.getSendUid());
        setAtUid(comment.getAtUid());
    }

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
        this.content = content;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public UserResult getOwnUser() {
        return ownUser;
    }

    public void setOwnUser(UserResult ownUser) {
        this.ownUser = ownUser;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
        this.time = createTime.getTime();
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

    public Integer getSendUid() {
        return sendUid;
    }

    public void setSendUid(Integer sendUid) {
        this.sendUid = sendUid;
    }
}
