package com.kang.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Stock;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kang.sys.vo.StockWithDepotAndGoods;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface IStockService extends IService<Stock> {

    void addStock(Stock stock);

    List<StockWithDepotAndGoods> qureyStockWithGoodsNameOrDepotName(Integer uid,String name);

    void increaseStock( Integer id, Integer number, Integer uid);

    void reduceStock( Integer id, Integer number, Integer uid);

    StockWithDepotAndGoods queryStock(Integer goodsid,Integer uid,Integer depotid);

    IPage<Stock> selectPage(Page<Stock> pages, Integer uid);
}
