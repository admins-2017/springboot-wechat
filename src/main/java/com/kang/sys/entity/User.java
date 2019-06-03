package com.kang.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("user_info")
@ToString
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 用户真实姓名
     */
    private String nickname;

    /**
     * 用户身份证号
     */
    private String idCardNum;

    /**
     * 用户状态：0:正常状态,1：用户被锁定
     */
    private String state;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 用户注册时间
     */
    private LocalDateTime insertTime;

    /**
     * 用户信息更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 用户职称，0为老板，1为店长，2为普通店员
     */
    private Integer userTitle;

    /**
     * 用户所属老板id manager 为boos 
     */
    private String userPower;

    /**
     * 默认商铺id
     */
    private Integer shopsId;

    private Set<Role> roles = new HashSet<>();

}
