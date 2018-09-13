package com.colin.ctravel.controller;

import com.colin.ctravel.entity.BaseResult;
import com.colin.ctravel.entity.User;
import com.colin.ctravel.service.UserService;
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

        return ResultUtil.requestSuccess(userService.removePwd(user));
    }

    @GetMapping("/test")
    BaseResult test() {
        return ResultUtil.requestSuccess("测试成功");
    }

}
