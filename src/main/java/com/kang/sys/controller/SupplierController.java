package com.kang.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Supplier;
import com.kang.sys.service.ISupplierService;
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
@RequestMapping("/supplier")
@Api("用户基础类")
public class SupplierController {
    @Autowired
    ISupplierService supplierService;

    @PostMapping("/")
    public JSONResult addSupplier(Supplier supplier){
        try{
            supplierService.addSupplier(supplier);
            return JSONResult.ok("保存成功");
        }catch (Exception e){
            return JSONResult.errorException("保存失败"+e.getMessage());
        }
    }
    @GetMapping("/{page}/{size}/{id}")
    public JSONResult getSupplierWithPage(@PathVariable Integer page, @PathVariable Integer size,@PathVariable Integer id){
        Page<Supplier> pages = new Page<>(page, size);
        try{
            IPage<Supplier> supplierIPage = supplierService.selectPage(pages,id);
            if (supplierIPage.getSize()!=0){
                return JSONResult.ok(supplierIPage);
            }else{
                return JSONResult.ok("当前账户下无供应商");
            }
        }catch (Exception e){
            return JSONResult.errorException("查询出错"+e.getMessage());
        }
    }

    @PutMapping("/")
    public JSONResult updateSupplier(Supplier supplier){
        try{
            supplierService.updateSupplier(supplier);
            return JSONResult.ok("修改成功");
        }catch (Exception e){
            return JSONResult.errorException("修改失败"+e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public JSONResult delSupplier(@PathVariable Integer id){
        try{
            supplierService.delSupplier(id);
            return JSONResult.ok("删除成功");
        }catch (Exception e){
            return JSONResult.errorException("删除失败"+e.getMessage());
        }
    }
}
