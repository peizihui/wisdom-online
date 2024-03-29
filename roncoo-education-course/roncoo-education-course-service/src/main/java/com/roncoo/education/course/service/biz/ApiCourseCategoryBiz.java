package com.roncoo.education.course.service.biz;

import com.roncoo.education.course.service.common.dto.CourseCategoryDTO;
import com.roncoo.education.course.service.common.dto.CourseCategoryListDTO;
import com.roncoo.education.course.service.common.dto.CourseCategoryThreeDTO;
import com.roncoo.education.course.service.common.dto.CourseCategoryTwoDTO;
import com.roncoo.education.course.service.dao.CourseCategoryDao;
import com.roncoo.education.course.service.dao.impl.mapper.entity.CourseCategory;
import com.roncoo.education.util.base.Result;
import com.roncoo.education.util.enums.CategoryTypeEnum;
import com.roncoo.education.util.enums.StatusIdEnum;
import com.roncoo.education.util.tools.ArrayListUtil;
import com.roncoo.education.util.tools.BeanUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-20-17:23
 * @email:wk20041208@126.com
 */
@Component
public class ApiCourseCategoryBiz {
    @Autowired
    private CourseCategoryDao courseCategoryDao;


    /**
     * 获取课程分类列表
     *
     * @return
     */
    public Result<CourseCategoryListDTO> list() {
        CourseCategoryListDTO dto = new CourseCategoryListDTO();
        // 根据分类类型、层级查询可用状态的课程分类集合
        List<CourseCategory> oneCategoryList = courseCategoryDao.listByCategoryTypeAndFloorAndStatusId(CategoryTypeEnum.COURSE.getCode(), 1, StatusIdEnum.YES.getCode());
        if (StringUtils.isEmpty(oneCategoryList)) {
            return Result.success(dto);
        }
        List<CourseCategoryDTO> oneList = new ArrayList<>();
        // 查找一级分类下的二级分类
        for (CourseCategory courseCategory : oneCategoryList) {
            // 设置一级分类
            CourseCategoryDTO oneCategory = BeanUtil.copyProperties(courseCategory, CourseCategoryDTO.class);

            // 查找一级分类下的二级分类
            List<CourseCategory> twoCategoryList = courseCategoryDao.listByParentId(courseCategory.getId());
            if (StringUtils.isEmpty(twoCategoryList)) {
                oneList.add(oneCategory);
                dto.setCourseCategoryList(oneList);
                continue;
            }
            List<CourseCategoryTwoDTO> twoList = new ArrayList<>();
            List<CourseCategoryThreeDTO> threeList = new ArrayList<>();
            for (CourseCategory twoCategory : twoCategoryList) {
                CourseCategoryTwoDTO twoDto = new CourseCategoryTwoDTO();
                twoDto = BeanUtil.copyProperties(twoCategory, CourseCategoryTwoDTO.class);
                List<CourseCategory> threeCategoryList = courseCategoryDao.listByParentId(twoCategory.getId());
                if (CollectionUtils.isNotEmpty(threeCategoryList)) {
                    // 复制三级分类信息返回
                    threeList = ArrayListUtil.copy(threeCategoryList, CourseCategoryThreeDTO.class);
                    twoDto.setThreeList(threeList);
                }
                twoList.add(twoDto);
            }
            oneCategory.setTwoList(twoList);
            // 复制二级分类信息返回
            oneList.add(oneCategory);
            dto.setCourseCategoryList(oneList);
        }
        return Result.success(dto);
    }
}
