package com.kang.sys.vo;

import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
@Getter
@Setter
public class GoodsWithDepot {

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品编码
     */
    private String goodsNumber;


    /**
     * 商品颜色
     */
    private String goodsColours;

    /**
     * 商品型号
     */
    private String goodsModels;

    /**
     * 供应商报价
     */
    private Double goodsBuyreprice;

    /**
     * 出售客户价格
     */
    private Double goodsSalereprice;

    /**
     * 商品详细描述
     */
    private String goodsDetaileddescription;

    /**
     * 库存数量
     */
    private Integer stockNumber;

    /**
     * 仓库名称
     */
    private String depotName;

    /**
     * 仓库地址
     */
    private String depotAddress;
}
