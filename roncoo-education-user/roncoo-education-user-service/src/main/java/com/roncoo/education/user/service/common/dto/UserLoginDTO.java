package com.roncoo.education.user.service.common.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @autohor:wangkun
 * @date 2019-05-18-0:37
 * @email:wk20041208@126.com
 */
@Data
@Accessors(chain = true)
public class UserLoginDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 用户编号
     */
    @ApiModelProperty(value = "用户编号")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userNo;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;
    /**
     * token，设置有效期为1天
     */
    @ApiModelProperty(value = "token，有效期为1天")
    private String token;
}
