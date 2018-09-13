package com.colin.ctravel.utils;

import com.colin.ctravel.entity.BaseResult;

import static com.colin.ctravel.utils.Contanst.*;

public class ResultUtil {


    public static BaseResult requestSuccess(Object data) {
        return new BaseResult(CODE_SUCCESS, MSG_SUCCESS, data);
    }


    public static BaseResult requestFail(String msg) {
        return new BaseResult(CODE_FAIL, msg, null);
    }
}
