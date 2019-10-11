package com.roncoo.education.user.service.dao.impl;

import com.roncoo.education.user.service.dao.UserExtDao;
import com.roncoo.education.user.service.dao.impl.mapper.UserExtMapper;
import com.roncoo.education.user.service.dao.impl.mapper.entity.UserExt;
import com.roncoo.education.user.service.dao.impl.mapper.entity.UserExtExample;
import com.roncoo.education.util.base.Page;
import com.roncoo.education.util.tools.IdWorker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-18-1:45
 * @email:wk20041208@126.com
 */
@Repository
public class UserExtDaoImpl implements UserExtDao {

    @Autowired
    private UserExtMapper userExtMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int save(UserExt record) {
        record.setId(IdWorker.getId());
        return this.userExtMapper.insertSelective(record);
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(UserExt record) {
        return 0;
    }

    @Override
    public UserExt getById(Long id) {
        return null;
    }

    @Override
    public Page<UserExt> listForPage(int pageCurrent, int pageSize, UserExtExample example) {
        return null;
    }

    @Override
    public UserExt getByUserNo(Long userNo) {
        UserExtExample example = new UserExtExample();
        UserExtExample.Criteria criteria = example.createCriteria();
        criteria.andUserNoEqualTo(userNo);
        List<UserExt> list = this.userExtMapper.selectByExample(example);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public int updateByUserNo(UserExt record) {
        return 0;
    }

    @Override
    public UserExt getByMobile(String mobile) {
        return null;
    }

    @Override
    public Integer sumByCountOrders(String date) {
        return null;
    }
}
