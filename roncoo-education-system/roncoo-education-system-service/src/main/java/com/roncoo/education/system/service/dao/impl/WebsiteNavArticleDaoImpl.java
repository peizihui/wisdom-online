package com.roncoo.education.system.service.dao.impl;

import com.roncoo.education.system.service.dao.WebsiteNavArticleDao;
import com.roncoo.education.system.service.dao.impl.mapper.WebsiteNavArticleMapper;
import com.roncoo.education.system.service.dao.impl.mapper.entity.WebsiteNavArticle;
import com.roncoo.education.system.service.dao.impl.mapper.entity.WebsiteNavArticleExample;
import com.roncoo.education.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-20-16:24
 * @email:wk20041208@126.com
 */
@Repository
public class WebsiteNavArticleDaoImpl implements WebsiteNavArticleDao {
    @Autowired
    private WebsiteNavArticleMapper websiteNavArticleMapper;

    @Override
    public int save(WebsiteNavArticle record) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(WebsiteNavArticle record) {
        return 0;
    }

    @Override
    public WebsiteNavArticle getById(Long id) {
        return null;
    }

    @Override
    public Page<WebsiteNavArticle> listForPage(int pageCurrent, int pageSize, WebsiteNavArticleExample example) {
        return null;
    }

    @Override
    public WebsiteNavArticle getByNavId(Long id) {
        return null;
    }

    @Override
    public WebsiteNavArticle getByNavIdAndStatusId(Long navId, Integer statusId) {
        WebsiteNavArticleExample example = new WebsiteNavArticleExample();
        WebsiteNavArticleExample.Criteria C = example.createCriteria();
        C.andNavIdEqualTo(navId);
        C.andStatusIdEqualTo(statusId);
        List<WebsiteNavArticle> list = this.websiteNavArticleMapper.selectByExampleWithBLOBs(example);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
