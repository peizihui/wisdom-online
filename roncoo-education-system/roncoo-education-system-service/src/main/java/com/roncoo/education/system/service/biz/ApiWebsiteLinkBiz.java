package com.roncoo.education.system.service.biz;

import com.roncoo.education.system.service.common.dto.WebsiteLinkDTO;
import com.roncoo.education.system.service.common.dto.WebsiteLinkListDTO;
import com.roncoo.education.system.service.dao.WebsiteLinkDao;
import com.roncoo.education.system.service.dao.impl.mapper.entity.WebsiteLink;
import com.roncoo.education.util.base.PageUtil;
import com.roncoo.education.util.base.Result;
import com.roncoo.education.util.enums.StatusIdEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-17-15:36
 * @email:wk20041208@126.com
 */
@Component
public class ApiWebsiteLinkBiz {
    @Autowired
    private WebsiteLinkDao websiteLinkDao;

    public Result<WebsiteLinkListDTO> list(){
        List<WebsiteLink> websiteLinkList = websiteLinkDao.listByStatusId(StatusIdEnum.YES.getCode());
        WebsiteLinkListDTO dto = new WebsiteLinkListDTO();
        dto.setWebsiteLinkList(PageUtil.copyList(websiteLinkList, WebsiteLinkDTO.class));
        return Result.success(dto);
    }
}
