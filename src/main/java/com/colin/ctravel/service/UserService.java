package com.colin.ctravel.service;

import com.colin.ctravel.entity.User;

public interface UserService {

    User findUserByAccount(String account);

    boolean hasUserById(int id);

    int registerUser(User user);
}
