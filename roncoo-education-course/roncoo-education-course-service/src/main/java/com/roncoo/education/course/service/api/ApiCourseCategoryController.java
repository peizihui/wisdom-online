package com.roncoo.education.course.service.api;

import com.roncoo.education.course.service.biz.ApiCourseCategoryBiz;
import com.roncoo.education.course.service.common.dto.CourseCategoryListDTO;
import com.roncoo.education.util.base.BaseController;
import com.roncoo.education.util.base.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autohor:wangkun
 * @date 2019-05-20-17:21
 * @email:wk20041208@126.com
 */

/**
 * 课程分类
 */
@RestController
@RequestMapping(value = {"/course/api/course/category"})
public class ApiCourseCategoryController extends BaseController {
    @Autowired
    private ApiCourseCategoryBiz apiCourseCategoryBiz;

    /**
     * 普通课程分类列表接口
     *
     * @author wuyun
     */
    @ApiOperation(value = "课程分类列表接口", notes = "课程分类列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result<CourseCategoryListDTO> list() {
        return apiCourseCategoryBiz.list();
    }
}
