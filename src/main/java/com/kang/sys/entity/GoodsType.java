package com.kang.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GoodsType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "goods_type_id", type = IdType.AUTO)
    private Integer goodsTypeId;

    /**
     * 商品分类名称
     */
    private String goodsTypeName;


}
