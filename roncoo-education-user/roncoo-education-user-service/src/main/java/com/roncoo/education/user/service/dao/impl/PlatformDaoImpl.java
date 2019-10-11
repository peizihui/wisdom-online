package com.roncoo.education.user.service.dao.impl;

import com.roncoo.education.user.service.dao.PlatformDao;
import com.roncoo.education.user.service.dao.impl.mapper.PlatformMapper;
import com.roncoo.education.user.service.dao.impl.mapper.entity.Platform;
import com.roncoo.education.user.service.dao.impl.mapper.entity.PlatformExample;
import com.roncoo.education.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-18-0:53
 * @email:wk20041208@126.com
 */
@Repository
public class PlatformDaoImpl implements PlatformDao {

    @Autowired
    private PlatformMapper platformMapper;

    @Override
    public int save(Platform record) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(Platform record) {
        return 0;
    }

    @Override
    public Platform getById(Long id) {
        return null;
    }

    @Override
    public Page<Platform> listForPage(int pageCurrent, int pageSize, PlatformExample example) {
        return null;
    }

    @Override
    public Platform getByClientId(String clientId) {
        PlatformExample example = new PlatformExample();
        example.createCriteria().andClientIdEqualTo(clientId);
        List<Platform> list = this.platformMapper.selectByExample(example);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
