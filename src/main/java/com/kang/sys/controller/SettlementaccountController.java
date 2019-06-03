package com.kang.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Settlementaccount;
import com.kang.sys.model.SettlementaccountModel;
import com.kang.sys.service.ISettlementaccountService;
import com.kang.utils.json.JSONResult;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/settlementaccount")
@Api("用户账户")
public class SettlementaccountController {

    @Autowired
    ISettlementaccountService settlementaccountService;

    @PostMapping("/")
    public JSONResult addSettlementaccount(SettlementaccountModel settlementaccount){
        Settlementaccount settlementaccount1=new Settlementaccount();
        BeanUtils.copyProperties(settlementaccount,settlementaccount1);
        try{
            settlementaccountService.save(settlementaccount1);
            return JSONResult.ok("保存成功");
        }catch (Exception e){
            return JSONResult.errorMsg("新增账户出错："+e.getMessage());
        }
    }

    @GetMapping("/{page}/{size}/{name}")
    public JSONResult getSettlementaccountWithPage(@PathVariable Integer page, @PathVariable Integer size,@PathVariable String name){
        Page<Settlementaccount> pages = new Page<>(page, size);
        String datas="%"+name+"%";
        try {
            IPage<Settlementaccount> iPage = settlementaccountService.selectPage(pages, datas);
            if (iPage!=null&&iPage.getSize()!=0){
                return JSONResult.ok(iPage);
            }else{
                return JSONResult.ok("查询无结果！请更换查询条件");
            }
        }catch (Exception e){
            return JSONResult.errorMsg("查询出错："+e.getMessage());
        }
    }

    @GetMapping("{page}/{size}/{id}/{status}")
    public JSONResult getSettlementaccountWithStatus(@PathVariable Integer page, @PathVariable Integer size,@PathVariable Integer id,@PathVariable Integer status){
        try{
            Page<Settlementaccount> pages = new Page<>(page, size);
            IPage<Settlementaccount> iPage = settlementaccountService.selectSettlementaccountWithStatus(pages,status,id);
            if (iPage!=null&&iPage.getSize()!=0){
                return JSONResult.ok(iPage);
            }else{
                return JSONResult.ok("查询无结果！请更换查询条件");
            }
        }catch (Exception e){
            return JSONResult.errorMsg("查询出错："+e.getMessage());
        }
    }

    @PutMapping("/")
    public JSONResult updateSettlementaccount(SettlementaccountModel settlementaccountModel){
        Settlementaccount settlementaccount=new Settlementaccount();
        BeanUtils.copyProperties(settlementaccountModel,settlementaccount);
        System.out.println("sssss"+settlementaccount);
        try{
            settlementaccountService.updateById(settlementaccount);
            return JSONResult.ok("修改成功");
        }catch (Exception e){
            return JSONResult.errorMsg("修改失败："+e.getMessage());
        }
    }

    @PutMapping("/{id}/{status}")
    public JSONResult updateSettlementaccountWithStatusById(@PathVariable Integer id, @PathVariable Integer status){
        try{
            settlementaccountService.updateStatus(status, id);
            return JSONResult.ok("停用成功");
        }catch (Exception e){
            return JSONResult.errorMsg("停用失败："+e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public JSONResult delSettlementaccount(@PathVariable Integer id){
        try{
            settlementaccountService.delSettlementaccount(id);
            return JSONResult.ok("删除成功");
        }catch (Exception e){
            return  JSONResult.ok("删除失败："+e.getMessage());
        }
    }
}
