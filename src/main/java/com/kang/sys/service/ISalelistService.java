package com.kang.sys.service;

import com.kang.sys.entity.Salelist;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kang.sys.model.SaleListWithDetails;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface ISalelistService extends IService<Salelist> {

    int addSaleList(SaleListWithDetails saleListWithDetails);
}
