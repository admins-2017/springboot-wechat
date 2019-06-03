package com.kang.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("buylistdetails")
@ToString
@Getter
@Setter
public class Buylistdetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "buylistdetails_id", type = IdType.AUTO)
    private Integer buylistdetailsId;

    private Integer buylistId;

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
    @TableField("buylist_number")
    private Integer number;

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

}
