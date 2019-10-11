package com.roncoo.education.user.service.api;

import com.roncoo.education.user.service.biz.ApiUserInfoBiz;
import com.roncoo.education.user.service.common.bo.UserLoginPasswordBO;
import com.roncoo.education.user.service.common.bo.UserRegisterBO;
import com.roncoo.education.user.service.common.bo.UserSendCodeBO;
import com.roncoo.education.user.service.common.dto.UserLoginDTO;
import com.roncoo.education.util.base.BaseController;
import com.roncoo.education.util.base.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @autohor:wangkun
 * @date 2019-05-18-0:33
 * @email:wk20041208@126.com
 */
/**
 * 用户基本信息
 */
@RestController
@RequestMapping(value = {"/user/api/user"})
@CrossOrigin(origins = {"*"})
public class ApiUserInfoController extends BaseController {
    @Autowired
    private ApiUserInfoBiz apiUserInfoBiz;

    /**
     * 注册接口
     */
    @ApiOperation(value = "注册接口", notes = "注册成功返回登录信息")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result<UserLoginDTO> register(@RequestBody UserRegisterBO userRegisterBO) {
        return apiUserInfoBiz.register(userRegisterBO);
    }

    /**
     * 用户密码登录接口
     */
    @ApiOperation(value = "用户密码登录接口", notes = "用户密码登录")
    @RequestMapping(value = "/login/password", method = RequestMethod.POST)
    @ResponseBody
    public Result<UserLoginDTO> loginPassword(@RequestBody UserLoginPasswordBO userLoginPasswordBO){
        return apiUserInfoBiz.loginPassword(userLoginPasswordBO);
    }

    /**
     * 验证码发送接口
     */
    @ApiOperation(value = "验证码发送接口", notes = "发送手机验证码")
    @RequestMapping(value = "/send/code", method = RequestMethod.POST)
    public Result<String> sendCode(@RequestBody UserSendCodeBO userSendCodeBO) {
        return apiUserInfoBiz.sendCode(userSendCodeBO);
    }
}
