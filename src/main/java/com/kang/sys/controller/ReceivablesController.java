package com.kang.sys.controller;


import com.kang.sys.entity.Receivables;
import com.kang.sys.service.IReceivablesService;
import com.kang.sys.service.IRoleService;
import com.kang.sys.vo.ReceivablesWithCustomerVo;
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
@RequestMapping("/receivables")
@Api("用户基础类")
public class ReceivablesController {

    @Autowired
    IReceivablesService receivablesService;

    @PostMapping("/")
    public JSONResult addReceivables(Receivables receivables){
        try{
            String result=receivablesService.addReceivables(receivables);
            return JSONResult.ok(result);
        }catch (Exception e){
            return JSONResult.errorMsg("新增报错："+e.getMessage());
        }
    }

    @GetMapping("/{page}/{size}/{status}/{uid}")
    public JSONResult getReceivablesWithStatus(@PathVariable Integer page, @PathVariable Integer size,@PathVariable Integer status,@PathVariable Integer uid){
        try{
            List<ReceivablesWithCustomerVo> receivablesWithCustomerVoList=receivablesService.queryHistoryReceivables(status,uid);
            if(receivablesWithCustomerVoList.size()==0){
                return JSONResult.ok("查询无结果");
            }else{
                return JSONResult.ok(receivablesWithCustomerVoList);
            }
        }catch (Exception e){
            return JSONResult.errorMsg("查询错误："+e.getMessage());
        }
     }

    @GetMapping("/{page}/{size}/{name}")
    public JSONResult getReceivablesWithLike(@PathVariable Integer page, @PathVariable Integer size,@PathVariable String name){
        Integer uid=1;
        String datas="%"+name+"%";
        try{
            List<ReceivablesWithCustomerVo> list=receivablesService.findReceivables(uid,datas);
            if(list.size()==0){
                return JSONResult.ok("查询无结果");
            }else{
                return JSONResult.ok(list);
            }
        }catch (Exception e){
            return JSONResult.errorMsg("查询错误："+e.getMessage());
        }
    }

//    @PutMapping("/")
//    public JSONResult updateReceivables(Receivables receivables){
//        System.out.println("执行修改");
//        return JSONResult.ok();
//    }

    @DeleteMapping("/{id}")
    public JSONResult delReceivables(@PathVariable Integer id){
        try{
            String result=receivablesService.delReceivables(id);
            return JSONResult.ok(result);
        }catch (Exception e){
            return JSONResult.errorMsg("作废错误："+e.getMessage());
        }
    }
}
