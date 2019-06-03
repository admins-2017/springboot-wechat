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
/**
 * @author kang
 * @since 2019-05-21
 */
public class GoodsWithStock {

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
     * 货品类别
     */
    private String goodsCategory;

    /**
     * 商品状态 0上架 1下架
     */
    private Integer goodsStatus;

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

    private String goodsDetaileddescription;

    private String goodsManufacturer;

    /**
     * 库存数量
     */
    private Integer stockNumber;
}
