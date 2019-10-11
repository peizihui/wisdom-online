package com.roncoo.education.user.service.controller.biz;

import com.roncoo.education.user.common.bean.vo.UserVO;
import com.roncoo.education.user.service.dao.UserDao;
import com.roncoo.education.user.service.dao.impl.mapper.entity.User;
import com.roncoo.education.util.tools.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @autohor:wangkun
 * @date 2019-05-04-17:24
 * @email:wk20041208@126.com
 */
@Component
public class BossUserBiz {
    @Autowired
    private UserDao userDao;

    public UserVO getByMobile(String mobile){
        User record = userDao.getByMobile(mobile);
        return BeanUtil.copyProperties(record, UserVO.class);

    }


}
