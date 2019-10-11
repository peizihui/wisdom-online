package com.roncoo.education.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @autohor:wangkun
 * @date 2019-05-18-2:20
 * @email:wk20041208@126.com
 */
@Getter
@AllArgsConstructor
public enum IsSuccessEnum {
    SUCCESS(1, "成功", "green"), FAIL(0, "失败", "red");

    private Integer code;

    private String desc;

    private String color;
}
