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
@TableName("payment")
@ToString
@Getter
@Setter
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "payment_id", type = IdType.AUTO)
    private Integer paymentId;
    /**
     * 付款金额
     */
    private Double paymentPrice;

    /**
     * 付款日期
     */
    private String paymentTime;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 付款方式 1现金 2微信 3支付宝 4转账 
     */
    private Integer paymentMethod;

    /**
     * 付款账户
     */
    private Integer paymentAccountId;

    /**
     * 添加用户
     */
    private Integer insertUser;

    /**
     * 添加时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime insertTime;

    @TableField("uid")
    private Integer uid;

    /**
     * 付款单状态 0为正常 1为注销
     */
    @TableField("payment_status")
    private Integer paymentStatus;

}
