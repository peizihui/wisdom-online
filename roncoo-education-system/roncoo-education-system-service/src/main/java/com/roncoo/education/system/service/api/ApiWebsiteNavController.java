package com.roncoo.education.system.service.api;

import com.roncoo.education.system.service.biz.ApiWebsiteNavBiz;
import com.roncoo.education.system.service.common.dto.WebsiteNavListDTO;
import com.roncoo.education.util.base.BaseController;
import com.roncoo.education.util.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autohor:wangkun
 * @date 2019-05-08-16:28
 * @email:wk20041208@126.com
 */
@RestController
public class ApiWebsiteNavController  extends BaseController {
    @Autowired
    private ApiWebsiteNavBiz apiWebsiteNavBiz;

    /**
     * 获取站点导航信息接口
     *
     * @return
     * @author wuyun
     */
    @RequestMapping(value = {"/system/api/website/nav/list"},method = RequestMethod.POST)
    public Result<WebsiteNavListDTO> list(){

        return apiWebsiteNavBiz.list();
    }

}
