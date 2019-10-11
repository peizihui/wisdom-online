package com.roncoo.education.system.service.dao;

import com.roncoo.education.system.service.dao.impl.mapper.entity.WebsiteNav;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-08-16:30
 * @email:wk20041208@126.com
 */
public interface WebsiteNavDao {
    /**
     * 根据状态和父ID信息查找站点导航信息
     *
     * @param statusId
     * @param parentId
     * @author wuyun
     */
    List<WebsiteNav> listByStatusIdAndParentId(Integer statusId, Long parentId);
}
