package com.roncoo.education.course.service.dao.impl;

import com.roncoo.education.course.service.dao.ZoneDao;
import com.roncoo.education.course.service.dao.impl.mapper.ZoneMapper;
import com.roncoo.education.course.service.dao.impl.mapper.entity.Zone;
import com.roncoo.education.course.service.dao.impl.mapper.entity.ZoneExample;
import com.roncoo.education.util.base.Page;
import com.roncoo.education.util.base.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-19-23:36
 * @email:wk20041208@126.com
 */
@Repository
public class ZoneDaoImpl implements ZoneDao {
    @Autowired
    private ZoneMapper zoneMapper;
    @Override
    public int save(Zone record) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(Zone record) {
        return 0;
    }

    @Override
    public Zone getById(Long id) {
        return null;
    }

    @Override
    public Page<Zone> listForPage(int pageCurrent, int pageSize, ZoneExample example) {

        int count = this.zoneMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);
        return new Page<Zone>(count, totalPage, pageCurrent, pageSize, this.zoneMapper.selectByExample(example));
    }

    @Override
    public List<Zone> listAllZone() {
        return null;
    }
}
