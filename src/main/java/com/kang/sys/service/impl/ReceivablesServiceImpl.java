package com.kang.sys.service.impl;

import com.kang.sys.entity.Receivables;
import com.kang.sys.mapper.CustomerMapper;
import com.kang.sys.mapper.ReceivablesMapper;
import com.kang.sys.service.IReceivablesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kang.sys.vo.ReceivablesWithCustomerVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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
public class ReceivablesServiceImpl extends ServiceImpl<ReceivablesMapper, Receivables> implements IReceivablesService {

    @Resource
    ReceivablesMapper receivablesMapper;
    @Resource
    CustomerMapper customerMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String addReceivables(Receivables receivables) {
        if (receivables!=null&&!"".equals(receivables.toString())){
            Integer id=receivables.getCustomerId();
            Double price=receivables.getReceivablesPrice();
            customerMapper.subtractSupplierArrears(id,price);
            receivablesMapper.addReceivables(receivables);
            return "新增收款单成功";
        }else{
            return "新增收款单失败";
        }
    }

    @Override
    public List<ReceivablesWithCustomerVo> findReceivables(Integer uid, String datas)  {
        List<ReceivablesWithCustomerVo> list= receivablesMapper.findReceivables(uid,datas);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String delReceivables(Integer id) {
        Receivables receivables=receivablesMapper.selectById(id);
        if (receivables!=null&&!"".equals(receivables.toString())){
            Integer customerId =receivables.getCustomerId();
            Double price= receivables.getReceivablesPrice();
            customerMapper.increaseSupplierArrears(customerId,price);
            receivablesMapper.delReceivables(id);
            return "作废收款单成功";
        }else{
            return "作废收款单失败，查无此单";
        }
    }

    @Override
    public List<ReceivablesWithCustomerVo> queryHistoryReceivables(Integer status, Integer uid) {
        if (status==0){
            List<ReceivablesWithCustomerVo> list=receivablesMapper.queryHistoryReceivables(uid);
            return list;
        }else{
            List<ReceivablesWithCustomerVo> list=receivablesMapper.queryHistoryReceivablesWithCancellation(uid);
            return list;
        }
    }
}
