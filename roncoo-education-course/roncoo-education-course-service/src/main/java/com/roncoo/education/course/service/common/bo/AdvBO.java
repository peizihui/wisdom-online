package com.roncoo.education.course.service.common.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @autohor:wangkun
 * @date 2019-05-20-2:06
 * @email:wk20041208@126.com
 */
@Data
@Accessors(chain = true)
public class AdvBO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 位置(0电脑端，1微信端)
     */
    @ApiModelProperty(value = "位置(0电脑端，1微信端)")
    private Integer platShow;


}
