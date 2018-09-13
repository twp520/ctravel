package com.colin.ctravel.service;

import com.colin.ctravel.entity.User;

public interface UserService {

    User findUserByAccount(String account);

    User removePwd(User user);

    boolean hasUserById(int id);
}
