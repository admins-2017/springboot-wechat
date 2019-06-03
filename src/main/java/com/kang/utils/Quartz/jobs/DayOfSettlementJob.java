package com.kang.utils.Quartz.jobs;

import com.kang.sys.entity.Buylist;
import com.kang.sys.entity.DayOfSettlement;
import com.kang.sys.entity.Salelist;
import com.kang.sys.mapper.BuylistMapper;
import com.kang.sys.mapper.DayOfSettlementMapper;
import com.kang.sys.mapper.SalelistMapper;
import com.kang.sys.service.IBuylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Demo class
 *
 * @author 康东伟
 * @date 2019/05/14
 */
@Component("dayOfSettlementJob")
@Transactional
public class DayOfSettlementJob {

    @Resource
    BuylistMapper buylistMapper;
    @Resource
    SalelistMapper salelistMapper;
    @Resource
    DayOfSettlementMapper dayOfSettlementMapper;

    Double daysettlementBuyprice=0.0;
    Double buylistPaid=0.0d;
    Double buylistUnpaid=0.0d;
    Double daysettlementSaleprice=0.0d;
    Double salelistPaid=0.0d;
    Double salelistUnpaid=0.0d;
    Integer daysettlementBuynumber=0;
    Integer daysettlementBuyretreatnumber=0;
    Integer daysettlementSalenumber=0;
    Integer daysettlementSaleretreatnumber=0;
    Double receivablesCash=0.0d;
    Double receivablesTransferaccounts=0.0d;
    Double receivablesWechat=0.0d;
    Double receivablesAllpay=0.0d;
    Double paymentCash=0.0d;
    Double paymentTransferaccounts=0.0d;
    Double paymentWechat=0.0d;
    Double paymentAllpay=0.0d;

    public void execute() {
        /*
        uid需要查询 这里先写死
         */
        Integer uid=1;
        DayOfSettlement day=new DayOfSettlement();
        System.out.println("-------------------日结任务开始-------------------");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String times=df.format(new Date());
        String insertTime="%"+times+"%";
        System.out.println("执行日期为："+insertTime);
        List<Buylist> buyLists=buylistMapper.getListForDailyKnots(1,insertTime);
        if(buyLists.size()==0){
            day.setDaysettlementBuynumber(0);
            day.setDaysettlementBuyretreatnumber(0);
            day.setPaymentCash(0.0);
            day.setPaymentTransferaccounts(0.0);
            day.setPaymentWechat(0.0);
            day.setPaymentAllpay(0.0);
            day.setDaysettlementBuyprice(0.0);
            day.setBuylistPaid(0.0);
            day.setBuylistUnpaid(0.0);
        }else {
            for (int i = 0; i < buyLists.size(); i++) {
                if(buyLists.get(i).getBuylistStockorback()==1){
                    daysettlementBuynumber+=1;
                }
                if(buyLists.get(i).getBuylistStockorback()==2){
                    daysettlementBuyretreatnumber+=1;
                }
                if(buyLists.get(i).getBuylistPaymentmethod()==1){
                    paymentCash+= buyLists.get(i).getBuylistPaid();
                }
                if(buyLists.get(i).getBuylistPaymentmethod()==2){
                    paymentTransferaccounts+=buyLists.get(i).getBuylistPaid();
                }
                if(buyLists.get(i).getBuylistPaymentmethod()==3){
                    paymentWechat+=buyLists.get(i).getBuylistPaid();
                }
                if(buyLists.get(i).getBuylistPaymentmethod()==4){
                    paymentAllpay+=buyLists.get(i).getBuylistPaid();
                }
                daysettlementBuyprice += buyLists.get(i).getBuylistAllprice();
                buylistPaid += buyLists.get(i).getBuylistPaid();
                buylistUnpaid += buyLists.get(i).getBuylistUnpaid();
            }
            day.setDaysettlementBuynumber(daysettlementBuynumber);
            day.setDaysettlementBuyretreatnumber(daysettlementBuyretreatnumber);
            day.setPaymentCash(paymentCash);
            day.setPaymentTransferaccounts(paymentTransferaccounts);
            day.setPaymentWechat(paymentWechat);
            day.setPaymentAllpay(paymentAllpay);
            day.setDaysettlementBuyprice(daysettlementBuyprice);
            day.setBuylistPaid(buylistPaid);
            day.setBuylistUnpaid(buylistUnpaid);
        }
        List<Salelist> salelists=salelistMapper.getSaleListFroDailyKnots(1,insertTime);
        if(salelists.size()==0){
            day.setDaysettlementSalenumber(0);
            day.setDaysettlementSaleretreatnumber(0);
            day.setReceivablesCash(0.0);
            day.setReceivablesTransferaccounts(0.0);
            day.setReceivablesWechat(0.0);
            day.setReceivablesAllpay(0.0);
            day.setDaysettlementSaleprice(0.0);
            day.setSalelistPaid(0.0);
            day.setSalelistUnpaid(0.0);
        }else {
            for (int i = 0; i < salelists.size(); i++) {
                if (salelists.get(i).getSalelistStockorback()==1){
                    daysettlementSalenumber+=1;
                }
                if (salelists.get(i).getSalelistStockorback()==2){
                    daysettlementSaleretreatnumber+=1;
                }
                if(salelists.get(i).getSalelistReceivablesmethod()==1){
                    receivablesCash+=salelists.get(i).getSalelistPaid();
                }
                if(salelists.get(i).getSalelistReceivablesmethod()==2){
                    receivablesTransferaccounts+=salelists.get(i).getSalelistPaid();
                }
                if(salelists.get(i).getSalelistReceivablesmethod()==3){
                    receivablesWechat+=salelists.get(i).getSalelistPaid();
                }if(salelists.get(i).getSalelistReceivablesmethod()==4){
                    receivablesAllpay+=salelists.get(i).getSalelistPaid();
                }
                daysettlementSaleprice+=salelists.get(i).getSalelistAllprice();
                salelistPaid+=salelists.get(i).getSalelistPaid();
                salelistUnpaid+=salelists.get(i).getSalelistUnpaid();
            }
            day.setDaysettlementSalenumber(daysettlementSalenumber);
            day.setDaysettlementSaleretreatnumber(daysettlementSaleretreatnumber);
            day.setReceivablesCash(receivablesCash);
            day.setReceivablesTransferaccounts(receivablesTransferaccounts);
            day.setReceivablesWechat(receivablesWechat);
            day.setReceivablesAllpay(receivablesAllpay);
            day.setDaysettlementSaleprice(daysettlementSaleprice);
            day.setSalelistPaid(salelistPaid);
            day.setSalelistUnpaid(salelistUnpaid);
        }
        Instant instant = new Date().toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        day.setDaysettlementTime(localDateTime);
        day.setUid(uid);
        dayOfSettlementMapper.insert(day);
        System.out.println("保存完成");
        System.out.println("定时任务结束");
    }
}
