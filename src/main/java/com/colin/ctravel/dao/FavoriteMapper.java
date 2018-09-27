package com.colin.ctravel.dao;

import com.colin.ctravel.entity.Favorite;
import com.colin.ctravel.entity.result.PostResult;

import java.util.List;

public interface FavoriteMapper {


    int insertSelective(Favorite record);


    List<PostResult> getUserFavPost(Integer userId);
}