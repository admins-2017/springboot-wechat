package com.kang.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Customer;
import com.kang.sys.service.ICustomerService;
import com.kang.utils.json.JSONResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
@RestController
@RequestMapping("/customer")
@Api("客户")
public class CustomerController {

    @Autowired
    ICustomerService customerService;
    @PostMapping("/")
    public JSONResult addCustomer(Customer customer){
        try {
            customerService.addCustomer(customer);
            return JSONResult.ok("保存成功");
        }catch (Exception e){
            return JSONResult.errorMsg("保存失败："+e.getMessage());
        }
    }

    @GetMapping("/")
    public JSONResult getCustomerWithPage(){
        try{
            List<Customer> customerList = customerService.getBaseMapper().selectList(new QueryWrapper<Customer>()
            .eq("uid",1).eq("customer_status",0));
            if(customerList!=null&&!customerList.isEmpty()){
                return JSONResult.ok(customerList);
            }else {
                return JSONResult.errorNofind("查询无客户");
            }
        }catch (Exception e){
            return JSONResult.errorException("查询报错："+e.getMessage());
        }
    }

    @GetMapping("/{uid}/{likename}")
    public JSONResult getCustomerWithLikename(@PathVariable Integer uid,@PathVariable String likename){
        try{
            List<Customer> customerIPage = customerService.getBaseMapper().selectList(new QueryWrapper<Customer>()
                    .eq("uid",uid).eq("customer_status","0").like("customer_name",likename)
                    .or().eq("uid",uid).eq("customer_status","0").like("customer_phone",likename));
            if(customerIPage.size()>0){
                return JSONResult.ok(customerIPage);
            }else {
                return JSONResult.errorNofind("查询无客户");
            }
        }catch (Exception e){
            return JSONResult.errorException("查询报错："+e.getMessage());
        }
    }

    @PutMapping("/")
    public JSONResult updateCustomer(Customer customer){
        try{
            customerService.updateCustomer(customer);
            return JSONResult.ok("修改成功");
        }catch (Exception e){
            return JSONResult.errorException("修改失败："+e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public JSONResult delCustomer(@PathVariable Integer id){
        System.out.println("id"+id);
        try{
            customerService.delCustomer(id);
            return JSONResult.ok("删除成功");
        }catch (Exception e){
            return JSONResult.errorMsg("删除失败:"+e.getMessage());
        }
    }
}
