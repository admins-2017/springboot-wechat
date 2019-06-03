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
 * @since 2019-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Listnumber implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "number_id", type = IdType.AUTO)
    private Integer numberId;

    private Integer uid;

    /**
     * 1为进退货 2为销售
     */
    private Integer buyorsale;

    /**
     * 当前日期
     */
    private String numberTime;

    /**
     * 当前单据编号
     */
    private Integer number;


}
