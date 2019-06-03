package com.kang.sys.service;

import com.kang.sys.entity.Salelistdetails;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kang.sys.vo.SaleListDetailsWithGoodsAndCustomerAndDepot;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface ISalelistdetailsService extends IService<Salelistdetails> {

    List<SaleListDetailsWithGoodsAndCustomerAndDepot> getSaleById(Integer saleId);
}
