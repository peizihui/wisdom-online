package com.roncoo.education.system.service.biz;

import com.roncoo.education.system.service.common.dto.NavBarDTO;
import com.roncoo.education.system.service.common.dto.NavBarListDTO;
import com.roncoo.education.system.service.dao.NavBarDao;
import com.roncoo.education.system.service.dao.impl.mapper.entity.NavBar;
import com.roncoo.education.util.base.Result;
import com.roncoo.education.util.enums.StatusIdEnum;
import com.roncoo.education.util.tools.ArrayListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-20-17:02
 * @email:wk20041208@126.com
 */
@Component
public class ApiNavBarBiz {
    @Autowired
    private NavBarDao navBarDao;

    public Result<NavBarListDTO> list() {
        List<NavBar> list = navBarDao.getByStatusId(StatusIdEnum.YES.getCode());
        NavBarListDTO dto = new NavBarListDTO();
        dto.setList(ArrayListUtil.copy(list, NavBarDTO.class));
        return Result.success(dto);
    }

}
