package com.roncoo.education.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @autohor:wangkun
 * @date 2019-05-18-1:10
 * @email:wk20041208@126.com
 */

@Getter
@AllArgsConstructor
public enum LoginStatusEnum {

    SUCCESS(1, "登录成功", ""),
    //
    FAIL(0, "登录失败", "red");

    private Integer code;

    private String desc;

    private String color;
}
