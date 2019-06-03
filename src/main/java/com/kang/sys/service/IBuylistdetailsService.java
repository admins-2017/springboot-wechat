package com.kang.sys.service;

import com.kang.sys.entity.Buylistdetails;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kang.sys.mapper.BuylistdetailsMapper;
import com.kang.sys.vo.BuyListDetailsWithGoodsAndDepotAndSupplier;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface IBuylistdetailsService extends IService<Buylistdetails> {

    List<BuyListDetailsWithGoodsAndDepotAndSupplier> getDetailsWithBuyId(Integer buyId);
}
