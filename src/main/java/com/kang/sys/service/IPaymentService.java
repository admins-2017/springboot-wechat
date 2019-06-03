package com.kang.sys.service;

import com.kang.sys.entity.Payment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kang.sys.vo.PaymentWithSupplierVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface IPaymentService extends IService<Payment> {

    int addPayment(Payment payment);

    List<PaymentWithSupplierVo> findPayment(Integer uid,String datas);

    String delPayment(Integer id);

    List<PaymentWithSupplierVo> queryHistoryPayment(Integer status,Integer uid);

}
