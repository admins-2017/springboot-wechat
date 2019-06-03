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
@TableName("depot")
@ToString
@Getter
@Setter
public class Depot implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "depot_id", type = IdType.AUTO)
    private Integer depotId;

    /**
     * 仓库名称
     */
    private String depotName;

    /**
     * 仓库地址
     */
    private String depotAddress;

    /**
     * 对应店铺id
     */
    private Integer shopsId;

    /**
     * 删除标记 0为使用 1为停用
     */
    private Integer depotStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime insertTime;

    private Integer insertUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updateTime;

    private Integer updateUser;


}
