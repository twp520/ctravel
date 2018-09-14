package com.colin.ctravel.controller;

import com.colin.ctravel.entity.BaseResult;
import com.colin.ctravel.entity.Post;
import com.colin.ctravel.service.PostService;
import com.colin.ctravel.service.UserService;
import com.colin.ctravel.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final UserService userService;


    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    //获取所有的行程帖子
    @GetMapping("/getPosts")
    public BaseResult getPosts() {
        return ResultUtil.requestSuccess(postService.findAllPost());
    }

    @PostMapping("/sendPost")
    public BaseResult sendPost(Post post) {
        if (post == null)
            return ResultUtil.requestFail("未知错误");
        if (post.getUserId() == 0 || post.getUserId() == -1) {
            return ResultUtil.requestFail("用户不存在");
        }
        if (!userService.hasUserById(post.getUserId())) {
            return ResultUtil.requestFail("用户不存在");
        }
        int row = postService.addOnePost(post);
        if (row > 0) {
            return ResultUtil.requestSuccess("发送成功");
        }
        return ResultUtil.requestFail("未知错误");
    }
}
