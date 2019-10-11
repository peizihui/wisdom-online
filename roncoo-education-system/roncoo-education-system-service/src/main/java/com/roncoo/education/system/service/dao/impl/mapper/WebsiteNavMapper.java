package com.roncoo.education.system.service.dao.impl.mapper;

import com.roncoo.education.system.service.dao.impl.mapper.entity.WebsiteNav;
import com.roncoo.education.system.service.dao.impl.mapper.entity.WebsiteNavExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-08-16:47
 * @email:wk20041208@126.com
 */
@Mapper
public interface WebsiteNavMapper {
    List<WebsiteNav> selectByExample(WebsiteNavExample example);
}
