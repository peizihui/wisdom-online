package com.roncoo.education.user.service.controller;

import com.roncoo.education.user.common.bean.qo.UserQO;
import com.roncoo.education.user.common.bean.vo.UserVO;
import com.roncoo.education.user.common.interfaces.BossUser;
import com.roncoo.education.user.service.controller.biz.BossUserBiz;
import com.roncoo.education.util.base.BaseController;
import com.roncoo.education.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autohor:wangkun
 * @date 2019-05-04-17:23
 * @email:wk20041208@126.com
 */
@RestController
public class BossUserController extends BaseController implements BossUser {
    @Autowired
    private BossUserBiz biz;
    @Override
    public Page<UserVO> listForPage(UserQO qo) {
        return null;
    }

    @Override
    public int save(UserQO qo) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(UserQO qo) {
        return 0;
    }

    @Override
    public UserVO getById(Long id) {
        return null;
    }

    @Override
    public UserVO getByUserNo(Long userNo) {
        return null;
    }

    @Override
    public UserVO getByMobile(String mobile) {
        System.out.println("BossUserController-------------->" + mobile);
//        return biz.getByMobile(mobile);
        return biz.getByMobile("13800000000");
    }
}
