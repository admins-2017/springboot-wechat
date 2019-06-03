package com.kang.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Setter
@Getter
public class DayOfSettlement implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "daysettlement_id", type = IdType.AUTO)
    private Integer daysettlementId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime daysettlementTime;

    /**
     * 当日付款总金额
     */
    private Double daysettlementBuyprice;

    /**
     * 当日已付款金额
     */
    private Double buylistPaid;

    /**
     * 当日未付款金额
     */
    private Double buylistUnpaid;

    /**
     * 当日销售总金额
     */
    private Double daysettlementSaleprice;

    /**
     * 当日已收款金额
     */
    private Double salelistPaid;

    /**
     * 当日未收款金额
     */
    private Double salelistUnpaid;

    /**
     * 当日进货次数
     */
    private Integer daysettlementBuynumber;

    /**
     * 进货单退货次数
     */
    private Integer daysettlementBuyretreatnumber;

    /**
     * 当日销售次数
     */
    private Integer daysettlementSalenumber;

    /**
     * 销售退货次数
     */
    private Integer daysettlementSaleretreatnumber;

    /**
     * 当日现金收款总金额
     */
    private Double receivablesCash;

    /**
     * 当日转账收款总金额
     */
    private Double receivablesTransferaccounts;

    /**
     * 当日微信收款总金额
     */
    private Double receivablesWechat;

    /**
     * 当日支付宝收款总金额
     */
    private Double receivablesAllpay;
    /**
     * 当日现金付款总金额
     */
    private Double paymentCash;
    /**
     * 当日转账付款总金额
     */
    private Double paymentTransferaccounts;
    /**
     * 当日微信付款总金额
     */
    private Double paymentWechat;
    /**
     * 当日支付宝付款总金额
     */
    private Double paymentAllpay;

    private Integer uid;

}
