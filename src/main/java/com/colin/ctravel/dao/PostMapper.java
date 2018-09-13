package com.colin.ctravel.dao;

import com.colin.ctravel.entity.Post;
import com.colin.ctravel.entity.result.PostResult;

import java.util.List;

public interface PostMapper {

    Post selectByPrimaryKey(Integer id);

    List<PostResult> findAllPost();

    int insertPost(Post post);

}