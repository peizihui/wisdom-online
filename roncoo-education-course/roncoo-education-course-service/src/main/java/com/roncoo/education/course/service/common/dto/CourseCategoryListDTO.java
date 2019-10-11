package com.roncoo.education.course.service.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-20-17:32
 * @email:wk20041208@126.com
 */
/**
 * 课程分类
 *
 * @author wujing
 */
@Data
@Accessors(chain = true)
public class CourseCategoryListDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类列表", required = true)
    private List<CourseCategoryDTO> courseCategoryList = new ArrayList<>();
}
