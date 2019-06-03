package com.kang.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Salesclerk;
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
@RequestMapping("/salesclerk")
@Api("用户基础类")
public class SalesclerkController {
    @Autowired
    ISalesclerkService salesclerkService;

    @PostMapping("/")
    public JSONResult addSalesclerk(Salesclerk salesclerk){
     try {
         salesclerkService.addSalesclerk(salesclerk);
         return JSONResult.ok("保存成功");
     }catch (Exception e){
         return  JSONResult.ok("保存失败"+e.getMessage());
     }

    }

    @GetMapping("/{page}/{size}/{uid}")
    public JSONResult getSalesclerkWithPage(@PathVariable Integer page, @PathVariable Integer size,@PathVariable Integer uid){
        Page<Salesclerk> page1 = new Page<Salesclerk>(page,size);
        try{
          IPage<Salesclerk> salesclerkIPage= salesclerkService.selectPage(page1,uid);
          if(salesclerkIPage.getSize()!=0){
              return  JSONResult.ok(salesclerkIPage);
          }else {
              return  JSONResult.ok("无数据查出");
          }
        }catch (Exception e){
            return JSONResult.ok("查询报错："+e.getMessage());
        }

    }

    @PutMapping("/")
    public JSONResult updateSalesclerk(Salesclerk salesclerk){
      try {
          salesclerkService.updateSalesclerk(salesclerk);
          return  JSONResult.ok("修改成功");
      }catch (Exception e){
          return JSONResult.ok("修改失败"+e.getMessage());
      }
    }
    @DeleteMapping("/{id}")
    public JSONResult delSalesclerk(@PathVariable Integer id){
        try {
            salesclerkService.delSalesclerk(id);
            return  JSONResult.ok("删除成功");
        }catch (Exception e){
            return JSONResult.ok("删除失败"+e.getMessage());
        }
    }
}
