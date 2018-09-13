package com.colin.ctravel.service.imp;

import com.colin.ctravel.dao.PostMapper;
import com.colin.ctravel.entity.Post;
import com.colin.ctravel.entity.result.PostResult;
import com.colin.ctravel.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImp implements PostService {

    private final PostMapper postMapper;

    @Autowired
    public PostServiceImp(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public List<PostResult> findAllPost() {
        return postMapper.findAllPost();
    }

    @Override
    public int addOnePost(Post post) {
        return postMapper.insertPost(post);
    }
}
