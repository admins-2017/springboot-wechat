package com.kang.sys.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("stock")
@ToString
@Getter
@Setter
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "stock_id", type = IdType.AUTO)
    private Integer stockId;

    private Integer depotId;

    private Integer goodsId;

    /**
     * 库存数量
     */
    private Integer stockNumber;

    /**
     * 最后添加库存的用户
     */
    private Integer lastaddUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime lastaddtoTime;

    private Integer lasttakeoutUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime lasttakeoutTime;

    @TableField("uid")
    private Integer uid;

}
