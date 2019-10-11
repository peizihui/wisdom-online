package com.roncoo.education.system.service.api;

import com.roncoo.education.system.service.biz.ApiWebsiteBiz;
import com.roncoo.education.system.service.common.dto.WebsiteDTO;
import com.roncoo.education.util.base.BaseController;
import com.roncoo.education.util.base.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autohor:wangkun
 * @date 2019-05-20-16:44
 * @email:wk20041208@126.com
 */
/**
 * 站点信息
 */
@RestController
public class ApiWebsiteController extends BaseController {
    @Autowired
    private ApiWebsiteBiz apiWebsiteBiz;

    /**
     * 获取站点信息接口
     *
     * @return 站点信息
     */
    @ApiOperation(value = "获取站点信息接口", notes = "获取站点信息")
    @RequestMapping(value = "/system/api/website/get", method = RequestMethod.POST)
    public Result<WebsiteDTO> get() {
        return apiWebsiteBiz.get();
    }
}
