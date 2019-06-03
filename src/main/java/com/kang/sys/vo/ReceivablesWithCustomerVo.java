package com.kang.sys.vo;


import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
@Getter
@Setter
public class ReceivablesWithCustomerVo {

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
     * 收款方式 1现金 2微信 3支付宝 4转账
     */
    private Integer receivablesMethod;

    private Integer insertUser;

    private Date insertTime;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户账户
     */
    private String customerAccount;

    private String nickname;

    /**
     * 账户名称
     */
    private String settlementaccountName;

    /**
     * 账号
     */
    private String settlementaccountNumber;
}
