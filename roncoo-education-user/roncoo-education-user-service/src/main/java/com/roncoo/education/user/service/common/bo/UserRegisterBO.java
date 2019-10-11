package com.roncoo.education.user.service.common.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @autohor:wangkun
 * @date 2019-05-18-1:16
 * @email:wk20041208@126.com
 */

@Data
@Accessors(chain = true)
public class UserRegisterBO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机", required = true)
    private String mobile;
    /**
     * 登录密码
     */
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    /**
     * 重复密码
     */
    @ApiModelProperty(value = "重复密码", required = true)
    private String repassword;
    /**
     * clientId
     */
    @ApiModelProperty(value = "clientId", required = true)
    private String clientId;
    /**
     * 手机验证码
     */
    @ApiModelProperty(value = "手机验证码", required = true)
    private String code;

    private String ip;
}
