package com.roncoo.education.course.service.biz;

import com.roncoo.education.course.service.common.bo.AdvBO;
import com.roncoo.education.course.service.common.dto.AdvDTO;
import com.roncoo.education.course.service.common.dto.AdvListDTO;
import com.roncoo.education.course.service.dao.AdvDao;
import com.roncoo.education.course.service.dao.impl.mapper.entity.Adv;
import com.roncoo.education.util.base.PageUtil;
import com.roncoo.education.util.base.Result;
import com.roncoo.education.util.enums.StatusIdEnum;
import com.xiaoleilu.hutool.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-20-1:53
 * @email:wk20041208@126.com
 */
@Component
public class ApiAdvBiz {
    @Autowired
    private AdvDao advDao;

    public Result<AdvListDTO> list(AdvBO advBO){
        AdvListDTO advList = new AdvListDTO();
        // 开始时间和结束时间


        List<Adv> list = advDao.listByPlatShowAndStatusId(advBO.getPlatShow(), StatusIdEnum.YES.getCode());
        if(CollectionUtil.isEmpty(list)){
            return Result.error("找不到广告信息");
        }
        advList.setAdvList(PageUtil.copyList(list, AdvDTO.class));
        return Result.success(advList);
    }
}
