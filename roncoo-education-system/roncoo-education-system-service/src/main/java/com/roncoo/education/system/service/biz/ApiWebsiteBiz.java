package com.roncoo.education.system.service.biz;

import com.roncoo.education.system.service.common.dto.WebsiteDTO;
import com.roncoo.education.system.service.dao.WebsiteDao;
import com.roncoo.education.system.service.dao.impl.mapper.entity.Website;
import com.roncoo.education.util.base.Result;
import com.roncoo.education.util.enums.StatusIdEnum;
import com.roncoo.education.util.tools.BeanUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @autohor:wangkun
 * @date 2019-05-20-16:45
 * @email:wk20041208@126.com
 */
@Component
public class ApiWebsiteBiz {
    @Autowired
    private WebsiteDao websiteDao;

    public Result<WebsiteDTO> get(){
        Website website = websiteDao.getByStatusId(StatusIdEnum.YES.getCode());
        WebsiteDTO dto = BeanUtil.copyProperties(website, WebsiteDTO.class);
        if (StringUtils.hasText(dto.getPrn())) {
            // 公安网备案号处理
            String regEx = "[^0-9]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(dto.getPrn());
            dto.setPrnNo(m.replaceAll("").trim());
        }
        return Result.success(dto);
    }
}
