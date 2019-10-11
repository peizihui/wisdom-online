package com.roncoo.education.user.service.dao.impl;

import com.roncoo.education.user.common.bean.vo.UserExtMsgVO;
import com.roncoo.education.user.service.common.AbstractBaseJdbc;
import com.roncoo.education.user.service.dao.UserDao;
import com.roncoo.education.user.service.dao.impl.mapper.UserMapper;
import com.roncoo.education.user.service.dao.impl.mapper.entity.User;
import com.roncoo.education.user.service.dao.impl.mapper.entity.UserExample;
import com.roncoo.education.util.base.Page;
import com.roncoo.education.util.tools.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-04-17:27
 * @email:wk20041208@126.com
 */
@Repository
public class UserDaoImpl extends AbstractBaseJdbc implements UserDao {
    @Autowired
    private UserMapper userMapper;


    @Override
    public int save(User record) {
        record.setId(IdWorker.getId());
        return this.userMapper.insertSelective(record);
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(User record) {
        return 0;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public Page<User> listForPage(int pageCurrent, int pageSize, UserExample example) {
        return null;
    }

    @Override
    public User getByUserNo(Long userNo) {
        return null;
    }

    @Override
    public Page<UserExtMsgVO> pageByStatusIdForMsg(Integer statusId, int pageCurrent, int pageSize) {
        return null;
    }

    @Override
    public User getByMobile(String mobile) {
        UserExample example = new UserExample();
        example.createCriteria().andMobileEqualTo(mobile);
        List<User> list = userMapper.selectByExample(example);
        System.out.println("user service ------------->" + list.get(0));
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }
}
