package com.colin.ctravel.service.imp;

import com.colin.ctravel.dao.UserMapper;
import com.colin.ctravel.entity.User;
import com.colin.ctravel.entity.result.UserResult;
import com.colin.ctravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {


    private final UserMapper mapper;

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
    public boolean hasUserById(int id) {
        if (id == 0 || id == -1) {
            return false;
        }
        UserResult user = mapper.selectByPrimaryKey(id);
        return user != null;
    }

    @Override
    public int registerUser(User user) {
        if (user == null)
            return 0;
        return mapper.insertUser(user);
    }
}
