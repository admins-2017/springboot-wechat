package com.kang.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.kang.sys.entity.Goods;
import com.kang.sys.service.IGoodsService;
import com.kang.sys.vo.GoodsWithDepot;
import com.kang.sys.vo.GoodsWithStock;
import com.kang.utils.json.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/goods")
@Api
public class GoodsController {
    @Autowired
    IGoodsService goodsService;

    @ApiOperation(value = "新增商品",notes = "根据Goods对象创建用户")
    @PostMapping("/")
    public JSONResult addGoods(Goods goods){
        System.out.println("执行添加");
        try {
            goodsService.addGoods(goods);
            return JSONResult.ok("保存成功");
        }catch (Exception e){
            return JSONResult.errorException("保存失败：原因"+e.getMessage());
        }
    }


    @ApiOperation(value = "商品模糊查询",notes = "根据前端返回商品名/供货商名/商品编号进行查询")
    @GetMapping("/like/{name}")
    public JSONResult getGoodsWithName(@PathVariable("name") String name){
        String likename="%"+name+"%";
        try{
            List<GoodsWithStock> goodsWithStockList=goodsService.getGoodsWithName(likename);
            if(goodsWithStockList.size()==0){
                return JSONResult.errorNofind("无商品信息");
            }else{
                return JSONResult.ok(goodsWithStockList);
            }
        }catch (Exception e){
            return JSONResult.errorException("查询出错："+e.getMessage());
        }
    }

    @GetMapping("/{goodsNumbers}")
    public JSONResult getGoodsWithNumber(@PathVariable("goodsNumbers") String goodsNumbers){
        try {
            Integer uid=1;
            List<GoodsWithDepot> list= goodsService.getGoodsWithDepot(uid,goodsNumbers);
            if(list!=null && list.size()!=0){
                return JSONResult.ok(list);
            }else{
                return JSONResult.errorNofind("当前商品不存在");
            }

        }catch (Exception e){
            return JSONResult.errorException(e.getMessage());
        }

    }


    @ApiOperation(value = "商品分页查询",notes = "根据传回分页信息进行查询所有上架产品")
    @GetMapping("/")
    public JSONResult getGoodsWithPage(){
        Integer uid=1;
        try{
            List<GoodsWithStock> goodsWithStockList= goodsService.getGoodsAll(uid);
            if (goodsWithStockList.size()!=0) {
                return JSONResult.ok(goodsWithStockList);
            }else {
                return JSONResult.errorNofind("无商品信息");
            }
        }catch (Exception e){
            return JSONResult.errorException("查询出错:"+e.getMessage());
        }
    }


    /**
     * 更新商品信息 根据id进行更新 ，包括更新内容及上下架信息
     * 根据传递值进行判断更新
     */

    @ApiOperation(value = "更新商品",notes = "根据传递商品对象属性进行更新")
    @PutMapping("/")
    public JSONResult updateGoods(Goods goods){
        try{
            goodsService.updateGoods(goods);
            return JSONResult.ok("更新成功");
        }catch (Exception e){
            return JSONResult.errorException("更新失败:"+e.getMessage());
        }
    }

    /**
     * 删除商品根据id进行删除
     */

    @ApiOperation(value = "删除商品",notes = "根据Goods的id删除商品")
    @DeleteMapping("/{id}")
    public JSONResult delGoods(@PathVariable Integer id){
        try{
            Goods goods =new Goods().setGoodsStatus(1);
            goodsService.update(goods,new UpdateWrapper<Goods>().eq("goods_id",id));
            return  JSONResult.ok("删除成功");
        }catch (Exception e){
            return  JSONResult.errorMsg("删除失败:"+e.getMessage());
        }
    }

    /**
     * 更新商品上下架

     */
    @PutMapping("/status/{status}/{goodsId}")
    public JSONResult updateGoodsStatus(@PathVariable("status") Integer status,@PathVariable("goodsId")Integer goodsId){
       try{
           goodsService.updateGoodsWithStatus(status,goodsId);
           if (0==status){
               return JSONResult.ok("上架成功");
           }else {
               return JSONResult.ok("下架成功");
           }
       }catch (Exception e){
           return JSONResult.errorException(e.getMessage());
       }
    }

    /**
     * 查询所有下架商品
     */
    @GetMapping("/undercarriage")
    public JSONResult getUndercarriageGoods(){
       try{
           Integer uid=1;
           List<Goods> list=goodsService.getBaseMapper().selectList(new QueryWrapper<Goods>().eq("uid",uid).eq("goods_status",1));
           if (null==list&&0==list.size()){
               return JSONResult.errorNofind("无下架商品信息");
           }else {
               return JSONResult.ok(list);
           }
       }catch (Exception e){
            return JSONResult.errorException("查询报错："+e.getMessage());
       }
   }

   @GetMapping("/number/{goodsNumber}")
   public JSONResult getGoodsWithGoodsNumber(@PathVariable("goodsNumber") String goodsNumber){
       try {
           GoodsWithStock goodsWithStock=goodsService.getGoodsAndStockWithGoodsNumber(1,goodsNumber);
           if (null!=goodsWithStock&&!"".equals(goodsWithStock.toString())){
               return JSONResult.ok(goodsWithStock);
           }else {
               return JSONResult.errorNofind("无商品信息，请添加");
           }
       }catch (Exception e){
           return JSONResult.errorException("查询错误："+e.getMessage());
       }
   }
}
