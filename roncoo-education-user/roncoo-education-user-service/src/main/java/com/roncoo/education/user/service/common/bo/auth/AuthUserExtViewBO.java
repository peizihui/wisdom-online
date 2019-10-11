package com.roncoo.education.user.service.common.bo.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @autohor:wangkun
 * @date 2019-05-19-18:53
 * @email:wk20041208@126.com
 */
@Data
@Accessors(chain = true)
public class AuthUserExtViewBO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @ApiModelProperty(value = "用户编号")
    private Long userNo;
}
