package com.roncoo.education.user.service.dao;

import com.roncoo.education.user.service.dao.impl.mapper.entity.Platform;
import com.roncoo.education.user.service.dao.impl.mapper.entity.PlatformExample;
import com.roncoo.education.util.base.Page;

/**
 * @autohor:wangkun
 * @date 2019-05-18-0:51
 * @email:wk20041208@126.com
 */
public interface PlatformDao {
    int save(Platform record);

    int deleteById(Long id);

    int updateById(Platform record);

    Platform getById(Long id);

    Page<Platform> listForPage(int pageCurrent, int pageSize, PlatformExample example);

    Platform getByClientId(String clientId);
}
