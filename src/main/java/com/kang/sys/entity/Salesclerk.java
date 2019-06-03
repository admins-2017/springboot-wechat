package com.kang.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

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
@TableName("salesclerk")
@ToString
@Getter
@Setter
public class Salesclerk implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "salesclerk_id", type = IdType.AUTO)
    private Integer salesclerkId;

    /**
     * 营业员名称
     */
    private String salesclerkName;

    /**
     * 营业员登录密码
     */
    private String salesclerkPassword;

    /**
     * 营业员登录账号
     */
    private String salesclerkLogin;

    /**
     * 营业员状态 0 正常 1离职
     */
    private Integer salesclerkStatus;

    /**
     * 添加时间
     */
    private LocalDateTime insertTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 所属用户id
     */
    private Integer uid;

    /**
     * 所属商铺id
     */
    private Integer shopsId;


}
