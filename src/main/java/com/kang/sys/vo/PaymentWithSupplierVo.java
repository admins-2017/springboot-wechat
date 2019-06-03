package com.kang.sys.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
@Getter
@Setter
public class PaymentWithSupplierVo {
    private Integer paymentId;
    /**
     * 付款金额
     */
    private Double paymentPrice;

    /**
     * 付款日期
     */
    private Date paymentTime;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 付款方式 1现金 2微信 3支付宝 4转账
     */
    private Integer paymentMethod;

    /**
     * 添加用户
     */
    private Integer insertUser;

    private String nickname;

    /**
     * 添加时间
     */
    private Date insertTime;

    private Integer uid;

    private String supplierName;

    private String supplierAccount;

    /**
     * 账户名称
     */
    private String settlementaccountName;

    /**
     * 账号
     */
    private String settlementaccountNumber;
}
