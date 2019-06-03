package com.kang.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Stock;
import com.kang.sys.mapper.StockMapper;
import com.kang.sys.service.IStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kang.sys.vo.StockWithDepotAndGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements IStockService {

    @Resource
    StockMapper stockMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addStock(Stock stock) {
        stockMapper.addStock(stock);
    }

    @Override
    public List<StockWithDepotAndGoods> qureyStockWithGoodsNameOrDepotName(Integer uid,String name) {
        return stockMapper.qureyStockWithGoodsNameOrDepotName(uid,name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void increaseStock(Integer id, Integer number, Integer uid) {
        stockMapper.increaseStock(id,number,uid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void reduceStock(Integer id, Integer number, Integer uid) {
        stockMapper.reduceStock(id,number,uid);
    }

    @Override
    public StockWithDepotAndGoods queryStock(Integer goodsid, Integer uid, Integer depotid) {
        return stockMapper.queryStock(goodsid,uid,depotid);
    }

    @Override
    public IPage<Stock> selectPage(Page<Stock> pages, Integer uid) {
        IPage<Stock> selectPage = stockMapper.selectPage(pages,new QueryWrapper<Stock>().eq("uid",uid));
        return selectPage;
    }
}
