package com.roncoo.education.user.service.dao.impl.mapper;

import com.roncoo.education.user.service.dao.impl.mapper.entity.User;
import com.roncoo.education.user.service.dao.impl.mapper.entity.UserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @autohor:wangkun
 * @date 2019-05-04-17:32
 * @email:wk20041208@126.com
 */
@Mapper
public interface UserMapper {

    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
