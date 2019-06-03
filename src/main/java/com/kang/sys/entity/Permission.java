package com.kang.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_permission")
@ToString
@Getter
@Setter
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父编号,本权限可能是该父编号权限的子权限
     */
    private Integer parentId;

    /**
     * 父编号列表
     */
    private String parentIds;

    /**
     * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    private String permission;

    /**
     * 资源类型，[menu|button]
     */
    private String resourceType;

    /**
     * 资源路径 如：/userinfo/list
     */
    private String url;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 是否可用0可用  1不可用
     */
    private String available;

    private Set<Role> roles = new HashSet<>();

}
