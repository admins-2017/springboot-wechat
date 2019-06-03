package com.kang.sys.mapper;

import com.kang.sys.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface CustomerMapper extends BaseMapper<Customer> {

    int addCustomer(Customer customer);

    int updateCustomer(Customer customer);

    @Update("UPDATE customer SET customer_status=1  WHERE customer_id=#{id} ")
    void delCustomer(@Param("id") Integer id);

    @Update("UPDATE customer SET customer_arrears=(customer_arrears+ #{receivablesPrice}) WHERE customer_id=#{customerId}")
    int increaseSupplierArrears(@Param("customerId") Integer customerid,@Param("receivablesPrice") Double receivablesPrice);

    @Update("UPDATE customer SET customer_arrears=(customer_arrears- #{receivablesPrice}) WHERE customer_id=#{customerId}")
    int subtractSupplierArrears(@Param("customerId") Integer customerid,@Param("receivablesPrice") Double receivablesPrice);
}
