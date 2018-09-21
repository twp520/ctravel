package com.colin.ctravel.dao;

import com.colin.ctravel.entity.Post;

public interface PostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostWithBLOBs record);

    int insertSelective(PostWithBLOBs record);

    PostWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PostWithBLOBs record);

    int updateByPrimaryKey(Post record);
}