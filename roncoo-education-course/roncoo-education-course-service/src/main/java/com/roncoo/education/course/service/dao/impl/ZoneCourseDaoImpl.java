package com.roncoo.education.course.service.dao.impl;

import com.roncoo.education.course.service.dao.ZoneCourseDao;
import com.roncoo.education.course.service.dao.impl.mapper.ZoneCourseMapper;
import com.roncoo.education.course.service.dao.impl.mapper.entity.ZoneCourse;
import com.roncoo.education.course.service.dao.impl.mapper.entity.ZoneCourseExample;
import com.roncoo.education.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-19-23:41
 * @email:wk20041208@126.com
 */
@Repository
public class ZoneCourseDaoImpl implements ZoneCourseDao {

    @Autowired
    private ZoneCourseMapper zoneCourseMapper;
    @Override
    public int save(ZoneCourse record) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(ZoneCourse record) {
        return 0;
    }

    @Override
    public ZoneCourse getById(Long id) {
        return null;
    }

    @Override
    public Page<ZoneCourse> listForPage(int pageCurrent, int pageSize, ZoneCourseExample example) {
        return null;
    }

    @Override
    public List<ZoneCourse> listByZoneIdAndStatusId(Long zoneId, Integer statusId){
        ZoneCourseExample example = new ZoneCourseExample();
        ZoneCourseExample.Criteria c = example.createCriteria();
        c.andZoneIdEqualTo(zoneId);
        c.andStatusIdEqualTo(statusId);
        example.setOrderByClause("sort desc, id desc");
        return this.zoneCourseMapper.selectByExample(example);
    }

    @Override
    public List<ZoneCourse> listByZoneId(Long zoneId) {
        return null;
    }

    @Override
    public ZoneCourse getZoneIdAndCourseId(Long courseId, Long zoneId) {
        return null;
    }
}
