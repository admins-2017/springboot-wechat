package com.kang.sys.service.impl;

import com.kang.sys.entity.Payment;
import com.kang.sys.mapper.PaymentMapper;
import com.kang.sys.mapper.SupplierMapper;
import com.kang.sys.service.IPaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kang.sys.vo.PaymentWithSupplierVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements IPaymentService {

    @Resource
    PaymentMapper paymentMapper;
    @Resource
    SupplierMapper supplierMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addPayment(Payment payment) {
        Integer supplierid =payment.getSupplierId();
        Double paymentPrice=payment.getPaymentPrice();
        supplierMapper.subtractSupplierArrears(supplierid,paymentPrice);
        paymentMapper.addPayment(payment);
        return 0;
    }

    @Override
    public List<PaymentWithSupplierVo> findPayment(Integer uid,String datas) {
        List<PaymentWithSupplierVo> list=paymentMapper.findPayment(uid,datas);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String delPayment(Integer id) {
        Payment payment=paymentMapper.selectById(id);
        if(payment!=null && !"".equals(payment.toString())){
            Integer supplierid=payment.getSupplierId();
            Double price =payment.getPaymentPrice();
            supplierMapper.increaseSupplierArrears(supplierid,price);
            paymentMapper.delPayment(id);
            return "注销付款单成功，所欠供应商款已累加";
        }else {
            return "注销付款单失败，查无此单";
        }

    }

    /**
     * 查询历史
     * @param status
     * @param uid
     * @return
     */
    @Override
    public List<PaymentWithSupplierVo> queryHistoryPayment(Integer status,Integer uid) {
        if(status==0) {
            List<PaymentWithSupplierVo> list = paymentMapper.queryHistoryPayment(uid);
            return list;
        }else{
            List<PaymentWithSupplierVo> list=paymentMapper.queryHistoryPaymentWithCancellation(uid);
            return list;
        }
    }


}
