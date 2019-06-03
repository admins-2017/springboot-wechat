package com.kang.sys.mapper;

import com.kang.sys.entity.Salelistdetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kang.sys.vo.SaleListDetailsWithGoodsAndCustomerAndDepot;
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
public interface SalelistdetailsMapper extends BaseMapper<Salelistdetails> {

    void addSaleListDetails(Salelistdetails salelistdetails);

    /**
     * 获取销售明细
     * @param saleId
     * @return
     */
    @Select("SELECT a.salelistdetails_id as salelistdetails_id,a.depot_id as depot_id,a.goods_id as goods_id,a.customer_id as customer_id,a.customer_price as customer_price," +
            "a.sale_number as sale_number ,a.sale_price as sale_price ,a.salelist_settle as salelist_settle,a.salelist_paid as salelist_paid,a.salelist_unpaid as salelist_unpaid " +
            ",b.goods_name,c.depot_name,d.customer_name  FROM salelistdetails a,goods b,depot c,customer d " +
            "where a.goods_id=b.goods_id and a.depot_id=c.depot_id and a.customer_id=d.customer_id and a.salelist_id=#{saleId}")
    List<SaleListDetailsWithGoodsAndCustomerAndDepot> getSaleById(@Param("saleId") Integer saleId);
}
