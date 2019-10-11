package com.roncoo.education.util.tools;

import javax.servlet.http.HttpServletRequest;

/**
 * @autohor:wangkun
 * @date 2019-04-26-15:09
 * @email:wk20041208@126.com
 */
public class WebUtil {
    private static final String PREFIX = "s_";


    private WebUtil(){

    }

    /**
     * 判断是否为ajax请求
     *
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request){
        return request.getHeader("x-requested-with") != null
                && request.getHeader("x-requested-with").
                equalsIgnoreCase("XMLHttpRequest");
    }
}
