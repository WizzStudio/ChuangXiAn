package com.chuangxian.util;

import java.util.Random;

/**
 * @author ：Maolin
 * @className ：RandomUtil
 * @date ：Created in 2019/7/8 22:15
 * @description： Random number and String
 * @version: 1.0
 */
public class RandomUtil {

    private static Random random;

    private static final char[] words = {'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'U', 'u', 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    static {
        random = new Random();
    }

    /**
     * 生成length位(数字+大小写字母)的随机字符串
     */
    public static String getSixRandom(int length) {
        return getRandomString(length);
    }


    /**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     *
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    private static String getRandomString(int length) {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < length; i++) {
            key.append(words[random.nextInt(words.length)]);
        }
        return key.toString();
    }
}
