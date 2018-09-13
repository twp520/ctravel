package com.colin.ctravel.service;

import com.colin.ctravel.entity.Post;
import com.colin.ctravel.entity.result.PostResult;

import java.util.List;

public interface PostService {

    List<PostResult> findAllPost();


    int addOnePost(Post post);


}
