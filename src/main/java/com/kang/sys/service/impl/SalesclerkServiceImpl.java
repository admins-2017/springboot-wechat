package com.kang.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Salesclerk;
import com.kang.sys.mapper.SalesclerkMapper;
import com.kang.sys.service.ISalesclerkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
@Service
public class SalesclerkServiceImpl extends ServiceImpl<SalesclerkMapper, Salesclerk> implements ISalesclerkService {

    @Resource
    SalesclerkMapper  salesclerkMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addSalesclerk(Salesclerk salesclerk) { return  salesclerkMapper.addSalesclerk(salesclerk); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateSalesclerk(Salesclerk salesclerk) { return salesclerkMapper.updateSalesclerk(salesclerk); }

    @Override
    public IPage<Salesclerk> selectPage(Page<Salesclerk> page, Integer uid) {
        IPage<Salesclerk> salesclerkIPage = salesclerkMapper.selectPage(page,new QueryWrapper<Salesclerk>().eq("salesclerk_status","0").eq("uid",uid));
        return salesclerkIPage;
    }

    @Override
    public void delSalesclerk(Integer id) { salesclerkMapper.delSalesclerk(id); }
}
