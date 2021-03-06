package com.colin.ctravel.service.imp;

import com.colin.ctravel.dao.CommentMapper;
import com.colin.ctravel.dao.FavoriteMapper;
import com.colin.ctravel.dao.PostMapper;
import com.colin.ctravel.entity.Comment;
import com.colin.ctravel.entity.Favorite;
import com.colin.ctravel.entity.Post;
import com.colin.ctravel.entity.result.CommentResult;
import com.colin.ctravel.entity.result.PostResult;
import com.colin.ctravel.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImp implements PostService {

    private final PostMapper postMapper;
    private final CommentMapper commentMapper;
    private final FavoriteMapper favoriteMapper;

    @Autowired
    public PostServiceImp(PostMapper postMapper, CommentMapper commentMapper, FavoriteMapper favoriteMapper) {
        this.postMapper = postMapper;
        this.commentMapper = commentMapper;
        this.favoriteMapper = favoriteMapper;
    }

    @Override
    public List<PostResult> findAllPost() {
        return postMapper.findAllPost();
    }

    @Override
    public int addOnePost(Post post) {
        return postMapper.insertPost(post);
    }

    @Override
    public int commentPost(Comment comment) {
        return commentMapper.insertSelective(comment);
    }

    @Override
    public List<CommentResult> getCommentListByPostId(Integer postId) {
        return commentMapper.selectByPostId(postId);
    }

    @Override
    public int favPost(Favorite favorite) {
        return favoriteMapper.insertSelective(favorite);
    }

    @Override
    public List<PostResult> getUserFavPosts(Integer userId) {
        return favoriteMapper.getUserFavPost(userId);
    }

    @Override
    public Boolean queryUserFavorite(Integer userId, Integer postId) {
        try {
            int row = favoriteMapper.queryFavorite(userId, postId);
            return row == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
