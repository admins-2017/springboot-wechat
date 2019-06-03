package com.kang.sys.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kang.sys.entity.Buylistdetails;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
@Getter
@Setter
public class BuyListWithDetails {
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
     * 进货单结清标记 1为结清 2为未结清
     */
    private Integer buylistSettle;

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
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime insertTime;

    private List<Buylistdetails> buylistdetails;

}
