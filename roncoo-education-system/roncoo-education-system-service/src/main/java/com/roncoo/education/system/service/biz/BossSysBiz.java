package com.roncoo.education.system.service.biz;

/**
 * @autohor:wangkun
 * @date 2019-05-18-17:15
 * @email:wk20041208@126.com
 */

import com.roncoo.education.system.common.bean.vo.SysVO;
import com.roncoo.education.system.service.dao.SysDao;
import com.roncoo.education.util.tools.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 系统配置表
 */
@Component
public class BossSysBiz {
    @Autowired
    private SysDao dao;



    public SysVO getSys() {
        return BeanUtil.copyProperties(dao.getSys(), SysVO.class);
    }
}
