package com.kang.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Depot;
import com.kang.sys.service.IDepotService;
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
@RequestMapping("/depot")
@Api("仓库")
public class DepotController {

    @Autowired
    private IDepotService depotService;

    @PostMapping("/")
    public JSONResult addDepot(Depot depot){
        try{
            int a=depotService.addDepot(depot);
            return JSONResult.ok("保存成功");
        }catch (Exception e){
            return JSONResult.errorMsg("保存失败:"+e.getMessage());
        }
    }

    @GetMapping("/{page}/{size}/{shops}")
    public JSONResult getDepotWithPage(@PathVariable Integer page, @PathVariable Integer size,@PathVariable Integer shops){
        Page<Depot> pages = new Page<>(page, size);
        try{
            IPage<Depot> userIPage = depotService.selectPage(pages,shops);
            if(userIPage.getSize()!=0){
                return JSONResult.ok(userIPage);
            }else {
                return JSONResult.ok("当前商铺下查询无仓库");
            }
        }catch (Exception e){
            return JSONResult.errorMsg("查询出错:"+e.getMessage());
        }
    }

    @GetMapping("/{shops}/{names}")
    public JSONResult getDepotWithPage(@PathVariable String names,@PathVariable Integer shops){
        try{
            List<Depot> depots = depotService.getBaseMapper().selectList(new QueryWrapper<Depot>().eq("depot_status",0).eq("shops_id",shops)
                        .like("depot_name",names));
            if(depots.size()!=0){
                return JSONResult.ok(depots);
            }else {
                return JSONResult.errorNofind("当前商铺下查询无仓库");
            }
        }catch (Exception e){
            return JSONResult.errorMsg("查询出错:"+e.getMessage());
        }
    }

    @PutMapping("/")
    public JSONResult updateDepot(Depot depot){
        try{
            depotService.updateDepot(depot);
            return JSONResult.ok("修改成功");
        }catch (Exception e){
            return JSONResult.errorMsg("修改失败:"+e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public JSONResult delDepot(@PathVariable Integer id){
        try{
            depotService.delDepot(id);
            return  JSONResult.ok("删除成功");
        }catch (Exception e){
            return  JSONResult.ok("删除失败"+e.getMessage());
        }
    }

    @GetMapping("/historical/{shops}")
    public JSONResult getHistoricalDepot(@PathVariable Integer shops){
        try {
            List<Depot> depotList=depotService.getBaseMapper().selectList(new QueryWrapper<Depot>().eq("depot_status",1).eq("shops_id",shops));
            if (depotList!=null&&!depotList.isEmpty()){
                return JSONResult.ok(depotList);
            }else {
                return JSONResult.errorNofind("当前商铺没有删除仓库记录");
            }
        }catch (Exception e){
            return JSONResult.errorException(e.getMessage());
        }
    }
}
