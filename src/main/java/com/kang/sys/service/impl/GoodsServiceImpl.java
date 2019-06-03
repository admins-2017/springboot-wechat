package com.kang.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Goods;
import com.kang.sys.mapper.GoodsMapper;
import com.kang.sys.mapper.StockMapper;
import com.kang.sys.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kang.sys.vo.GoodsWithDepot;
import com.kang.sys.vo.GoodsWithStock;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Resource
    GoodsMapper goodsMapper;
    @Resource
    StockMapper stockMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void addGoods(Goods goods) {
            goodsMapper.addGoods(goods);
    }

    /**
     * 用于商品模糊查询
     */
    @Override
    public List<GoodsWithStock> getGoodsWithName(String goodsname) {
        List<GoodsWithStock> goodsWithStockList=new ArrayList<>();
        List<Goods> goodsList=goodsMapper.selectList(
                new QueryWrapper<Goods>().eq("uid",1).eq("goods_status",0).like("goods_name",goodsname).or()
                        .eq("uid",1).eq("goods_status",0).like("goods_number",goodsname).or()
                        .eq("uid",1).eq("goods_status",0).like("goods_manufacturer",goodsname)
                        .eq("uid",1).eq("goods_status",0).like("goods_category",goodsname));
       if (goodsList.size()==0){
           return goodsWithStockList;
       }else {
           return findStockWithGoodsIdAndUid(goodsList);
       }
    }

    @Override
    public IPage<Goods> selectPage(Page<Goods> pages) {
        IPage<Goods> userIPage = goodsMapper.selectPage(pages,new QueryWrapper<Goods>().eq("goods_status","0")
            .eq("uid",1));
        return userIPage;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public List<GoodsWithDepot> getGoodsWithDepot(Integer uid,String goodsNumbers) {
        return goodsMapper.getGoodsWithDepot(uid,goodsNumbers);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updateGoodsWithStatus(Integer goodsStatus, Integer goodsId) {
        goodsMapper.updateGoodsWithStatus(goodsStatus,goodsId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public GoodsWithStock getGoodsAndStockWithGoodsNumber(Integer uid, String goodsNumbers) {
        GoodsWithStock goodsWithStock=new GoodsWithStock();
        Goods goods=goodsMapper.selectOne(new QueryWrapper<Goods>().eq("uid",uid).eq("goods_number",goodsNumbers));
        if(null!=goods&&!"".equals(goods.toString())){
            Integer stockNumber = stockMapper.getStockNumberWithGoodsIdAndUid(goods.getUid(),goods.getGoodsId());
            if (null == stockNumber) {
                stockNumber = 0;
            }
            BeanUtils.copyProperties(goods,goodsWithStock);
            goodsWithStock.setStockNumber(stockNumber);
            return goodsWithStock;
        }else {
            return null;
        }
    }

    @Override
    public List<GoodsWithStock> getGoodsAll(Integer uid) {
        List<GoodsWithStock> goodsWithStockList=new ArrayList<>();
        List<Goods> goodsList=goodsMapper.selectList(
                new QueryWrapper<Goods>().eq("uid",uid).eq("goods_status",0));
        if (goodsList.size()==0){
            return goodsWithStockList;
        }else {
            return findStockWithGoodsIdAndUid(goodsList);
        }
    }

    public List<GoodsWithStock> findStockWithGoodsIdAndUid(List<Goods> goodsList){
        List<GoodsWithStock> goodsWithStockList=new ArrayList<>();
        if (null!=goodsList&&0!=goodsList.size()){
            for (int i=0;i<goodsList.size();i++){
                Integer stockNumber=stockMapper.getStockNumberWithGoodsIdAndUid(goodsList.get(i).getUid(),goodsList.get(i).getGoodsId());
                if (null==stockNumber){
                    stockNumber=0;
                }
                GoodsWithStock goodsWithStock=new GoodsWithStock();
                BeanUtils.copyProperties(goodsList.get(i),goodsWithStock);
                goodsWithStock.setStockNumber(stockNumber);
                goodsWithStockList.add(goodsWithStock);
            }
            return goodsWithStockList;
        }else {
            return null;
        }
    }
}
