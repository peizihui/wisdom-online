package com.roncoo.education.system.service.common.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @autohor:wangkun
 * @date 2019-05-08-16:28
 * @email:wk20041208@126.com
 */
@Data
@Accessors(chain = true)
public class MsgReadDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户站内信未读条数
	 */
	@ApiModelProperty(value = "用户站内信未读条数")
	private Integer num;
}
