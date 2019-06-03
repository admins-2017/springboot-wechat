package com.kang.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface ICustomerService extends IService<Customer> {
    int addCustomer(Customer customer);

    int updateCustomer(Customer customer);

    IPage<Customer> selectPage(Page<Customer> pages, Integer uid);

    void delCustomer(Integer id);
}
