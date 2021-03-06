package com.kang.sys.controller;


import com.kang.sys.entity.Salelistdetails;
import com.kang.utils.json.JSONResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
@RestController
@RequestMapping("/salelistdetails")
@Api("用户基础类")
public class SalelistdetailsController {

    @PostMapping("/")
    public JSONResult addSalelistdetails(Salelistdetails salelistdetails){
        System.out.println("执行添加");
        return JSONResult.ok();
    }

    @GetMapping("/{page}/{size}")
    public JSONResult getSalelistdetailsWithPage(@PathVariable Integer page, @PathVariable Integer size){
        System.out.println("执行查询"+page+":"+size);
        return JSONResult.ok();
    }

    @PutMapping("/")
    public JSONResult updateSalelistdetails(Salelistdetails salelistdetails){
        System.out.println("执行修改");
        return JSONResult.ok();
    }

    @DeleteMapping("/{id}")
    public JSONResult delSalelistdetails(@PathVariable Integer id){
        System.out.println("执行删除");
        return  JSONResult.ok(id);
    }
}
