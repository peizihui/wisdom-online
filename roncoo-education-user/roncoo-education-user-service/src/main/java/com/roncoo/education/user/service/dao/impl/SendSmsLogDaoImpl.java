package com.roncoo.education.user.service.dao.impl;

import com.roncoo.education.user.service.dao.SendSmsLogDao;
import com.roncoo.education.user.service.dao.impl.mapper.SendSmsLogMapper;
import com.roncoo.education.user.service.dao.impl.mapper.entity.SendSmsLog;
import com.roncoo.education.user.service.dao.impl.mapper.entity.SendSmsLogExample;
import com.roncoo.education.util.base.Page;
import com.roncoo.education.util.tools.IdWorker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @autohor:wangkun
 * @date 2019-05-18-2:24
 * @email:wk20041208@126.com
 */
@Repository
public class SendSmsLogDaoImpl implements SendSmsLogDao {
    @Autowired
    private SendSmsLogMapper sendSmsLogMapper;

    @Override
    public int save(SendSmsLog record) {
        record.setId(IdWorker.getId());
        return this.sendSmsLogMapper.insertSelective(record);
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(SendSmsLog record) {
        return 0;
    }

    @Override
    public SendSmsLog getById(Long id) {
        return null;
    }

    @Override
    public Page<SendSmsLog> listForPage(int pageCurrent, int pageSize, SendSmsLogExample example) {
        return null;
    }
}
