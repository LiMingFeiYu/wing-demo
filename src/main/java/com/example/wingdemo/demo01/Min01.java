package com.example.wingdemo.demo01;

import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Scanner;

public class Min01 {
    public static void main(String[] args) {
        String data = "AAOCAAADngAAAAAAAAAAAAAAAAAAAAAAAAOeAAAAAAAAAAAAABOFGWAAAAASAQEItgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD6AAAAAAAAANDAAAAAAABAAAAAAAAAAEBDgCqGWQAAAAAAAAAAAAABdwAAKxb";
        // TODO Auto-generated method stub
        byte[] bytes = decodeBase64(data);
        String Base16Str = bytes2Hex(bytes);
        String substring1 = Base16Str.substring(44, 52);
        System.out.println(substring1);
        StringBuffer base10=new StringBuffer();
        while (Base16Str.length() > 0) {
            try {
                System.out.println(Base16Str);
                String substring = Base16Str.substring(0, 8);
                Base16Str = Base16Str.replace(substring, "");
                System.out.println(substring);
                base10.append(new BigInteger(substring, 16).toString());
//                System.out.println(bigInteger);
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
        String substring = base10.substring(45, 52);


        System.out.println(base10);
        System.out.println(substring);


    }



    public static byte[] decodeBase64(String buf) {
        try {
            return (new BASE64Decoder()).decodeBuffer(buf);
        } catch (IOException e) {
        }
        return null;
    }

    private static final char[] HEXES = {
            '0', '1', '2', '3',
            '4', '5', '6', '7',
            '8', '9', 'A', 'B',
            'C', 'D', 'E', 'F'
    };

    /**
     * byte数组 转换成 16进制小写字符串
     */
    public static String bytes2Hex(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }

        StringBuilder hex = new StringBuilder();

        for (byte b : bytes) {
            hex.append(HEXES[(b >> 4) & 0x0F]);
            hex.append(HEXES[b & 0x0F]);
        }

        return hex.toString();
    }

    /**
     * 字符串转换unicode
     */
    public static String string2Unicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
// 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }
}
