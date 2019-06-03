package com.kang.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kang.sys.entity.GoodsType;
import com.kang.sys.service.IGoodsTypeService;
import com.kang.utils.json.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-05-23
 */
@RestController
@RequestMapping("/goodsType")
public class GoodsTypeController {

    @Autowired
    IGoodsTypeService goodsTypeService;

    @GetMapping("/")
    public JSONResult getType(){
        try {
        List<GoodsType> goodsTypeList=goodsTypeService.getBaseMapper().selectList(new QueryWrapper<GoodsType>()
        .orderByDesc("goods_type_id"));
        if(goodsTypeList.size()!=0) {
            return JSONResult.ok(goodsTypeList);
        }else {
            return JSONResult.errorNofind("查询无商品分类");
        }
        }catch (Exception e){
           return JSONResult.errorMsg("查询出错:"+e.getMessage());
        }
    }
}
