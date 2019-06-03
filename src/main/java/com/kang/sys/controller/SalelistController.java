package com.kang.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Salelist;
import com.kang.sys.model.SaleListWithDetails;
import com.kang.sys.service.ISalelistService;
import com.kang.sys.service.ISalesclerkService;
import com.kang.utils.json.JSONResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/salelist")
@Api("用户基础类")
public class SalelistController {

    @Autowired
    ISalelistService salelistService;

    @PostMapping("/")
    public JSONResult addSalelist(@RequestBody SaleListWithDetails salelist){
        try {
            salelistService.addSaleList(salelist);
            return JSONResult.ok("保存成功");
        }catch (Exception e){
            return JSONResult.errorMsg("保存报错："+e.getMessage());
        }
    }

    @GetMapping("/{page}/{size}/{uid}/{times}")
    public JSONResult getBuyListWithPage(@PathVariable Integer page,@PathVariable Integer size,@PathVariable Integer uid,@PathVariable String times) {
        Page<Salelist> pages = new Page<>(page, size);
        try{
            IPage<Salelist> iPage= salelistService.getBaseMapper().selectPage(pages,new QueryWrapper<Salelist>().eq("uid",uid).like("insert_time",times));
            if(iPage!=null&&iPage.getSize()>0){
                return JSONResult.ok(iPage);
            }else {
                return JSONResult.errorNofind("查询无结果");
            }
        }catch (Exception e){
            return JSONResult.errorException("查询报错："+e.getMessage());
        }
    }

}
