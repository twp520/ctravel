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
            return ResultUtil.requestFail("密码错误！");
        }
        //生成一个token 字符串 userId=id
        String token = Base64Util.createToken(user.getId());
        user.setToken(token);
        user.setPassworld("");
        return ResultUtil.requestSuccess(user);
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
        iUser.setPassworld(passworld);
        iUser.setGender(gender);
        //设置一个默认头像链接
        if (headUrl != null && !headUrl.equals("")) {
            iUser.setHeadUrl(headUrl);
        } else {
            String head;
            if (gender == 0) {
                head = "http://colin-ctravel-pictuer.oss-cn-beijing.aliyuncs.com/photo/head_def_boy.jpeg";
            } else if (gender == 1) {
                head = "http://colin-ctravel-pictuer.oss-cn-beijing.aliyuncs.com/photo/head_def_girl.jpeg";
            } else {
                head = "http://colin-ctravel-pictuer.oss-cn-beijing.aliyuncs.com/photo/head_def_et.jpg";
            }
            iUser.setHeadUrl(head);
        }
        int row = userService.registerUser(iUser);
        if (row > 0) {
            //TODO 生成token 并且去掉密码
            User rUser = userService.findUserByAccount(account);
            rUser.setToken(Base64Util.createToken(rUser.getId()));
            rUser.setPassworld("");
            return ResultUtil.requestSuccess(rUser);
        }
        return ResultUtil.requestFail("未知错误");
    }
}
