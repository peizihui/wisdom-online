package com.roncoo.education.course.service.api;

import com.roncoo.education.course.service.biz.ApiAdvBiz;
import com.roncoo.education.course.service.common.bo.AdvBO;
import com.roncoo.education.course.service.common.dto.AdvListDTO;
import com.roncoo.education.util.base.BaseController;
import com.roncoo.education.util.base.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autohor:wangkun
 * @date 2019-05-20-1:47
 * @email:wk20041208@126.com
 */
@RestController
@RequestMapping(value = {"/course/api/adv"})
public class ApiAdvController extends BaseController {
    @Autowired
    private ApiAdvBiz apiAdvBiz;

    @ApiOperation(value = "广告列表接口", notes = "首页轮播广告列出")
    @RequestMapping(value = {"/list"},method = RequestMethod.POST)
    public Result<AdvListDTO> list(@RequestBody AdvBO advBO){
        return apiAdvBiz.list(advBO);

    }
}
