package com.colin.ctravel.controller;

import com.colin.ctravel.entity.BaseResult;
import com.colin.ctravel.entity.Comment;
import com.colin.ctravel.entity.Post;
import com.colin.ctravel.entity.result.CommentResult;
import com.colin.ctravel.entity.result.UserResult;
import com.colin.ctravel.service.PostService;
import com.colin.ctravel.service.UserService;
import com.colin.ctravel.utils.Base64Util;
import com.colin.ctravel.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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

        if (post.getImgs() == null || post.getImgs().equals("")) {
            //TODO 为post添加一个默认的图片
            post.setImgs("");
        }
        int row = postService.addOnePost(post);
        if (row > 0) {
            //成功后为他添加一条评论
            return ResultUtil.requestSuccess("发送成功");
        }
        return ResultUtil.requestFail("未知错误");
    }

    /**
     * 对帖子进行评论
     *
     * @param request 请求
     * @param content 评论内容
     * @param postId  帖子 id
     * @param atUid   @的人的id  保留
     * @return 当前评论体
     */
    @PostMapping("/commentPost")
    public BaseResult commentPost(HttpServletRequest request, String content, Integer postId, Integer atUid) {
        Integer uid = Base64Util.decodeUidByToken(request);
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setPostId(postId);
        comment.setSendUid(uid);
        comment.setAtUid(atUid);
        int row = postService.commentPost(comment);
        if (row > 0) {
            comment.setTime(Timestamp.from(Instant.now()).getTime());
            CommentResult result = new CommentResult(comment);
            UserResult ur = userService.findUserById(uid);
            result.setOwnUser(ur);
            return ResultUtil.requestSuccess(result);
        }

        return ResultUtil.requestFail("未知错误");
    }

    /**
     * 根据postID获取评论
     *
     * @param postId 帖子ID
     * @return 评论列表
     */
    @GetMapping("/getCommentByPostId")
    public BaseResult getCommentByPostId(Integer postId) {
        try {
            List<CommentResult> listByPostId = postService.getCommentListByPostId(postId);
            if (listByPostId == null) {
                listByPostId = new ArrayList<>();
            }
            return ResultUtil.requestSuccess(listByPostId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.requestFail("未知错误: " + e.getMessage());
        }
    }
}
