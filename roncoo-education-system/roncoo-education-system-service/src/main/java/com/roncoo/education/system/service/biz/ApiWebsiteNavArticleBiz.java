package com.roncoo.education.system.service.biz;

import com.roncoo.education.system.service.common.bo.WebsiteNavArticleBO;
import com.roncoo.education.system.service.common.dto.WebsiteNavArticleDTO;
import com.roncoo.education.system.service.dao.WebsiteNavArticleDao;
import com.roncoo.education.system.service.dao.impl.mapper.entity.WebsiteNavArticle;
import com.roncoo.education.util.base.Result;
import com.roncoo.education.util.enums.StatusIdEnum;
import com.roncoo.education.util.tools.BeanUtil;
import com.xiaoleilu.hutool.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @autohor:wangkun
 * @date 2019-05-20-16:20
 * @email:wk20041208@126.com
 */
@Component
public class ApiWebsiteNavArticleBiz {
    @Autowired
    private WebsiteNavArticleDao websiteNavArticleDao;
    public Result<WebsiteNavArticleDTO> get(WebsiteNavArticleBO websiteNavArticleBO) {
        if (StringUtils.isEmpty(websiteNavArticleBO.getNavId())) {
            return Result.error("navId不能为空");
        }
        WebsiteNavArticle websiteNavArticle = websiteNavArticleDao.getByNavIdAndStatusId(websiteNavArticleBO.getNavId(), StatusIdEnum.YES.getCode());
        if (ObjectUtil.isNull(websiteNavArticle)) {
            return Result.error("没有找到站点导航文章信息");
        }
        return Result.success(BeanUtil.copyProperties(websiteNavArticle, WebsiteNavArticleDTO.class));
    }
}
