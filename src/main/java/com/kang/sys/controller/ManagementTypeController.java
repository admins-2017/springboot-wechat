package com.kang.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kang.sys.entity.ManagementType;
import com.kang.sys.service.IManagementTypeService;
import com.kang.utils.json.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-05-06
 */
@RestController
@RequestMapping("/managementType")
public class ManagementTypeController {

    @Autowired
    IManagementTypeService managementTypeService;

    @PostMapping("/")
    public JSONResult addType(ManagementType managementType){
        try{
            managementTypeService.save(managementType);
            return JSONResult.ok("保存成功");
        }catch (Exception e){
            return JSONResult.errorMsg("保存失败："+e.getMessage());
        }

    }

    @GetMapping("/")
    public JSONResult getType(){
        try{
            List<ManagementType> managementTypes=managementTypeService.getBaseMapper().selectList(new QueryWrapper<ManagementType>());
            return JSONResult.ok(managementTypes);
        }catch (Exception e){
            return JSONResult.errorMsg("查询失败："+e.getMessage());
        }

    }
}
