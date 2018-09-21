package com.colin.ctravel.service;

import com.colin.ctravel.entity.User;
import com.colin.ctravel.entity.result.UserResult;

public interface UserService {

    User findUserByAccount(String account);

    boolean hasUserById(int id);

    int registerUser(User user);

    UserResult findUserById(Integer id);
}
