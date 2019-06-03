package com.kang.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Customer;
import com.kang.sys.mapper.CustomerMapper;
import com.kang.sys.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Resource
    CustomerMapper customerMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addCustomer(Customer customer) {
        return  customerMapper.addCustomer(customer);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateCustomer(Customer customer) {
       return customerMapper.updateCustomer(customer);
    }

    @Override
    public IPage<Customer> selectPage(Page<Customer> pages, Integer uid) {
        IPage<Customer> customerIPage = customerMapper.selectPage(pages,new QueryWrapper<Customer>().eq("customer_status","0").eq("uid",uid));
        return customerIPage;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delCustomer(Integer id) {
        customerMapper.delCustomer(id);
    }
}
