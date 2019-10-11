package com.roncoo.education.system.service.dao.impl;

import com.roncoo.education.system.service.dao.WebsiteDao;
import com.roncoo.education.system.service.dao.impl.mapper.WebsiteMapper;
import com.roncoo.education.system.service.dao.impl.mapper.entity.Website;
import com.roncoo.education.system.service.dao.impl.mapper.entity.WebsiteExample;
import com.roncoo.education.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-20-16:49
 * @email:wk20041208@126.com
 */
@Repository
public class WebsiteDaoImpl implements WebsiteDao {
    @Autowired
    private WebsiteMapper websiteMapper;
    @Override
    public int save(Website record) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(Website record) {
        return 0;
    }

    @Override
    public Website getById(Long id) {
        return null;
    }

    @Override
    public Page<Website> listForPage(int pageCurrent, int pageSize, WebsiteExample example) {
        return null;
    }

    @Override
    public Website getWebsite() {
        return null;
    }

    @Override
    public Website getByStatusId(Integer statusId) {
        WebsiteExample example = new WebsiteExample();
        WebsiteExample.Criteria C = example.createCriteria();
        C.andStatusIdEqualTo(statusId);
        List<Website> list = this.websiteMapper.selectByExample(example);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
