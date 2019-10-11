package com.roncoo.education.course.service.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-20-2:03
 * @email:wk20041208@126.com
 */
@Data
@Accessors(chain = true)
public class AdvListDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "广告信息集合")
    private List<AdvDTO> advList = new ArrayList<>();

}
