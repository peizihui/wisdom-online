package com.roncoo.education.system.service.dao;

import com.roncoo.education.system.service.dao.impl.mapper.entity.Website;
import com.roncoo.education.system.service.dao.impl.mapper.entity.WebsiteExample;
import com.roncoo.education.util.base.Page;

/**
 * @autohor:wangkun
 * @date 2019-05-20-16:47
 * @email:wk20041208@126.com
 */
public interface WebsiteDao {
    int save(Website record);

    int deleteById(Long id);

    int updateById(Website record);

    Website getById(Long id);

    Page<Website> listForPage(int pageCurrent, int pageSize, WebsiteExample example);

    /**
     * 获取站点信息
     *
     * @author wuyun
     */
    Website getWebsite();

    /**
     * 根据状态信息查找站点信息
     *
     * @param statusId
     * @return
     */
    Website getByStatusId(Integer statusId);
}
