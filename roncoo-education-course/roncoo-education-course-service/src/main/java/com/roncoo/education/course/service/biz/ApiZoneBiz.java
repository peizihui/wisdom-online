package com.roncoo.education.course.service.biz;

import com.roncoo.education.course.service.common.bo.ZoneBO;
import com.roncoo.education.course.service.common.dto.ZoneCourseDTO;
import com.roncoo.education.course.service.common.dto.ZoneDTO;
import com.roncoo.education.course.service.dao.CourseDao;
import com.roncoo.education.course.service.dao.ZoneCourseDao;
import com.roncoo.education.course.service.dao.ZoneDao;
import com.roncoo.education.course.service.dao.impl.mapper.entity.Course;
import com.roncoo.education.course.service.dao.impl.mapper.entity.Zone;
import com.roncoo.education.course.service.dao.impl.mapper.entity.ZoneCourse;
import com.roncoo.education.course.service.dao.impl.mapper.entity.ZoneExample;
import com.roncoo.education.util.base.Page;
import com.roncoo.education.util.base.PageUtil;
import com.roncoo.education.util.base.Result;
import com.roncoo.education.util.enums.StatusIdEnum;
import com.roncoo.education.util.tools.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 专区课程分页列表接口
 * @autohor:wangkun
 * @date 2019-05-19-23:16
 * @email:wk20041208@126.com
 */
@Component
public class ApiZoneBiz {

    @Autowired
    private ZoneDao zoneDao;
    @Autowired
    private ZoneCourseDao zoneCourseDao;
    @Autowired
    private CourseDao courseDao;
    public Result<Page<ZoneDTO>> listForPage(ZoneBO zoneBO) {
        if (StringUtils.isEmpty(zoneBO.getZoneLocation())) {
            return Result.error("zoneLocation不能为空");
        }
        ZoneExample example = new ZoneExample();
        ZoneExample.Criteria c = example.createCriteria();
        c.andStatusIdEqualTo(StatusIdEnum.YES.getCode());
        if (!StringUtils.isEmpty(zoneBO.getId())) {
            c.andIdEqualTo(zoneBO.getId());
        }
        if (!StringUtils.isEmpty(zoneBO.getZoneLocation())) {
            c.andZoneLocationEqualTo(zoneBO.getZoneLocation());
        }
        example.setOrderByClause("sort desc, id desc");
        Page<Zone> zonePage = zoneDao.listForPage(zoneBO.getPageCurrent(), zoneBO.getPageSize(), example);
        if (StringUtils.isEmpty(zonePage)) {
            return Result.error("找不到信息");
        }
        Page<ZoneDTO> page = PageUtil.transform(zonePage, ZoneDTO.class);
        for (ZoneDTO zone : page.getList()) {
            List<ZoneCourse> zoneCourseList = zoneCourseDao.listByZoneIdAndStatusId(zone.getId(), StatusIdEnum.YES.getCode());
            List<ZoneCourseDTO> zoneCourseListDTO = new ArrayList<>();
            for (ZoneCourse zoneCourse : zoneCourseList) {
                Course course = courseDao.getById(zoneCourse.getCourseId());
                zoneCourseListDTO.add(BeanUtil.copyProperties(course, ZoneCourseDTO.class));
            }
            zone.setZoneCourseList(zoneCourseListDTO);
        }
        return Result.success(page);
    }

}
