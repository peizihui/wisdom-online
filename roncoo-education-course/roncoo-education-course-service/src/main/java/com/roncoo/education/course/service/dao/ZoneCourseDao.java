package com.roncoo.education.course.service.dao;

import com.roncoo.education.course.service.dao.impl.mapper.entity.ZoneCourse;
import com.roncoo.education.course.service.dao.impl.mapper.entity.ZoneCourseExample;
import com.roncoo.education.util.base.Page;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-19-23:38
 * @email:wk20041208@126.com
 */
public interface ZoneCourseDao {
    int save(ZoneCourse record);

    int deleteById(Long id);

    int updateById(ZoneCourse record);

    ZoneCourse getById(Long id);

    Page<ZoneCourse> listForPage(int pageCurrent, int pageSize, ZoneCourseExample example);

    /**
     * 根据专区编号获取可用的专区课程信息集合
     *
     * @param zoneId
     * @param statusId
     * @return
     * @author wuyun
     */
    List<ZoneCourse> listByZoneIdAndStatusId(Long zoneId, Integer statusId);

    /**
     * 根据专区编号,获取可以专区课程信息
     *
     * @param zoneId
     * @return
     */
    List<ZoneCourse> listByZoneId(Long zoneId);

    ZoneCourse getZoneIdAndCourseId(Long courseId, Long zoneId);

}
