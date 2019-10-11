package com.roncoo.education.system.service.api;

import com.roncoo.education.system.service.biz.ApiWebsiteNavArticleBiz;
import com.roncoo.education.system.service.common.bo.WebsiteNavArticleBO;
import com.roncoo.education.system.service.common.dto.WebsiteNavArticleDTO;
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
 * @date 2019-05-20-16:19
 * @email:wk20041208@126.com
 */
@RestController
public class ApiWebsiteNavArticleController extends BaseController {
    @Autowired
    private ApiWebsiteNavArticleBiz apiWebsiteNavArticleBiz;
    /**
     * 获取站点导航文章接口
     *
     * @return
     */

    @ApiOperation(value = "获取站点导航文章接口", notes = "根据站点导航ID获取站点导航文章信息")
    @RequestMapping(value = "/system/api/website/nav/article/get", method = RequestMethod.POST)
    public Result<WebsiteNavArticleDTO> get(@RequestBody WebsiteNavArticleBO websiteNavArticleBO) {
        return apiWebsiteNavArticleBiz.get(websiteNavArticleBO);
    }
}
