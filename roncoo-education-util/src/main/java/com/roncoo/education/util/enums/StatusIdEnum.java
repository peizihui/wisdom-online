package com.roncoo.education.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @autohor:wangkun
 * @date 2019-05-07-23:15
 * @email:wk20041208@126.com
 */
@Getter
@AllArgsConstructor
public enum StatusIdEnum {
    YES(1,"正常",""),NO(0,"禁用","red");
    private Integer code;

    private String desc;

    private String color;
}
