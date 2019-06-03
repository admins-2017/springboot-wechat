package com.kang.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

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
@TableName("salelistdetails")
@ToString
@Getter
@Setter
public class Salelistdetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "salelistdetails_id", type = IdType.AUTO)
    private Integer salelistdetailsId;

    /**
     * 销售单id
     */
    private Integer salelistId;

    /**
     * 出货仓库id
     */
    private Integer depotId;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 客户id
     */
    private Integer customerId;

    /**
     * 销售价格/客户报价
     */
    private Double customerPrice;

    /**
     * 销售数量
     */
    private Integer saleNumber;

    /**
     * 单条销售金额
     */
    private Double salePrice;

    /**
     * 结清标记 已结清为1 未结清为2
     */
    private Integer salelistSettle;

    /**
     * 当前单据以收款金额
     */
    private Double salelistPaid;

    /**
     * 当前单据未收款金额
     */
    private Double salelistUnpaid;

}
