package com.roncoo.education.system.service.dao.impl;

import com.roncoo.education.system.service.dao.WebsiteLinkDao;
import com.roncoo.education.system.service.dao.impl.mapper.WebsiteLinkMapper;
import com.roncoo.education.system.service.dao.impl.mapper.entity.WebsiteLink;
import com.roncoo.education.system.service.dao.impl.mapper.entity.WebsiteLinkExample;
import com.roncoo.education.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-17-15:42
 * @email:wk20041208@126.com
 */
@Repository
public class WebsiteLinkDaoImpl implements WebsiteLinkDao {
    @Autowired
    private WebsiteLinkMapper websiteLinkMapper;
    @Override
    public int save(WebsiteLink record) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(WebsiteLink record) {
        return 0;
    }

    @Override
    public WebsiteLink getById(Long id) {
        return null;
    }

    @Override
    public Page<WebsiteLink> listForPage(int pageCurrent, int pageSize, WebsiteLinkExample example) {
        return null;
    }

    @Override
    public List<WebsiteLink> listByStatusId(Integer statusId) {
        WebsiteLinkExample example = new WebsiteLinkExample();
        WebsiteLinkExample.Criteria c = example.createCriteria();
        example.setOrderByClause(" sort desc, id desc ");
        c.andStatusIdEqualTo(statusId);
        return this.websiteLinkMapper.selectByExample(example);
    }
}
