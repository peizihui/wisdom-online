package com.roncoo.education.course.service.dao.impl;

import com.roncoo.education.course.service.dao.CourseCategoryDao;
import com.roncoo.education.course.service.dao.impl.mapper.CourseCategoryMapper;
import com.roncoo.education.course.service.dao.impl.mapper.entity.CourseCategory;
import com.roncoo.education.course.service.dao.impl.mapper.entity.CourseCategoryExample;
import com.roncoo.education.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-20-17:25
 * @email:wk20041208@126.com
 */
@Repository
public class CourseCategoryDaoImpl implements CourseCategoryDao {
    @Autowired
    private CourseCategoryMapper courseCategoryMapper;
    @Override
    public int save(CourseCategory record) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(CourseCategory record) {
        return 0;
    }

    @Override
    public CourseCategory getById(Long id) {
        return null;
    }

    @Override
    public Page<CourseCategory> listForPage(int pageCurrent, int pageSize, CourseCategoryExample example) {
        return null;
    }

    @Override
    public List<CourseCategory> listByParentId(Long parentId) {
        CourseCategoryExample example = new CourseCategoryExample();
        CourseCategoryExample.Criteria c = example.createCriteria();
        c.andParentIdEqualTo(parentId);
        example.setOrderByClause("status_id desc, sort desc, id desc");
        return this.courseCategoryMapper.selectByExample(example);
    }

    @Override
    public List<CourseCategory> listByFloor(Integer floor) {
        return null;
    }

    @Override
    public List<CourseCategory> listByFloorAndCategoryId(Integer floor, Long parentId) {
        return null;
    }

    @Override
    public List<CourseCategory> listByCategoryTypeAndFloorAndStatusId(Integer categoryType, Integer floor, Integer statusId) {
        CourseCategoryExample example = new CourseCategoryExample();
        CourseCategoryExample.Criteria c = example.createCriteria();
        c.andCategoryTypeEqualTo(categoryType);
        c.andFloorEqualTo(floor);
        c.andStatusIdEqualTo(statusId);
        example.setOrderByClause(" status_id desc, sort desc, id desc ");
        return this.courseCategoryMapper.selectByExample(example);
    }
}
