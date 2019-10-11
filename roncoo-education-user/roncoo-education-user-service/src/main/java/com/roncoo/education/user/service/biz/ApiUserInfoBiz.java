package com.roncoo.education.user.service.biz;

import com.aliyuncs.exceptions.ClientException;
import com.roncoo.education.system.common.bean.vo.SysVO;
import com.roncoo.education.system.feign.IBossSys;
import com.roncoo.education.user.service.common.bo.UserLoginPasswordBO;
import com.roncoo.education.user.service.common.bo.UserRegisterBO;
import com.roncoo.education.user.service.common.bo.UserSendCodeBO;
import com.roncoo.education.user.service.common.dto.UserLoginDTO;
import com.roncoo.education.user.service.dao.*;
import com.roncoo.education.user.service.dao.impl.mapper.entity.*;
import com.roncoo.education.util.aliyun.Aliyun;
import com.roncoo.education.util.aliyun.AliyunUtil;
import com.roncoo.education.util.base.BaseBiz;
import com.roncoo.education.util.base.BaseException;
import com.roncoo.education.util.base.Result;
import com.roncoo.education.util.enums.IsSuccessEnum;
import com.roncoo.education.util.enums.LoginStatusEnum;
import com.roncoo.education.util.enums.StatusIdEnum;
import com.roncoo.education.util.enums.UserTypeEnum;
import com.roncoo.education.util.tools.*;
import com.xiaoleilu.hutool.crypto.DigestUtil;
import com.xiaoleilu.hutool.util.ObjectUtil;
import com.xiaoleilu.hutool.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/**
 * @autohor:wangkun
 * @date 2019-05-18-0:44
 * @email:wk20041208@126.com
 */
@Component
public class ApiUserInfoBiz extends BaseBiz {

    @Autowired
    private PlatformDao platformDao;
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserLogLoginDao userLogLoginDao;

    @Autowired
    private UserExtDao userExtDao;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private IBossSys bossSys;

    @Autowired
    private SendSmsLogDao sendSmsLogDao;


    public Result<UserLoginDTO> loginPassword(UserLoginPasswordBO userLoginPasswordBO){
        if(StringUtils.isEmpty(userLoginPasswordBO.getClientId())){
            return Result.error("clientId不能为空");
        }
        if (StringUtils.isEmpty(userLoginPasswordBO.getMobile())) {
            return Result.error("手机号不能为空");
        }
        if (StringUtils.isEmpty(userLoginPasswordBO.getPassword())) {
            return Result.error("密码不能为空");
        }
        Platform platform = platformDao.getByClientId(userLoginPasswordBO.getClientId());
        if(null == platform){
            return Result.error("该平台不存在");
        }
        if (!StatusIdEnum.YES.getCode().equals(platform.getStatusId())) {
            return Result.error("该平台状态异常，请联系管理员");
        }

        // 密码错误次数校验

        // 用户校验
        User user = userDao.getByMobile(userLoginPasswordBO.getMobile());
        if (null == user) {
            return Result.error("账号或者密码不正确");
        }
        // 密码校验
        if (!DigestUtil.sha1Hex(user.getMobileSalt() + userLoginPasswordBO.getPassword()).equals(user.getMobilePsw())) {
            loginLog(user.getUserNo(), userLoginPasswordBO.getClientId(), LoginStatusEnum.FAIL, userLoginPasswordBO.getIp());
            // 放入缓存，错误次数+1
            return Result.error("账号或者密码不正确");
        }

        // 登录日志
        loginLog(user.getUserNo(), userLoginPasswordBO.getClientId(), LoginStatusEnum.SUCCESS, userLoginPasswordBO.getIp());

        UserLoginDTO dto = new UserLoginDTO();
        dto.setUserNo(user.getUserNo());
        dto.setMobile(user.getMobile());
        dto.setToken(JWTUtil.create(user.getUserNo(), JWTUtil.DATE));

        // 登录成功，存入缓存，单点登录使用
        // redisTemplate.opsForValue().set(dto.getUserNo().toString(), dto.getToken(),
        // 1, TimeUnit.DAYS);

        return Result.success(dto);
    }
    private void loginLog(Long userNo, String clientId, LoginStatusEnum status, String ip) {
        UserLogLogin record = new UserLogLogin();
        record.setUserNo(userNo);
        record.setClientId(clientId);
        record.setLoginStatus(status.getCode());
        record.setLoginIp(ip);
        userLogLoginDao.save(record);
    }

