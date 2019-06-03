package com.kang.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Buylist;
import com.kang.sys.entity.Buylistdetails;
import com.kang.sys.model.BuyListWithDetails;
import com.kang.sys.service.IBuylistService;
import com.kang.sys.service.IBuylistdetailsService;
import com.kang.utils.json.JSONResult;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/buylist")
@Api("进货单api")
public class BuylistController {

    @Autowired
    IBuylistService buylistService;

    @PostMapping("/")
    public JSONResult addBuyList(@RequestBody BuyListWithDetails buyListWithDetails){
        try{
            buylistService.addBuyListAll(buyListWithDetails);
            return JSONResult.ok("保存成功");
        }catch (Exception e){
            return JSONResult.errorMsg("保存失败:"+e.getMessage());
        }
    }

    @GetMapping("/{page}/{size}/{uid}")
    public JSONResult getBuyListWithPage(@PathVariable Integer page,@PathVariable Integer size,@PathVariable Integer uid){
        Page<Buylist> pages = new Page<>(page, size);
        IPage<Buylist> buylistIPage= buylistService.getBaseMapper().selectPage(pages,new QueryWrapper<Buylist>().eq("uid",uid));
        return JSONResult.ok(buylistIPage);
    }

    @GetMapping("/")
    public JSONResult getBuyList(){
        return JSONResult.ok();
    }

}
