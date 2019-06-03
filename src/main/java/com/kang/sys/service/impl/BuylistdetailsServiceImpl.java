package com.kang.sys.service.impl;

import com.kang.sys.entity.Buylistdetails;
import com.kang.sys.mapper.BuylistdetailsMapper;
import com.kang.sys.service.IBuylistdetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kang.sys.vo.BuyListDetailsWithGoodsAndDepotAndSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
@Service
public class BuylistdetailsServiceImpl extends ServiceImpl<BuylistdetailsMapper, Buylistdetails> implements IBuylistdetailsService {

    @Resource
    BuylistdetailsMapper mapper;


    @Override
    public List<BuyListDetailsWithGoodsAndDepotAndSupplier> getDetailsWithBuyId(Integer buyId) {
        return mapper.getDetailsWithBuyId(buyId);
    }
}
