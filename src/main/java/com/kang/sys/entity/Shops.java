package com.kang.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("shops")
@ToString
@Getter
@Setter
public class Shops implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "shops_id", type = IdType.AUTO)
    private Integer shopsId;

    /**
     * 商铺名称
     */
    private String shopsName;

    /**
     * 商铺所在地址
     */
    private String shopsAddress;

    /**
     * 商铺状态 0.正常使用 1.暂停使用，2删除
     */
    private Integer shopsStatus;

    /**
     * 商铺添加时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime insertTime;

    /**
     * 商铺修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updateTime;

    /**
     * 所属用户id
     */
    private Integer uid;


}
