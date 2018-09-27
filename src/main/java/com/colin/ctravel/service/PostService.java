package com.colin.ctravel.service;

import com.colin.ctravel.entity.Comment;
import com.colin.ctravel.entity.Favorite;
import com.colin.ctravel.entity.Post;
import com.colin.ctravel.entity.result.CommentResult;
import com.colin.ctravel.entity.result.PostResult;

import java.util.List;

public interface PostService {

    List<PostResult> findAllPost();


    int addOnePost(Post post);


    int commentPost(Comment comment);

    List<CommentResult> getCommentListByPostId(Integer postId);

    int favPost(Favorite favorite);

    List<PostResult> getUserFavPosts(Integer userId);
}
