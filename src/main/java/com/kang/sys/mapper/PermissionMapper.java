package com.kang.sys.mapper;

import com.kang.sys.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kang.sys.entity.Role;
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
public interface PermissionMapper extends BaseMapper<Permission> {

    Set<Permission> findPermissionsByRoleId(@Param("roles") Set<Role> roles);
}
