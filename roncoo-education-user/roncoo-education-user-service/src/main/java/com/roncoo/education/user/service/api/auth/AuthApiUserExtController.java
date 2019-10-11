package com.roncoo.education.user.service.api.auth;

import com.roncoo.education.user.service.biz.auth.AuthApiUserExtBiz;
import com.roncoo.education.user.service.common.bo.auth.AuthUserExtViewBO;
import com.roncoo.education.user.service.common.dto.auth.AuthUserExtDTO;
import com.roncoo.education.util.base.BaseController;
import com.roncoo.education.util.base.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autohor:wangkun
 * @date 2019-05-19-18:46
 * @email:wk20041208@126.com
 */
@RestController
@RequestMapping(value = {"/auth/user/api/user/ext"})
public class AuthApiUserExtController extends BaseController {
    @Autowired
    private AuthApiUserExtBiz authApiUserExtBiz;



    /**
     * 用户信息查看接口
     */
    @ApiOperation(value = "用户信息查看接口", notes = "根据userNo获取用户信息接口")
    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public Result<AuthUserExtDTO> view(@RequestBody AuthUserExtViewBO authUserExtViewBO) {
        return authApiUserExtBiz.view(authUserExtViewBO);
    }
}
