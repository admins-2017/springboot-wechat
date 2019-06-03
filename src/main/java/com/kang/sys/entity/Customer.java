package com.kang.sys.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@TableName("customer")
@ToString
@Getter
@Setter
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "customer_id", type = IdType.AUTO)
    private Integer customerId;
    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户联系方式
     */
    private String customerPhone;

    /**
     * 客户联系地址
     */
    private String customerAddress;

    /**
     * 客户详细地址
     */
    @TableField("customer_detailed_address")
    private String customerDetailedAddress;

    /**
     * 客户性别 0为男 1为女
     */
    private Integer customerSex;

    /**
     * 经营种类,对应经营种类表id
     */
    @TableField("management")
    private String management;

    /**
     * 客户账户
     */
    private String customerAccount;

    /**
     * 客户欠款
     */
    private String customerArrears;

    /**
     * 0为在线 1为删除
     */
    private Integer customerStatus;

    private Integer insertUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime insertTime;

    private Integer updateUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updateTime;

    @TableField("uid")
    private Integer uid;

    private String customerDeatis;

}
