package com.kang.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kang.sys.entity.Buylist;
import com.kang.sys.entity.Buylistdetails;
import com.kang.sys.entity.DayOfSettlement;
import com.kang.sys.entity.Salelist;
import com.kang.sys.service.*;
import com.kang.sys.vo.BuyListDetailsWithGoodsAndDepotAndSupplier;
import com.kang.sys.vo.SaleListDetailsWithGoodsAndCustomerAndDepot;
import com.kang.utils.json.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-05-15
 */
@RestController
@RequestMapping("/day")
public class DayOfSettlementController {
    @Autowired
    IDayOfSettlementService dayOfSettlementService;
    @Autowired
    IBuylistService buyListService;
    @Autowired
    ISalelistService saleListService;
    @Autowired
    IBuylistdetailsService buyListDetailsService;
    @Autowired
    ISalelistdetailsService saleListDetailsService;


    @GetMapping("/all/{uid}/{dayTime}")
    public JSONResult getDayOfDayTime(@PathVariable(name = "uid") Integer uid,@PathVariable(name = "dayTime") String dayTime){
        try {
            List<DayOfSettlement> list=dayOfSettlementService.getBaseMapper().selectList(new QueryWrapper<DayOfSettlement>().eq("uid",uid)
                    .like("daysettlement_time",dayTime));
            if (list!=null && list.size()>0){
                return JSONResult.ok(list);
            }else {
                return JSONResult.errorNofind("当前无数据");
            }
        }catch (Exception e){
            return JSONResult.errorException("查询出错，错误原因:"+e.getMessage());
        }
    }
    @GetMapping("/day/{dayId}")
    public JSONResult getDayOfDayId(@PathVariable Integer dayId){
        try {
            DayOfSettlement day=dayOfSettlementService.getOne(new QueryWrapper<DayOfSettlement>().eq("daysettlement_id",dayId));
            if (day != null && !"".equals(day.toString())){
                return JSONResult.ok(day);
            }else{
                return JSONResult.errorNofind("查询无数据");
            }

        }catch (Exception e){
            return JSONResult.errorException("查询报错 报错原因："+e.getMessage());
        }
    }

    @GetMapping("/statistics/{dayType}")
    public JSONResult getData(@PathVariable Integer dayType){
        try {
            List<DayOfSettlement> dayList= new ArrayList<>();
            Integer daytime=1,month=2,year=3;
            if (daytime.equals(dayType)){
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                dayList= getDayOfSettlement(1, df.format(new Date()));
            }
            else if (month.equals(dayType)) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
                dayList = getDayOfSettlement(1,  df.format(new Date()));
            } else if (year.equals(dayType)){
                SimpleDateFormat df = new SimpleDateFormat("yyyy");
                dayList= getDayOfSettlement(1, df.format(new Date()));

            }
            if (dayList!=null && !dayList.isEmpty()){
                return JSONResult.ok(dayList);
            }else{
                return JSONResult.errorNofind("查询无数据");
            }

        }catch (Exception e){
            return JSONResult.errorException("查询报错 报错原因："+e.getMessage());
        }
    }

    @GetMapping("/statistics/dates/{dayTimes}")
    public JSONResult getDataWithMonth(@PathVariable String dayTimes){
        try {
            List<DayOfSettlement> day= getDayOfSettlement(1,dayTimes);
            if (day!=null && !day.isEmpty()){
                return JSONResult.ok(day);
            }else{
                return JSONResult.errorNofind("查询无数据");
            }

        }catch (Exception e){
            return JSONResult.errorException("查询报错 报错原因："+e.getMessage());
        }
    }

    private List<DayOfSettlement> getDayOfSettlement(Integer uid,String dayTimes){
        List<DayOfSettlement> day=dayOfSettlementService.getBaseMapper().selectList(new QueryWrapper<DayOfSettlement>()
                .select(" COUNT(daysettlement_id) as daysettlement_id,SUM(daysettlement_buynumber)as daysettlement_buynumber,SUM(daysettlement_buyretreatnumber)as daysettlement_buyretreatnumber" +
                        ",SUM(daysettlement_buyprice)as daysettlement_buyprice,SUM(buylist_paid)as buylist_paid ,SUM(buylist_unpaid)as buylist_unpaid " +
                        ",SUM(daysettlement_salenumber)as daysettlement_salenumber,SUM(daysettlement_saleretreatnumber)as daysettlement_saleretreatnumber" +
                        ",SUM(daysettlement_saleprice)as daysettlement_saleprice,SUM(salelist_paid)as salelist_paid,SUM(salelist_unpaid)as salelist_unpaid" +
                        ",SUM(receivables_cash)as receivables_cash,SUM(receivables_transferaccounts)as receivables_transferaccounts,SUM(receivables_wechat)as receivables_wechat,SUM(receivables_allpay)as receivables_allpay" +
                        ",SUM(payment_cash)as payment_cash,SUM(payment_transferaccounts)as payment_transferaccounts,SUM(payment_wechat)as payment_wechat,SUM(payment_allpay)as payment_allpay").eq("uid",1).likeRight("daysettlement_time",dayTimes));
        return day;
    }

    /**
     * 获取日期下进销数据
     */
    @GetMapping("/statistics/Details/{dayTimes}")
    public JSONResult getBuyWithSaleDetails(@PathVariable String dayTimes){
        List<Object> resutlList=new ArrayList<>();
        Integer uid=1;
        try {
            List<Buylist> buyLists=buyListService.getBaseMapper().selectList(new QueryWrapper<Buylist>().eq("uid",uid)
                    .likeRight("insert_time",dayTimes));
            List<Salelist> saleLists=saleListService.getBaseMapper().selectList(new QueryWrapper<Salelist>().eq("uid",uid)
                    .likeRight("insert_time",dayTimes));
            if (buyLists!=null && !buyLists.isEmpty()){
                resutlList.add(buyLists);
            }else {
                Buylist buyList=new Buylist();
                resutlList.add(buyList);
            }

            if (saleLists!=null && !saleLists.isEmpty()){
                resutlList.add(saleLists);
            }else {
                Salelist saleList=new Salelist();
                resutlList.add(saleList);
            }
            return JSONResult.ok(resutlList);
        }catch (Exception e){
            return JSONResult.errorException("查询数据报错："+e.getMessage());
        }
    }

    /**
     * 获取指定单据下的详细数据
     */
    @GetMapping("/statistics/numbers/detailed/{buyId}/{types}")
    public JSONResult getDetailsDetailedByNumber(@PathVariable Integer buyId,@PathVariable Integer types) {
        int buyNumber = 1, saleNumber = 2;
        try {
            if (buyNumber == types) {
                List<BuyListDetailsWithGoodsAndDepotAndSupplier> buyList = buyListDetailsService.getDetailsWithBuyId(buyId);
                if (buyList != null && !buyList.isEmpty()) {
                    return JSONResult.ok(buyList);
                } else {
                    return JSONResult.errorNofind("查询当前订单无数据");
                }
            } else if (saleNumber == types) {
                List<SaleListDetailsWithGoodsAndCustomerAndDepot> saleList = saleListDetailsService.getSaleById(buyId);
                if (saleList != null && !saleList.isEmpty()) {
                    return JSONResult.ok(saleList);
                } else {
                    return JSONResult.errorNofind("查询当前订单无数据");
                }
            }
        }catch (Exception e){
            return JSONResult.errorException(e.getMessage());
        }
        return JSONResult.errorNofind("查询无数据");
    }
}
