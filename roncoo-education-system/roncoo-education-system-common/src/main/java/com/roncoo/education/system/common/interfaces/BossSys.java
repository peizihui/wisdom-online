package com.roncoo.education.system.common.interfaces;

/**
 * @autohor:wangkun
 * @date 2019-05-18-1:58
 * @email:wk20041208@126.com
 */

import com.roncoo.education.system.common.bean.qo.SysQO;
import com.roncoo.education.system.common.bean.vo.SysVO;
import com.roncoo.education.util.base.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 系统配置表
 */
public interface BossSys {
    @RequestMapping(value = "/boss/system/sys/listForPage", method = RequestMethod.POST)
    Page<SysVO> listForPage(@RequestBody SysQO qo);

    @RequestMapping(value = "/boss/system/sys/save", method = RequestMethod.POST)
    int save(@RequestBody SysQO qo);

    @RequestMapping(value = "/boss/system/sys/deleteById", method = RequestMethod.DELETE)
    int deleteById(@RequestBody Long id);

    @RequestMapping(value = "/boss/system/sys/updateById", method = RequestMethod.PUT)
    int updateById(@RequestBody SysQO qo);

    @RequestMapping(value = "/boss/system/sys/getById", method = RequestMethod.GET)
    SysVO getById(@RequestBody Long id);

    /**
     * 获得系统配置表信息
     *
     * @return
     * @author YZJ
     */
    @RequestMapping(value = "/boss/system/sys/getSys", method = RequestMethod.POST)
    SysVO getSys();
}
