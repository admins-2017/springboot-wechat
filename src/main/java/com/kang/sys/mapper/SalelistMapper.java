package com.kang.sys.mapper;

import com.kang.sys.entity.Salelist;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface SalelistMapper extends BaseMapper<Salelist> {

    /**
     * 新增销售单
     * @param salelist
     * @return
     */
    int addSaleList(Salelist salelist);

    /**
     * 根据当日时间对销售单进行日结
     * @param uid
     * @param insertTime
     * @return
     */
    @Select("select salelist_id,salelist_allprice,salelist_stockorback,salelist_receivablesmethod,salelist_paid,salelist_unpaid" +
            " from salelist where uid=#{uid} and insert_time LIKE #{insertTime}")
    List<Salelist> getSaleListFroDailyKnots(@Param("uid") Integer uid,@Param("insertTime") String insertTime);
}
