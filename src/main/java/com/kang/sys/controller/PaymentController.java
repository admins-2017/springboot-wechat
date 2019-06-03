package com.kang.sys.controller;


import com.kang.sys.entity.Payment;
import com.kang.sys.service.IPaymentService;
import com.kang.sys.vo.PaymentWithSupplierVo;
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
@RequestMapping("/payment")
@Api("用户基础类")
public class PaymentController {

    @Autowired
    IPaymentService paymentService;

    @PostMapping("/")
    public JSONResult addPayment(Payment payment){
        try{
            paymentService.addPayment(payment);
            return JSONResult.ok("新增成功");
        }catch (Exception e){
            return JSONResult.errorMsg("新增报错："+e.getMessage());
        }
    }

    @GetMapping("/{status}/{uid}")
    public JSONResult getPaymentWithPage(@PathVariable Integer status, @PathVariable Integer uid){
        try{
            List<PaymentWithSupplierVo> list= paymentService.queryHistoryPayment(status,uid);
            if(list.size()==0){
                return JSONResult.ok("查询无结果");
            }else{
                return JSONResult.ok(list);
            }
        }catch (Exception e){
            return JSONResult.errorMsg("查询错误："+e.getMessage());
        }
    }

    @GetMapping("/{name}")
    public JSONResult getPaymentWithLike(@PathVariable String name){
        //id通过session获取
        Integer id=1;
        //模糊查询需要加匹配符
        String likename="%"+name+"%";
        try{
            List<PaymentWithSupplierVo> list=paymentService.findPayment(id,likename);
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
//    public JSONResult updatePayment(Payment payment){
//        System.out.println("执行修改");
//        return JSONResult.ok();
//    }

    @DeleteMapping("/{id}")
    public JSONResult delPayment(@PathVariable Integer id){
        try{
            String result=paymentService.delPayment(id);
            return JSONResult.ok(result);
        }catch (Exception e){
            return JSONResult.errorMsg("作废错误："+e.getMessage());
        }
    }
}
