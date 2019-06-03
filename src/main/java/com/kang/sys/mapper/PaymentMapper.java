package com.kang.sys.mapper;

import com.kang.sys.entity.Payment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kang.sys.vo.PaymentWithSupplierVo;
import org.apache.ibatis.annotations.Delete;
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
public interface PaymentMapper extends BaseMapper<Payment> {

    int addPayment(Payment payment);

    @Select("select a.payment_id, a.payment_price,a.payment_time,a.payment_method,a.insert_time,b.supplier_name,b.supplier_account,c.nickname,d.settlementaccount_name,d.settlementaccount_number from payment a,supplier b ,user_info c,settlementaccount d where a.supplier_id=b.supplier_id and a.insert_user=c.uid and a.payment_account_id=d.settlementaccount_id and a.uid=#{uid}" +
            " and payment_status=0 and CONCAT(a.payment_time,a.payment_method,b.supplier_name,c.nickname,d.settlementaccount_name) LIKE  #{likename} ")
    List<PaymentWithSupplierVo> findPayment(@Param("uid")Integer uid,@Param("likename") String datas);

    @Update("UPDATE payment SET payment_status=1  WHERE payment_id=#{id} ")
    void delPayment(@Param("id") Integer id);
    @Select("select a.payment_id, a.payment_price,a.payment_time,a.payment_method,a.insert_time,b.supplier_name,b.supplier_account,c.nickname,d.settlementaccount_name,d.settlementaccount_number from payment a,supplier b ,user_info c,settlementaccount d\n" +
            "\t\twhere a.supplier_id=b.supplier_id and a.insert_user=c.uid and a.payment_account_id=d.settlementaccount_id and a.uid=#{uid} and payment_status=0 ")
    List<PaymentWithSupplierVo> queryHistoryPayment(Integer uid);
    @Select("select a.payment_id, a.payment_price,a.payment_time,a.payment_method,a.insert_time,b.supplier_name,b.supplier_account,c.nickname,d.settlementaccount_name,d.settlementaccount_number from payment a,supplier b ,user_info c,settlementaccount d\n" +
            "\t\twhere a.supplier_id=b.supplier_id and a.insert_user=c.uid and a.payment_account_id=d.settlementaccount_id and a.uid=#{uid} and payment_status=1 ")
    List<PaymentWithSupplierVo> queryHistoryPaymentWithCancellation(Integer uid);
}
