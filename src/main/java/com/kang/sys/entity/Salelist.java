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
@TableName("salelist")
@ToString
@Getter
@Setter
public class Salelist implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "salelist_id", type = IdType.AUTO)
    private Integer salelistId;

    /**
     * 销售单号
     */
    private String salelistNumber;

    /**
     * 当前销售单总金额
     */
    private Double salelistAllprice;

    /**
     * 销售进退货标记 1为销售 2为退货
     */
    private Integer salelistStockorback;

    /**
     * 收款账户id
     */
    private Integer salelistReceivablesaccountId;

    /**
     * 收款方式 1现金 2微信 3支付宝 4转账 
     */
    private Integer salelistReceivablesmethod;

    /**
     * 当前单据以收款金额
     */
    private Double salelistPaid;

    /**
     * 当前单据未收款金额
     */
    private Double salelistUnpaid;

    /**
     * 销售单用户id
     */
    private Integer insertUser;

    /**
     * 销售单生成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime insertTime;

    @TableField("uid")
    private Integer uid;

}
