package com.roncoo.education.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @autohor:wangkun
 * @date 2019-05-20-17:39
 * @email:wk20041208@126.com
 */

@Getter
@AllArgsConstructor
public enum CategoryTypeEnum {
    COURSE(1, "课程分类"), RESOURCE(2, "资源分类");

    private Integer code;

    private String desc;
}
