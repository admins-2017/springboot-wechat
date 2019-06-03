package com.kang.sys.mapper;

import com.kang.sys.entity.Stock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kang.sys.vo.StockWithDepotAndGoods;
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
public interface StockMapper extends BaseMapper<Stock> {

    void addStock(Stock stock);

    @Select("select a.stock_id,a.stock_number,a.lastaddto_time,a.lastadd_user,a.lasttakeout_time,a.lasttakeout_user,b.goods_name,c.depot_name,d.nickname\n" +
            "from stock a,goods b,depot c,user_info d\n" +
            "where a.goods_id=b.goods_id and a.depot_id =c.depot_id and a.lastadd_user=d.uid and a.uid=#{uid}" +
            " and CONCAT(b.goods_name,c.depot_name) LIKE #{name}")
    List<StockWithDepotAndGoods> qureyStockWithGoodsNameOrDepotName(@Param("uid") Integer uid,@Param("name") String name);

    @Update("UPDATE stock SET stock_number=stock_number + #{number},lastadd_user=#{lastaddUser},lastaddto_time=now()  WHERE stock_id=#{id}")
    void increaseStock(@Param("id") Integer id, @Param("number") Integer number,@Param("lastaddUser") Integer uid);
    @Update("UPDATE stock SET stock_number=stock_number - #{number},lasttakeout_user=#{lasttakeoutUser},lasttakeout_time=now()  WHERE stock_id=#{id}")
    void reduceStock(@Param("id") Integer id, @Param("number") Integer number,@Param("lasttakeoutUser") Integer uid);

    @Select("select a.stock_id,a.stock_number,a.lastaddto_time,a.lastadd_user,a.lasttakeout_time,a.lasttakeout_user,a.goods_id,a.depot_id,b.goods_name,c.depot_name\n" +
            "\tfrom stock a ,goods b,depot c \n" +
            "where a.goods_id=b.goods_id and a.depot_id=c.depot_id and\n" +
            "a.goods_id=#{goodsId} and a.depot_id=#{depotId} and a.uid=#{id}")
    StockWithDepotAndGoods queryStock(@Param("goodsId")Integer goodsid,@Param("id")Integer uid,@Param("depotId")Integer depotid);

    @Select("select stock_id,stock_number from stock where goods_id=#{goodsId} and depot_id=#{depotId} and uid=#{id}")
    Stock findStockNullOrNotNull(@Param("goodsId")Integer goodsid,@Param("depotId")Integer depotid,@Param("id")Integer uid);

    @Select("select sum(stock_number) from stock where uid =#{uid} and goods_id=#{goodsId}")
    Integer getStockNumberWithGoodsIdAndUid(@Param("uid") Integer uid,@Param("goodsId")Integer goodsId);
}
