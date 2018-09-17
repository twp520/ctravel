package com.colin.ctravel.controller;

import com.colin.ctravel.entity.BaseResult;
import com.colin.ctravel.entity.User;
import com.colin.ctravel.service.UserService;
import com.colin.ctravel.utils.Base64Util;
import com.colin.ctravel.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    BaseResult login(@RequestParam("account") String account,
                     @RequestParam("passworld") String passworld) {
        User user = userService.findUserByAccount(account);
        if (null == user) {
            return ResultUtil.requestFail("用户不存在！");
        }
        if (!passworld.equals(user.getPassworld())) {
            return ResultUtil.requestFail("密误！");
        }
        //生成一个token 字符串 userId=id
        String token = Base64Util.encodeText(("userId=" + user.getId()));
        user.setToken(token);
        return ResultUtil.requestSuccess(userService.removePwd(user));
    }

    @GetMapping("/test")
    BaseResult test() {
        return ResultUtil.requestSuccess("测试成功");
    }

    @PostMapping("/register")
    BaseResult register(String account, String nickname, String passworld, Integer gender, String headUrl) {
        User user = userService.findUserByAccount(account);
        if (user != null) {
            return ResultUtil.requestFail("用户已经存在！");
        }
        User iUser = new User();
        iUser.setAccount(account);
        iUser.setNickname(nickname);
        iUser.setHeadUrl(headUrl);
        iUser.setPassworld(passworld);
        iUser.setGender(gender);
        int row = userService.registerUser(iUser);
        if (row > 0) {
            //TODO 生成token 并且去掉密码
            iUser.setPassworld("");
            return ResultUtil.requestSuccess(iUser);
        }
        return ResultUtil.requestSuccess("");
    }
}
