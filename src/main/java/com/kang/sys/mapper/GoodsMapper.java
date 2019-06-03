package com.kang.sys.mapper;

import com.kang.sys.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kang.sys.vo.GoodsWithDepot;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 添加商品
     * @param goods
     */
    void addGoods(Goods goods);

    /**
     * 更新商品
     * @param goods
     * @return
     */
    int updateGoods(Goods goods);

    /**
     * 根据用户id和查询编号进行查库存
     * @param uid
     * @param goodsNumbers
     * @return
     */
    @Select("select a.goods_id,a.goods_name,a.goods_number,a.goods_colours,a.goods_models,a.goods_buyreprice,a.goods_salereprice,a.goods_detailedDescription,b.stock_number,c.depot_name,c.depot_address " +
            "from goods a ,stock b ,depot c where  a.goods_id=b.goods_id and b.depot_id=c.depot_id and a.uid=#{uid} and a.goods_number=#{goodsNumber} ")
    List<GoodsWithDepot> getGoodsWithDepot(@Param("uid") Integer uid,@Param("goodsNumber") String goodsNumbers);

    /**
     * 更新商品上架/下架
     * @param goodsStatus
     * @param goodsId
     */
    @Update("UPDATE goods SET goods_status= #{goodsStatus} WHERE goods_id = #{goodsId}")
    void updateGoodsWithStatus(@Param("goodsStatus") Integer goodsStatus,@Param("goodsId")Integer goodsId);
}
