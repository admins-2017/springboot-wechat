package com.kang.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

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
@TableName("supplier")
@ToString
@Getter
@Setter
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "supplier_id", type = IdType.AUTO)
    private Integer supplierId;

    /**
     * 供货商名称
     */
    private String supplierName;

    /**
     * 供货商账户
     */
    private String supplierAccount;

    /**
     * 供货商联系电话
     */
    private String supplierPhone;

    /**
     * 供货商联系地址
     */
    private String supplierAddress;

    /**
     * 所欠供货商总计
     */
    private Double supplierArrears;

    /**
     * 供货商状态 0为使用 1为删除
     */
    private Integer supplierStatus;

    /**
     * 对应用户
     */
    private Integer uid;

    /**
     * 供货商描述
     */
    private String supplierDescribe;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime insertTime;

    private Integer insertUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updateTime;

    private Integer updateUser;

    /**
     * 经营种类,对应经营种类表id
     */
    @TableField("management_id")
    private String managementId;


}
