package com.colin.ctravel.dao;

import com.colin.ctravel.entity.Comment;
import com.colin.ctravel.entity.result.CommentResult;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<CommentResult> selectByPostId(Integer postId);
}