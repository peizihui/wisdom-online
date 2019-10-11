package com.roncoo.education.system.service.dao.impl;

import com.roncoo.education.system.service.dao.NavBarDao;
import com.roncoo.education.system.service.dao.impl.mapper.NavBarMapper;
import com.roncoo.education.system.service.dao.impl.mapper.entity.NavBar;
import com.roncoo.education.system.service.dao.impl.mapper.entity.NavBarExample;
import com.roncoo.education.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-20-17:04
 * @email:wk20041208@126.com
 */
@Repository
public class NavBarDaoImpl implements NavBarDao {
    @Autowired
    private NavBarMapper navBarMapper;

    @Override
    public int save(NavBar record) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(NavBar record) {
        return 0;
    }

    @Override
    public NavBar getById(Long id) {
        return null;
    }

    @Override
    public Page<NavBar> listForPage(int pageCurrent, int pageSize, NavBarExample example) {
        return null;
    }

    @Override
    public NavBar getByNavUrl(String navUrl) {
        return null;
    }

    @Override
    public List<NavBar> getByStatusId(Integer statusId) {
        NavBarExample example = new NavBarExample();
        NavBarExample.Criteria criteria = example.createCriteria();
        criteria.andStatusIdEqualTo(statusId);
        example.setOrderByClause("sort desc, id desc ");
        return this.navBarMapper.selectByExample(example);
    }
}
