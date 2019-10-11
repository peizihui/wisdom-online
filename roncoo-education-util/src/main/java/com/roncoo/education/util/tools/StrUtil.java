package com.roncoo.education.util.tools;

import com.xiaoleilu.hutool.crypto.SecureUtil;

import java.util.Random;

/**
 * @autohor:wangkun
 * @date 2019-05-18-1:29
 * @email:wk20041208@126.com
 */
public class StrUtil {

    private StrUtil() {
    }

    public static String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public static String getPrefix(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    /**
     * @return
     */
    public static String getRandom(int bound) {
        Random ra = new Random();
        String result = "";
        for (int i = 1; i <= bound; i++) {
            result += ra.nextInt(10);
        }
        return result;
    }

    public static String get32UUID() {
        return SecureUtil.simpleUUID();
    }
}
