package com.roncoo.education.user.service.dao;

import com.roncoo.education.user.common.bean.vo.UserExtMsgVO;
import com.roncoo.education.user.service.dao.impl.mapper.entity.User;
import com.roncoo.education.user.service.dao.impl.mapper.entity.UserExample;
import com.roncoo.education.util.base.Page;

/**
 * @autohor:wangkun
 * @date 2019-05-04-17:25
 * @email:wk20041208@126.com
 */
public interface UserDao {
    User getByMobile(String mobile);
    int save(User record);

    int deleteById(Long id);

    int updateById(User record);

    User getById(Long id);

    Page<User> listForPage(int pageCurrent, int pageSize, UserExample example);

    User getByUserNo(Long userNo);

    /**
     * 分页缓存用户信息，站内信发送用
     *
     * @param statusId
     * @param pageCurrent
     * @param pageSize
     * @return
     * @author wuyun
     */
    Page<UserExtMsgVO> pageByStatusIdForMsg(Integer statusId, int pageCurrent, int pageSize);
}
