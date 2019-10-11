package com.roncoo.education.system.service.common.bo;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @autohor:wangkun
 * @date 2019-05-08-16:28
 * @email:wk20041208@126.com
 */
@Data
@Accessors(chain = true)
public class MsgViewBO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Long id;

}
