package com.kang.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Shops;
import com.kang.sys.service.IShopsService;
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
@RequestMapping("/shops")
@Api("商铺API")
public class ShopsController {

    @Autowired
    IShopsService shopsService;

    @PostMapping("/")
    public JSONResult addShops(Shops shops){
       try{
           shopsService.addShop(shops);
           return JSONResult.ok("添加成功");
       }catch (Exception e){
           return JSONResult.errorMsg("保存失败："+e.getMessage());
       }
    }

    /**
     * 根据用户查询商铺信息
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/{page}/{size}")
    public JSONResult getShopsWithPage(@PathVariable Integer page, @PathVariable Integer size ){
        Integer uid=1;
        Page<Shops> pages = new Page<>(page, size);

        try {
            IPage<Shops> shopsIPage = shopsService.selectPage(pages,uid);
            System.out.println("执行查询"+page+":"+size);
            if(shopsIPage.getSize()!=0){

                return JSONResult.ok(shopsIPage);
            }else {
                return JSONResult.errorNofind("无商铺信息,请添加");
            }
        }catch (Exception e){
            return JSONResult.errorMsg("查询报错："+e.getMessage());
        }


    }

    /**
     * 根据商铺名/地址模糊查询
     * @param names
     * @return
     */
    @GetMapping("/{names}")
    public JSONResult getShopsWithLikeName(@PathVariable String names ){
        Integer uid=1;
        try {
            List<Shops> shops=shopsService.getBaseMapper().selectList(new QueryWrapper<Shops>().eq("uid",uid).like("shops_name",names)
                .or().eq("uid",uid).like("shops_address",names));
            if(shops.size()!=0){
                return JSONResult.ok(shops);
            }else {
                return JSONResult.errorNofind("查询无商铺，请重新查询");
            }
        }catch (Exception e){
            return JSONResult.errorMsg("查询报错："+e.getMessage());
        }
    }

    @PutMapping("/")
    public JSONResult updateShops(Shops shops){
        try{
            shopsService.updateShop(shops);
            return JSONResult.ok("修改成功");
        }catch (Exception e){
            return  JSONResult.errorMsg("修改失败："+e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public JSONResult delShops(@PathVariable Integer id){
        try {
            shopsService.delShop(id);
            return JSONResult.ok("删除成功"+id);
        }catch (Exception e){
            return  JSONResult.errorMsg("删除失败"+e.getMessage());
        }
    }

    @GetMapping("/state/{shopsStatus}")
    public JSONResult getShopsWithStatus(@PathVariable Integer shopsStatus){
        int suspends=1,deletes=2;
        int uid=1;
        try{
            if (suspends==shopsStatus){
                List<Shops> shopsList=shopsService.getBaseMapper().selectList(new QueryWrapper<Shops>()
                .eq("shops_status",1).eq("uid",uid));
                if (shopsList!=null&&!shopsList.isEmpty()){
                    return JSONResult.ok(shopsList);
                }else {
                    return JSONResult.errorNofind("未查询到商铺信息");
                }
            }else if (deletes==shopsStatus){
                List<Shops> shopsList=shopsService.getBaseMapper().selectList(new QueryWrapper<Shops>()
                        .eq("shops_status",2).eq("uid",uid));
                if (shopsList!=null&&!shopsList.isEmpty()){
                    return JSONResult.ok(shopsList);
                }else {
                    return JSONResult.errorNofind("未查询到商铺信息");
                }
            }
        }catch (Exception e){
            return JSONResult.errorException(e.getMessage());
        }
        return JSONResult.errorTokenMsg("查询参数有误，请重新输入");
    }

    /**
     * 修改店铺状态
     * shopsStatus为1将商铺上线 2为下线
     */
    @PutMapping("/state/{shopsStatus}/{shopsId}")
    public JSONResult updShopsStatus(@PathVariable Integer shopsStatus,@PathVariable Integer shopsId){
        int suspends=1,deletes=2;
        int uid=1;
        try{
            if (suspends==shopsStatus){
                boolean update = shopsService.update(new UpdateWrapper<Shops>().set("shops_status", 0).eq("shops_id", shopsId));
                if (update){
                    return JSONResult.ok("上线店铺成功");
                }else {
                    return JSONResult.errorMsg("上线店铺失败");
                }
            }else if (deletes==shopsStatus){
                boolean update =shopsService.update(new UpdateWrapper<Shops>().set("shops_status",1).eq("shops_id",shopsId));
                if (update){
                    return JSONResult.ok("暂停店铺成功");
                }else {
                    return JSONResult.errorMsg("暂停店铺失败");
                }
            }
        }catch (Exception e){
            return JSONResult.errorException(e.getMessage());
        }
        return JSONResult.errorTokenMsg("参数有误，请重新查询");
    }
}
