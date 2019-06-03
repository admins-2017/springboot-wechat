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
@TableName("receivables")
@ToString
@Getter
@Setter
public class Receivables implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "receivables_id", type = IdType.AUTO)
    private Integer receivablesId;
    /**
     * 收款金额
     */
    private Double receivablesPrice;
    /**
     * 收款日期
     */
    private String receivablesTime;

    /**
     * 客户id
     */
    private Integer customerId;

    /**
     * 收款方式 1现金 2微信 3支付宝 4转账 
     */
    private Integer receivablesMethod;

    /**
     * 收款账户
     */
    private Integer receivablesaccountId;

    private Integer insertUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime insertTime;

    @TableField("uid")
    private Integer uid;

    /**
     * 付款单状态 0为正常 1为注销
     */
    @TableField("receivables_status")
    private Integer receivablesStatus;


}
