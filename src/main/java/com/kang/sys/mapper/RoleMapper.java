package com.kang.sys.mapper;

import com.kang.sys.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface RoleMapper extends BaseMapper<Role> {

    Set<Role> findRolesByUserId(@Param("uid") Integer uid);
}
