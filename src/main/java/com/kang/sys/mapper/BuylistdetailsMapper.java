package com.kang.sys.mapper;

import com.kang.sys.entity.Buylistdetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kang.sys.vo.BuyListDetailsWithGoodsAndDepotAndSupplier;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface BuylistdetailsMapper extends BaseMapper<Buylistdetails> {

    /**
     * 添加明细
     * @param buylistdetails
     */
    void addBuylistdetails(Buylistdetails buylistdetails);

    /**
     * 根据进货单id查询明细
     * @param buyId
     * @return
     */
    @Select("select a.buylistdetails_id as buylistdetails_id,a.depot_id as depot_id ,a.goods_id as goods_id," +
            "a.supplier_id as supplier_id,a.supplier_price as supplier_price ,a.buylist_number as buylist_number," +
            "a.buylist_price as buylist_price ,buylist_settle as buylist_settle," +
            "a.buylist_paid as buylist_paid,a.buylist_unpaid as buylist_unpaid,b.goods_name,c.depot_name,d.supplier_name " +
            "from buylistdetails a,goods b,depot c,supplier d " +
            "where a.goods_id=b.goods_id and a.depot_id=c.depot_id and a.supplier_id=d.supplier_id and a.buylist_id=#{buyId}")
    List<BuyListDetailsWithGoodsAndDepotAndSupplier> getDetailsWithBuyId(@Param("buyId") Integer buyId);
}
