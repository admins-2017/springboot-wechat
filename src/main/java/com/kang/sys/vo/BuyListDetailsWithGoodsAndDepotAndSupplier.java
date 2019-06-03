package com.kang.sys.vo;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
@Getter
@Setter
public class BuyListDetailsWithGoodsAndDepotAndSupplier implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer buylistdetailsId;

    /**
     * 放入目标仓库的id
     */
    private Integer depotId;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 供应商id
     */
    private Integer supplierId;

    /**
     * 供货商报价
     */
    private Double supplierPrice;

    /**
     * 进货数量
     */
    private Integer buylistNumber;

    /**
     * 单条进货价格
     */
    private Double buylistPrice;

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
     * 商品名称
     */
    private String goodsName;

    /**
     * 仓库名称
     */
    private String depotName;

    /**
     * 供货商名称
     */
    private String supplierName;
}
