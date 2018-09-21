package com.colin.ctravel.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Util {

    private static String encodeText(String text) {
        try {
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] textByte = text.getBytes("UTF-8");
            byte[] encdByte = encoder.encode(textByte);
            return new String(encdByte);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String decodeText(String text) {
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] decodByte = decoder.decode(text.getBytes("UTF-8"));
            return new String(decodByte);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String createToken(Integer uid) {
        return encodeText("userId=" + uid);
    }

    public static Integer decodeUidByToken(HttpServletRequest request) {
        if (request == null || request.getHeader("token") == null || request.getHeader("token").isEmpty()) {
            return -1;
        }
        String token = request.getHeader("token");
        try {
            String uids = decodeText(token).substring(7);
            return Integer.parseInt(uids);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
