package com.colin.ctravel.service.imp;

import com.colin.ctravel.dao.UserMapper;
import com.colin.ctravel.entity.User;
import com.colin.ctravel.entity.result.UserResult;
import com.colin.ctravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {


    final
    UserMapper mapper;

    @Autowired
    public UserServiceImp(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public User findUserByAccount(String account) {
        return mapper.selectByAccount(account);
//        return null;
    }

    @Override
    public User removePwd(User user) {
        User user1 = new User();
        user1.setAccount(user.getAccount());
        user1.setId(user.getId());
        user1.setNickname(user.getNickname());
        user1.setFromWx(user.getFromWx());
        user1.setGender(user.getGender());
        user1.setHeadUrl(user.getHeadUrl());
        return user1;
    }

    @Override
    public boolean hasUserById(int id) {
        if (id == 0 || id == -1) {
            return false;
        }
        UserResult user = mapper.selectByPrimaryKey(id);
        return user != null;
    }

}
