package com.kang.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Stock;
import com.kang.sys.service.IStockService;
import com.kang.sys.vo.StockWithDepotAndGoods;
import com.kang.utils.json.JSONResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.ElementType;
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
@RequestMapping("/stock")
@Api("用户基础类")
public class StockController {

    @Autowired
    IStockService stockService;

    @PostMapping("/")
    public JSONResult addStock(Stock stock){
        try{
            if(stock==null) {
                return JSONResult.errorTokenMsg("传值为空");
            }else {
                stockService.addStock(stock);
                return JSONResult.ok("保存成功");
            }
        } catch (Exception e){
            return JSONResult.errorMsg("保存出错："+e.getMessage());
        }
    }

    @GetMapping("/{page}/{size}/{uid}")
    public JSONResult getStockWithPage(@PathVariable Integer page, @PathVariable Integer size,@PathVariable Integer uid){
        Page<Stock> pages = new Page<>(page, size);
        try{
            IPage<Stock> stockIPage = stockService.selectPage(pages,uid);
            if (stockIPage.getSize()==0){
                return JSONResult.errorNofind("查询无结果，请添加");
            }else {
                return JSONResult.ok(stockIPage);
            }
        } catch (Exception e){
            return JSONResult.errorMsg("查询出错："+e.getMessage());
        }
    }

    @GetMapping("/{name}")
    public JSONResult getStockWithLike(@PathVariable String name){
//        Page<Stock> pages = new Page<>(page, size);
        String likename="%"+name+"%";
        Integer uid=1;
        try{
            List<StockWithDepotAndGoods> list= stockService.qureyStockWithGoodsNameOrDepotName(uid,likename);
            if (list.size()==0){
                return JSONResult.errorNofind("查询无结果，请添加");
            }else {
                return JSONResult.ok(list);
            }
        } catch (Exception e){
            return JSONResult.errorMsg("查询出错："+e.getMessage());
        }
    }

    @GetMapping("/")
    public JSONResult queryStock(Stock stock){
        try{
            StockWithDepotAndGoods stocks=stockService.queryStock(stock.getGoodsId(),stock.getUid(),stock.getDepotId());
            if (stocks==null){
                return JSONResult.ok("查询无结果");
            }else {
                return JSONResult.ok(stocks);
            }
        }catch (Exception e){
            return JSONResult.errorMsg("查询报错："+e.getMessage());
        }

    }

    @PutMapping("/reduce")
    public JSONResult updateStock(Stock stock){
        System.out.println(stock.toString());
        try{
            stockService.reduceStock(stock.getStockId(),stock.getStockNumber(),stock.getLasttakeoutUser());
            return JSONResult.ok("保存成功");
        } catch (Exception e){
            return JSONResult.ok("保存失败："+e.getMessage());
        }
    }

    @PutMapping("/increase")
    public JSONResult delStock(Stock stock){
        try{
            stockService.increaseStock(stock.getStockId(),stock.getStockNumber(),stock.getLastaddUser());
            return JSONResult.ok("保存成功");
        } catch (Exception e){
            return JSONResult.ok("保存失败："+e.getMessage());
        }
    }
}
