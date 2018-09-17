package com.colin.ctravel.dao;

import com.colin.ctravel.entity.User;
import com.colin.ctravel.entity.result.UserResult;

public interface UserMapper {

    UserResult selectByPrimaryKey(Integer id);

    User selectByAccount(String account);

    int insertUser(User user);
}