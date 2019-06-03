package com.kang.sys.model;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
@Getter
@Setter
public class SettlementaccountModel {
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
     * 账户类型
     */
    private String settlementaccountType;

    private Integer uid;
}
