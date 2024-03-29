package com.roncoo.education.system.service.api;

import com.roncoo.education.system.service.biz.ApiWebsiteLinkBiz;
import com.roncoo.education.system.service.common.dto.WebsiteLinkListDTO;
import com.roncoo.education.util.base.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autohor:wangkun
 * @date 2019-05-17-15:36
 * @email:wk20041208@126.com
 */
@RestController
public class ApiWebsiteLinkController {
    @Autowired
    private ApiWebsiteLinkBiz biz;
    /**
     * 获取站点友情链接接口
     *
     * @return 站点友情链接
     * @author wuyun
     */
    @ApiOperation(value = "获取站点友情链接接口", notes = "获取站点友情链接")
    @RequestMapping(value = {"/system/api/website/link"},method = RequestMethod.POST)
    public Result<WebsiteLinkListDTO>  list(){
        return biz.list();
    }
}
