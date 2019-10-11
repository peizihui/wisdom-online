package com.roncoo.education.course.service.dao;

import com.roncoo.education.course.service.dao.impl.mapper.entity.Zone;
import com.roncoo.education.course.service.dao.impl.mapper.entity.ZoneExample;
import com.roncoo.education.util.base.Page;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-19-23:35
 * @email:wk20041208@126.com
 */
public interface ZoneDao {
    int save(Zone record);

    int deleteById(Long id);

    int updateById(Zone record);

    Zone getById(Long id);

    Page<Zone> listForPage(int pageCurrent, int pageSize, ZoneExample example);

    List<Zone> listAllZone();
}
