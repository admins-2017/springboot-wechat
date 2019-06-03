package com.kang.sys.service.impl;

import com.kang.sys.entity.Salelistdetails;
import com.kang.sys.mapper.SalelistdetailsMapper;
import com.kang.sys.service.ISalelistdetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kang.sys.vo.SaleListDetailsWithGoodsAndCustomerAndDepot;
import org.springframework.stereotype.Service;

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
public class SalelistdetailsServiceImpl extends ServiceImpl<SalelistdetailsMapper, Salelistdetails> implements ISalelistdetailsService {

    @Resource
    SalelistdetailsMapper mapper;


    @Override
    public List<SaleListDetailsWithGoodsAndCustomerAndDepot> getSaleById(Integer saleId) {
        return mapper.getSaleById(saleId);
    }
}
