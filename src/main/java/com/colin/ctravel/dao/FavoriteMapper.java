package com.colin.ctravel.dao;

import com.colin.ctravel.entity.Favorite;
import com.colin.ctravel.entity.result.PostResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavoriteMapper {


    int insertSelective(Favorite record);


    List<PostResult> getUserFavPost(Integer userId);

    int queryFavorite(@Param("userId") Integer userId, @Param("postId") Integer postId);
}