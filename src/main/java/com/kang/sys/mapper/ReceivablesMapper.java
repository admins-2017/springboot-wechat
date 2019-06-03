package com.kang.sys.mapper;

import com.kang.sys.entity.Receivables;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kang.sys.vo.ReceivablesWithCustomerVo;
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
public interface ReceivablesMapper extends BaseMapper<Receivables> {
    int addReceivables(Receivables receivables);

    @Select("select a.receivables_id, a.receivables_price,a.receivables_time,a.receivables_method,a.insert_user,a.insert_time,b.customer_name,b.customer_account,c.nickname,d.settlementaccount_name,d.settlementaccount_number \n" +
            "\tfrom receivables a,customer b ,user_info c,settlementaccount d \n" +
            "\twhere a.customer_id=b.customer_id and a.insert_user=c.uid and a.receivablesaccount_id=d.settlementaccount_id and a.uid=#{uid} \n" +
            "\t and receivables_status=0 and CONCAT(a.receivables_time,a.receivables_method,b.customer_name,c.nickname,d.settlementaccount_name) LIKE #{likename}")
    List<ReceivablesWithCustomerVo> findReceivables(@Param("uid")Integer uid, @Param("likename") String datas);

    @Update("UPDATE receivables SET receivables_status=1  WHERE receivables_id=#{id} ")
    void delReceivables(@Param("id") Integer id);

    @Select("select a.receivables_id, a.receivables_price,a.receivables_time,a.receivables_method,a.insert_user,a.insert_time,b.customer_name,b.customer_account,c.nickname,d.settlementaccount_name,d.settlementaccount_number\n" +
            "\tfrom receivables a,customer b ,user_info c,settlementaccount d\n" +
            "            where a.customer_id=b.customer_id and a.insert_user=c.uid and a.receivablesaccount_id=d.settlementaccount_id and a.uid=#{uid} and receivables_status=0 ")
    List<ReceivablesWithCustomerVo> queryHistoryReceivables(Integer uid);
    @Select("select a.receivables_id, a.receivables_price,a.receivables_time,a.receivables_method,a.insert_user,a.insert_time,b.customer_name,b.customer_account,c.nickname,d.settlementaccount_name,d.settlementaccount_number\n" +
            "\tfrom receivables a,customer b ,user_info c,settlementaccount d\n" +
            "            where a.customer_id=b.customer_id and a.insert_user=c.uid and a.receivablesaccount_id=d.settlementaccount_id and a.uid=#{uid} and receivables_status=1 ")
    List<ReceivablesWithCustomerVo> queryHistoryReceivablesWithCancellation(Integer uid);
}
