package com.roncoo.education.user.service.biz.auth;

import com.roncoo.education.system.feign.IBossSys;
import com.roncoo.education.user.service.common.bo.auth.AuthUserExtViewBO;
import com.roncoo.education.user.service.common.dto.auth.AuthUserExtDTO;
import com.roncoo.education.user.service.dao.UserExtDao;
import com.roncoo.education.user.service.dao.impl.mapper.entity.UserExt;
import com.roncoo.education.util.base.BaseBiz;
import com.roncoo.education.util.base.Result;
import com.roncoo.education.util.tools.BeanUtil;
import com.xiaoleilu.hutool.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @autohor:wangkun
 * @date 2019-05-19-18:49
 * @email:wk20041208@126.com
 */
@Component
public class AuthApiUserExtBiz extends BaseBiz {

    @Autowired
    private UserExtDao userExtDao;

    @Autowired
    private IBossSys bossSys;
    /**
     * 用户信息查看接口
     */
    public Result<AuthUserExtDTO> view(AuthUserExtViewBO authUserExtViewBO) {
        if (ObjectUtil.isNull(authUserExtViewBO)) {
            return Result.error("authUserExtUserNoBO不能为空");
        }
        if (null == authUserExtViewBO.getUserNo()) {
            return Result.error("userNo不能为空");
        }
        UserExt userExt = userExtDao.getByUserNo(authUserExtViewBO.getUserNo());
        if (userExt == null) {
            return Result.error("找不到该用户信息");
        }
        return Result.success(BeanUtil.copyProperties(userExt, AuthUserExtDTO.class));
    }
}
