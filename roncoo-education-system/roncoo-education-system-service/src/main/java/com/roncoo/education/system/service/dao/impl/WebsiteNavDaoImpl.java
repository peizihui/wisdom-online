package com.roncoo.education.system.service.dao.impl;

import com.roncoo.education.system.service.dao.WebsiteNavDao;
import com.roncoo.education.system.service.dao.impl.mapper.WebsiteNavMapper;
import com.roncoo.education.system.service.dao.impl.mapper.entity.WebsiteNav;
import com.roncoo.education.system.service.dao.impl.mapper.entity.WebsiteNavExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-08-16:45
 * @email:wk20041208@126.com
 */
@Repository
public class WebsiteNavDaoImpl implements WebsiteNavDao {
    @Autowired
    private WebsiteNavMapper websiteNavMapper;
    @Override
    public List<WebsiteNav> listByStatusIdAndParentId(Integer statusId, Long parentId) {
        WebsiteNavExample example = new WebsiteNavExample();
        WebsiteNavExample.Criteria C = example.createCriteria();
        C.andStatusIdEqualTo(statusId);
        C.andParentIdEqualTo(parentId);
        example.setOrderByClause("status_id desc, sort desc, id desc");
        return this.websiteNavMapper.selectByExample(example);
    }
}
