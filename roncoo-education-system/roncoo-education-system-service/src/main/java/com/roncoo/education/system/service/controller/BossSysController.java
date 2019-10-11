package com.roncoo.education.system.service.controller;

import com.roncoo.education.system.common.bean.qo.SysQO;
import com.roncoo.education.system.common.bean.vo.SysVO;
import com.roncoo.education.system.common.interfaces.BossSys;
import com.roncoo.education.system.service.biz.BossSysBiz;
import com.roncoo.education.util.base.BaseController;
import com.roncoo.education.util.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autohor:wangkun
 * @date 2019-05-18-17:19
 * @email:wk20041208@126.com
 */
@RestController
public class BossSysController extends BaseController implements BossSys {
    @Autowired
    private BossSysBiz biz;

    @Override
    public Page<SysVO> listForPage(SysQO qo) {
        return null;
    }

    @Override
    public int save(SysQO qo) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public int updateById(SysQO qo) {
        return 0;
    }

    @Override
    public SysVO getById(Long id) {
        return null;
    }

    @Override
    public SysVO getSys() {

        return biz.getSys();
    }
}
