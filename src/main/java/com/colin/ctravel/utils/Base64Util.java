package com.colin.ctravel.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Util {

    public static String encodeText(String text) {
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

    public static String decodeText(String text) {
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] decodByte = decoder.decode(text.getBytes("UTF-8"));
            return new String(decodByte);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
