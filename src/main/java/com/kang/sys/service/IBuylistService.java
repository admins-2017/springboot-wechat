package com.kang.sys.service;

import com.kang.sys.entity.Buylist;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kang.sys.model.BuyListWithDetails;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface IBuylistService extends IService<Buylist> {

    void addBuyListAll(BuyListWithDetails buyListWithDetails);
}
