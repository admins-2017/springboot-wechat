package com.kang.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kang.sys.vo.GoodsWithDepot;
import com.kang.sys.vo.GoodsWithStock;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface IGoodsService extends IService<Goods> {
    /**
     * 添加商品
     * @param goods
     */
    void addGoods(Goods goods);

    /**
     * 获取商品根据模糊查询
     * @param goodsname
     * @return
     */
    List<GoodsWithStock> getGoodsWithName(String goodsname);

    /**
     * 获取所有线上产品分页
     * @param pages
     * @return
     */
    IPage<Goods> selectPage(Page<Goods> pages);

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    int updateGoods(Goods goods);

    /**
     * 根据商品编号查询商品库存及商铺
     * @param goodsNumbers
     * @param uid
     * @return
     */
    List<GoodsWithDepot> getGoodsWithDepot(Integer uid,String goodsNumbers);

    /**
     * 更新商品上架/下架
     * @param goodsStatus
     * @param goodsId
     */
    void updateGoodsWithStatus(Integer goodsStatus,Integer goodsId);

    /**
     * 根据商品编号查询库存
     * @param uid
     * @param goodsNumbers
     * @return
     */
    GoodsWithStock getGoodsAndStockWithGoodsNumber(Integer uid, String goodsNumbers) ;

    /**
     * 获取所有上架商品信息及库存
     * @param uid
     * @return
     */
    List<GoodsWithStock> getGoodsAll(Integer uid);
}
