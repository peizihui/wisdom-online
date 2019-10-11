package com.roncoo.education.user.service.common.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @autohor:wangkun
 * @date 2019-05-18-1:54
 * @email:wk20041208@126.com
 */
@Data
@Accessors(chain = true)
public class UserSendCodeBO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 手机号码
     */
    private String mobile;
    /**
     * clientId
     */
    private String clientId;
}
