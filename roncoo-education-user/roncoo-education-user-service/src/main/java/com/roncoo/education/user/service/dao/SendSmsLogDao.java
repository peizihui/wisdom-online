package com.roncoo.education.user.service.dao;

import com.roncoo.education.user.service.dao.impl.mapper.entity.SendSmsLog;
import com.roncoo.education.user.service.dao.impl.mapper.entity.SendSmsLogExample;
import com.roncoo.education.util.base.Page;

/**
 * @autohor:wangkun
 * @date 2019-05-18-2:23
 * @email:wk20041208@126.com
 */
public interface SendSmsLogDao {
    int save(SendSmsLog record);

    int deleteById(Long id);

    int updateById(SendSmsLog record);

    SendSmsLog getById(Long id);

    Page<SendSmsLog> listForPage(int pageCurrent, int pageSize, SendSmsLogExample example);
}
