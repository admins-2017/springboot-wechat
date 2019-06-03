package com.kang.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

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
@TableName("goods")
@ToString
@Getter
@Setter
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "goods_id", type = IdType.AUTO)
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
    @TableField("goods_category")
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

    /**
     * 商品详细描述
     */
    @TableField("goods_detailedDescription")
    private String goodsDetaileddescription;

    /**
     *商品生产商
     */

    @TableField("goods_manufacturer")
    private String goodsManufacturer;

    /**
     * 添加人
     */
    private Integer insertUser;

    /**
     * 添加时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime insertTime;

    /**
     * 修改用户
     */
    private Integer updateUser;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updateTime;

    @TableField("uid")
    private Integer uid;
}
