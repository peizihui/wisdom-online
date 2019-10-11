package com.roncoo.education.course.service.dao.impl;

import com.roncoo.education.course.service.dao.AdvDao;
import com.roncoo.education.course.service.dao.impl.mapper.AdvMapper;
import com.roncoo.education.course.service.dao.impl.mapper.entity.Adv;
import com.roncoo.education.course.service.dao.impl.mapper.entity.AdvExample;
import com.roncoo.education.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-20-2:11
 * @email:wk20041208@126.com
 */
@Repository
public class AdvDaoImpl implements AdvDao {
    @Autowired
    private AdvMapper advMapper;
    @Override
    public int save(Adv record) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(Adv record) {
        return 0;
    }

    @Override
    public Adv getById(Long id) {
        return null;
    }

    @Override
    public Page<Adv> listForPage(int pageCurrent, int pageSize, AdvExample example) {
        return null;
    }

    @Override
    public List<Adv> listByPlatShowAndStatusId(Integer platShow, Integer statusId) {
        AdvExample example = new AdvExample();
        AdvExample.Criteria criteria = example.createCriteria();
        criteria.andPlatShowEqualTo(platShow);
        criteria.andStatusIdEqualTo(statusId);
        criteria.andBeginTimeLessThan(new Date());
        criteria.andEndTimeGreaterThan(new Date());
        return this.advMapper.selectByExample(example);
    }
}
