package com.roncoo.education.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @autohor:wangkun
 * @date 2019-05-20-17:36
 * @email:wk20041208@126.com
 */
@Getter
@AllArgsConstructor
public enum CourseCategoryEnum {
    ORDINARY(1, "普通课程",""), RESOURCES(0, "资源区课程","red");

    private Integer code;

    private String desc;

    private String color;
}
