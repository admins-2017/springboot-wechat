package com.kang.sys.model;

import com.kang.sys.entity.Salelistdetails;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
@Getter
@Setter
public class SaleListWithDetails {
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

    private Integer uid;

    private List<Salelistdetails> salelistdetails;
}
