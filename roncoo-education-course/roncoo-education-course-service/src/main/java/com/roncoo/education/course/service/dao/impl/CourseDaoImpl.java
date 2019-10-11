package com.roncoo.education.course.service.dao.impl;

import com.roncoo.education.course.service.dao.CourseDao;
import com.roncoo.education.course.service.dao.impl.mapper.CourseMapper;
import com.roncoo.education.course.service.dao.impl.mapper.ZoneCourseMapper;
import com.roncoo.education.course.service.dao.impl.mapper.ZoneMapper;
import com.roncoo.education.course.service.dao.impl.mapper.entity.Course;
import com.roncoo.education.course.service.dao.impl.mapper.entity.CourseExample;
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
public class CourseDaoImpl implements CourseDao {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public int save(Course record) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(Course record) {
        return 0;
    }

    @Override
    public Course getById(Long id) {

        return this.courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<Course> listForPage(int pageCurrent, int pageSize, CourseExample example) {
        return null;
    }

    @Override
    public List<Course> listByCategoryId(Long courseId) {
        return null;
    }

    @Override
    public Course getByCourseIdAndStatusId(Long courseId, Integer StatusId) {
        return null;
    }

    @Override
    public Course getByCourseName(String courseName) {
        return null;
    }

    @Override
    public List<Course> listBycategoryId2AndStatusId(Long categoryId2, Integer statusId) {
        return null;
    }
}
