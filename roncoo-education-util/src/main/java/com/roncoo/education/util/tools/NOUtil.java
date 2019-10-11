package com.roncoo.education.util.tools;

import com.xiaoleilu.hutool.date.DateUtil;
import com.xiaoleilu.hutool.util.RandomUtil;

import java.util.Date;

/**
 * @autohor:wangkun
 * @date 2019-05-18-1:28
 * @email:wk20041208@126.com
 */

/**
 * 时间+随机数，一定几率是会重复的，但忽略这个，数据库校验了唯一性
 */
public class NOUtil {

    private NOUtil() {
    }

    public static Long getOrderNo() {
        return Long.valueOf(DateUtil.format(new Date(), Constants.DATE.YYYYMMDDHHMMSS) + RandomUtil.randomNumbers(3));
    }

    public static Long getSerialNumber() {
        return Long.valueOf(DateUtil.format(new Date(), Constants.DATE.YYYYMMDDHHMMSS) + RandomUtil.randomNumbers(4));
    }

    public static Long getUserNo() {
        return Long.valueOf(DateUtil.format(new Date(), Constants.DATE.YYYYMMDDHHMMSS) + RandomUtil.randomNumbers(2));
    }

}
