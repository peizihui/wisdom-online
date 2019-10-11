package com.roncoo.education.system.service.api;

import com.roncoo.education.system.service.biz.ApiNavBarBiz;
import com.roncoo.education.system.service.common.dto.NavBarListDTO;
import com.roncoo.education.util.base.BaseController;
import com.roncoo.education.util.base.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autohor:wangkun
 * @date 2019-05-20-17:01
 * @email:wk20041208@126.com
 */
@RestController
public class ApiNavBarController extends BaseController {
    @Autowired
    private ApiNavBarBiz apiNavBarBiz;

    /**
     * 获取头部导航信息接口
     *
     * @return 站点信息
     * @author wuyun
     */
    @ApiOperation(value = "获取头部导航信息接口", notes = "获取头部导航信息")
    @RequestMapping(value = "/system/api/nav/bar/list", method = RequestMethod.POST)
    public Result<NavBarListDTO> list() {
        return apiNavBarBiz.list();
    }
}
