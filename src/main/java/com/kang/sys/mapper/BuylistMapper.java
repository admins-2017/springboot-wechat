package com.kang.sys.mapper;

import com.kang.sys.entity.Buylist;
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
public interface BuylistMapper extends BaseMapper<Buylist> {

    /**
     * 新增进货单
     * @param buylist
     * @return
     */
    int addBuyList(Buylist buylist);

    /**
     * 根据当天日期获取当日进货单消息 用于日结
     * @param uid
     * @param insertTime
     * @return
     */
    @Select("select buylist_id,buylist_allprice,buylist_stockorback,buylist_paymentmethod,buylist_paid,buylist_unpaid" +
            " from buylist where uid=#{uid} and insert_time LIKE  #{insertTime} ")
    List<Buylist> getListForDailyKnots(@Param("uid") Integer uid, @Param("insertTime") String insertTime);
}
