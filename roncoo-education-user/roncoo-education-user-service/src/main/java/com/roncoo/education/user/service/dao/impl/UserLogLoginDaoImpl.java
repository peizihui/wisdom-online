package com.roncoo.education.user.service.dao.impl;

import com.roncoo.education.user.service.dao.UserLogLoginDao;
import com.roncoo.education.user.service.dao.impl.mapper.UserLogLoginMapper;
import com.roncoo.education.user.service.dao.impl.mapper.entity.UserLogLogin;
import com.roncoo.education.user.service.dao.impl.mapper.entity.UserLogLoginExample;
import com.roncoo.education.util.base.Page;
import com.roncoo.education.util.tools.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @autohor:wangkun
 * @date 2019-05-18-1:02
 * @email:wk20041208@126.com
 */

@Repository
public class UserLogLoginDaoImpl implements UserLogLoginDao {

    @Autowired
    private UserLogLoginMapper userLogLoginMapper;

    @Override
    public int save(UserLogLogin record) {
        record.setId(IdWorker.getId());
        return this.userLogLoginMapper.insertSelective(record);
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(UserLogLogin record) {
        return 0;
    }

    @Override
    public UserLogLogin getById(Long id) {
        return null;
    }

    @Override
    public Page<UserLogLogin> listForPage(int pageCurrent, int pageSize, UserLogLoginExample example) {
        return null;
    }
}
