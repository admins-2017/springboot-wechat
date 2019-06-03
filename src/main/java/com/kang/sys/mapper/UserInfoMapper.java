package com.kang.sys.mapper;

import com.kang.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface UserInfoMapper extends BaseMapper<User> {

    @Select("select uid ,user_power from user_info where uid= #{uid}")
    User findPowerWithUid(Integer uid);

    User findByUserName(String userName);
    int del(@Param("username") String username);

    @Update("UPDATE user_info SET state=1 WHERE uid=#{id}")
    void updateStatus(@Param("id") Integer id);

    @Update("UPDATE user_info SET state=0 WHERE uid=#{id}")
    void updateStatusWithZero(@Param("id") Integer id);
}
