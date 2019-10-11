package com.roncoo.education.system.service.dao;

import com.roncoo.education.system.service.dao.impl.mapper.entity.NavBar;
import com.roncoo.education.system.service.dao.impl.mapper.entity.NavBarExample;
import com.roncoo.education.util.base.Page;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-20-17:03
 * @email:wk20041208@126.com
 */
public interface NavBarDao {
    int save(NavBar record);

    int deleteById(Long id);

    int updateById(NavBar record);

    NavBar getById(Long id);

    Page<NavBar> listForPage(int pageCurrent, int pageSize, NavBarExample example);

    /**
     * 根据导航链接查找信息
     *
     * @param navUrl
     * @return
     * @author wuyun
     */
    NavBar getByNavUrl(String navUrl);

    /**
     * 查找可用的头部导航
     *
     * @param statusId
     * @return
     */
    List<NavBar> getByStatusId(Integer statusId);
}
