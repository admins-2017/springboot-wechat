package com.kang.sys.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
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
@TableName("buylist")
@ToString
@Getter
@Setter
public class Buylist implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "buylist_id", type = IdType.AUTO)
    private Integer buylistId;

    /**
     * 进货单单号
     */
    private String buylistNumber;

    /**
     * 该进货单总价格
     */
    private Double buylistAllprice;

    /**
     * 进退货标记 1为进货 2为退货
     */
    private Integer buylistStockorback;

    /**
     * 付款账户
     */
    private Integer buylistPaymentaccountId;

    /**
     * 付款方式 1现金 2微信 3支付宝 4转账 
     */
    private Integer buylistPaymentmethod;

    /**
     * 当前单据以付款金额
     */
    private Double buylistPaid;

    /**
     * 当前进货单未付款金额
     */
    private Double buylistUnpaid;

    /**
     * 进货人id
     */
    private Integer insertUser;

    /**
     * 进货单生成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime insertTime;

    @TableField("uid")
    private Integer uid;

}
