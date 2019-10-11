package com.roncoo.education.system.service.common.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @autohor:wangkun
 * @date 2019-05-08-16:28
 * @email:wk20041208@126.com
 */
@Data
@Accessors(chain = true)
public class NavBarListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 导航集合
     */
    @ApiModelProperty(value = "导航集合")
    private List<NavBarDTO> list = new ArrayList<>();
}
