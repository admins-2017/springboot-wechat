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
@TableName("settlementaccount")
@ToString
@Getter
@Setter
public class Settlementaccount implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "settlementaccount_id", type = IdType.AUTO)
    private Integer settlementaccountId;
    /**
     * 账户名称
     */
    private String settlementaccountName;

    /**
     * 账号
     */
    private String settlementaccountNumber;

    /**
     * 账户状态 0使用 1暂停使用
     */
    private Integer settlementaccountStatus;

    /**
     * 账户类型
     */
    private String settlementaccountType;

    private Integer uid;


}
