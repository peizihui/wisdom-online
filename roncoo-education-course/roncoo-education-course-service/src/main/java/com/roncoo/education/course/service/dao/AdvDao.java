package com.roncoo.education.course.service.dao;

import com.roncoo.education.course.service.dao.impl.mapper.entity.Adv;
import com.roncoo.education.course.service.dao.impl.mapper.entity.AdvExample;
import com.roncoo.education.util.base.Page;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-20-2:10
 * @email:wk20041208@126.com
 */
public interface AdvDao {
    int save(Adv record);

    int deleteById(Long id);

    int updateById(Adv record);

    Adv getById(Long id);

    Page<Adv> listForPage(int pageCurrent, int pageSize, AdvExample example);

    /**
     * 列出广告信息，注意：开始时间<现在时间<结束时间
     *
     * @param platShow
     * @param statusId
     * @author wuyun
     */
    List<Adv> listByPlatShowAndStatusId(Integer platShow, Integer statusId);
}