    @Transactional
    public Result<UserLoginDTO> register(UserRegisterBO userRegisterBO) {
        if (StringUtils.isEmpty(userRegisterBO.getMobile())) {
            return Result.error("手机号不能为空");
        }
        if (StringUtils.isEmpty(userRegisterBO.getPassword())) {
            return Result.error("密码不能为空");
        }
        if (StringUtils.isEmpty(userRegisterBO.getClientId())) {
            return Result.error("clientId不能为空");
        }

        // 密码校验
        if (!userRegisterBO.getPassword().equals(userRegisterBO.getRepassword())) {
            return Result.error("2次密码不一致");
        }

        Platform platform = platformDao.getByClientId(userRegisterBO.getClientId());
        if (null == platform) {
            return Result.error("该平台不存在");
        }
        if (!StatusIdEnum.YES.getCode().equals(platform.getStatusId())) {
            return Result.error("该平台状态异常，请联系管理员");
        }

        // 验证码校验
        String redisSmsCode = redisTemplate.opsForValue().get(platform.getClientId() + userRegisterBO.getMobile());
        if (StringUtils.isEmpty(redisSmsCode)) {
            return Result.error("请输入验证码");
        }
        if (!redisSmsCode.equals(userRegisterBO.getCode())) {
            return Result.error("验证码不正确，请重新输入");
        }

        // 手机号重复校验
        User user = userDao.getByMobile(userRegisterBO.getMobile());
        if (null != user) {
            return Result.error("该手机号已经注册，请更换手机号");
        }

        // 用户注册
        user = register(userRegisterBO.getMobile(), userRegisterBO.getPassword(), platform.getClientId());

        UserLoginDTO dto = new UserLoginDTO();
        dto.setUserNo(user.getUserNo());
        dto.setMobile(user.getMobile());
        dto.setToken(JWTUtil.create(user.getUserNo(), JWTUtil.DATE));
        return Result.success(dto);
    }
    private User register(String mobile, String password, String clientId) {
        // 用户基本信息
        User user = new User();
        user.setUserNo(NOUtil.getUserNo());
        user.setMobile(mobile);
        user.setMobileSalt(StrUtil.get32UUID());
        user.setMobilePsw(DigestUtil.sha1Hex(user.getMobileSalt() + password));
        user.setUserSource(clientId);
        userDao.save(user);

        // 用户其他信息
        UserExt userExt = new UserExt();
        userExt.setUserNo(user.getUserNo());
        userExt.setUserType(UserTypeEnum.USER.getCode());
        userExt.setMobile(user.getMobile());
        userExtDao.save(userExt);

        return user;
    }
    public Result<String> sendCode(UserSendCodeBO userSendCodeBO) {
        if (StringUtils.isEmpty(userSendCodeBO.getClientId())) {
            return Result.error("clientId不能为空");
        }
        if (!Pattern.compile(Constants.REGEX_MOBILE).matcher(userSendCodeBO.getMobile()).matches()) {
            return Result.error("手机号码格式不正确");
        }

        Platform platform = platformDao.getByClientId(userSendCodeBO.getClientId());
        if (ObjectUtil.isNull(platform)) {
            return Result.error("该平台不存在");
        }
        if (!StatusIdEnum.YES.getCode().equals(platform.getStatusId())) {
            return Result.error("该平台状态异常，请联系管理员");
        }

        SysVO sys = bossSys.getSys();
        if (ObjectUtil.isNull(sys)) {
            return Result.error("找不到系统配置信息");
        }
        // 创建日志实例
        SendSmsLog sendSmsLog = new SendSmsLog();
        sendSmsLog.setMobile(userSendCodeBO.getMobile());
        sendSmsLog.setTemplate(sys.getSmsCode());
        // 随机生成验证码
        sendSmsLog.setSmsCode(RandomUtil.randomNumbers(6));
        try {
            // 发送验证码
            boolean result = AliyunUtil.sendMsg(userSendCodeBO.getMobile(), sendSmsLog.getSmsCode(), BeanUtil.copyProperties(sys, Aliyun.class));
            // 发送成功，验证码存入缓存：5分钟有效
            if (result) {
                redisTemplate.opsForValue().set(userSendCodeBO.getClientId() + userSendCodeBO.getMobile(), sendSmsLog.getSmsCode(), 5, TimeUnit.MINUTES);
                sendSmsLog.setIsSuccess(IsSuccessEnum.SUCCESS.getCode());
                sendSmsLogDao.save(sendSmsLog);
                return Result.success("发送成功");
            }
            // 发送失败
            sendSmsLog.setIsSuccess(IsSuccessEnum.FAIL.getCode());
            sendSmsLogDao.save(sendSmsLog);
            throw new BaseException("发送失败");
        } catch (ClientException e) {
            sendSmsLog.setIsSuccess(IsSuccessEnum.FAIL.getCode());
            sendSmsLogDao.save(sendSmsLog);
            logger.error("发送失败，原因={}", e.getErrMsg());
            return Result.error("发送失败");
        }
    }

}
