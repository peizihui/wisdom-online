package com.roncoo.education.course.service.common.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-20-17:29
 * @email:wk20041208@126.com
 */
@Data
@Accessors(chain = true)
public class CourseCategoryTwoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 分类编号
     */
    @ApiModelProperty(value = "分类编号")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    private String categoryName;
    /**
     * 层级
     */
    @ApiModelProperty(value = "分类层级")
    private Integer floor;

    /**
     * 分类备注信息
     */
    @ApiModelProperty(value = "分类备注")
    private String remark;

    /**
     * 三级分类列表
     */
    @ApiModelProperty(value = "三级分类列表")
    private List<CourseCategoryThreeDTO> threeList = new ArrayList<>();

}
