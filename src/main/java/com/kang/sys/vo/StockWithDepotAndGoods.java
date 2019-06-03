package com.kang.sys.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
@Getter
@Setter
public class StockWithDepotAndGoods {
    private Integer stockId;
    /**
     * 库存数量
     */
    private Integer stockNumber;

    private Integer depotId;

    private Integer goodsId;

    /**
     * 最后添加库存的用户
     */
    private Integer lastaddUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime lastaddtoTime;

    private Integer lasttakeoutUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime lasttakeoutTime;

    /**
     * 仓库名称
     */
    private String depotName;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 用户真实姓名
     */
    private String nickname;
}
