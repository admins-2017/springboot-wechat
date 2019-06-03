package com.kang.sys.service.impl;

import com.kang.sys.entity.Buylist;
import com.kang.sys.entity.Buylistdetails;
import com.kang.sys.entity.Stock;
import com.kang.sys.entity.User;
import com.kang.sys.mapper.*;
import com.kang.sys.model.BuyListWithDetails;
import com.kang.sys.service.IBuylistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
@Service
public class BuylistServiceImpl extends ServiceImpl<BuylistMapper, Buylist> implements IBuylistService {
    @Resource
    BuylistMapper buylistMapper;
    @Resource
    BuylistdetailsMapper buylistdetailsMapper;
    @Resource
    SupplierMapper supplierMapper;
    @Resource
    StockMapper stockMapper;
    @Resource
    UserInfoMapper userInfoMapper;
    @Resource
    ListnumberMapper listnumberMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void addBuyListAll(BuyListWithDetails buyListWithDetails) {
        Buylist buylist=new Buylist();
        Buylistdetails buylistdetails=new Buylistdetails();
        BeanUtils.copyProperties(buyListWithDetails,buylist);
        int uid=getPowerWithUid(buyListWithDetails.getInsertUser());
        buylist.setUid(uid);
        if(buylist!=null&&buylist.getBuylistStockorback()==1){
            buylistMapper.addBuyList(buylist);
            int buylistId=buylist.getBuylistId();
            for (int i=0;i<buyListWithDetails.getBuylistdetails().size();i++){
                if(buyListWithDetails.getBuylistdetails().get(i).getBuylistSettle()==2){
                    supplierMapper.increaseSupplierArrears(buyListWithDetails.getBuylistdetails().get(i).getSupplierId(),buyListWithDetails.getBuylistdetails().get(i).getBuylistUnpaid());
                }
                Stock stock;
                if (stockMapper.findStockNullOrNotNull(buyListWithDetails.getBuylistdetails().get(i).getGoodsId(),buyListWithDetails.getBuylistdetails().get(i).getDepotId(),uid)!=null){
                    stock=stockMapper.findStockNullOrNotNull(buyListWithDetails.getBuylistdetails().get(i).getGoodsId(),buyListWithDetails.getBuylistdetails().get(i).getDepotId(),uid);
                    stockMapper.increaseStock(stock.getStockId(),buyListWithDetails.getBuylistdetails().get(i).getNumber(),buyListWithDetails.getInsertUser());
                }else{
                    System.out.println("为空");
                    stock=new Stock();
                    stock.setGoodsId(buyListWithDetails.getBuylistdetails().get(i).getGoodsId());
                    stock.setDepotId(buyListWithDetails.getBuylistdetails().get(i).getDepotId());
                    stock.setStockNumber(buyListWithDetails.getBuylistdetails().get(i).getNumber());
                    stock.setLastaddUser(buyListWithDetails.getInsertUser());
                    stock.setUid(uid);
                    stockMapper.addStock(stock);
                }
                BeanUtils.copyProperties(buyListWithDetails.getBuylistdetails().get(i),buylistdetails);
                buylistdetails.setBuylistId(buylistId);
                buylistdetailsMapper.addBuylistdetails(buylistdetails);
            }
        }else if ((buylist!=null&&buylist.getBuylistStockorback()==2)){
            buylistMapper.addBuyList(buylist);
            int buylistId=buylist.getBuylistId();
            for (int i=0;i<buyListWithDetails.getBuylistdetails().size();i++){
                if(buyListWithDetails.getBuylistdetails().get(i).getBuylistSettle()==2){
                    supplierMapper.subtractSupplierArrears(buyListWithDetails.getBuylistdetails().get(i).getSupplierId(),buyListWithDetails.getBuylistdetails().get(i).getBuylistUnpaid());
                }
                Stock stock=stockMapper.findStockNullOrNotNull(buyListWithDetails.getBuylistdetails().get(i).getGoodsId(),buyListWithDetails.getBuylistdetails().get(i).getDepotId(),uid);
                    stockMapper.reduceStock(stock.getStockId(),buyListWithDetails.getBuylistdetails().get(i).getNumber(),buyListWithDetails.getInsertUser());
                BeanUtils.copyProperties(buyListWithDetails.getBuylistdetails().get(i),buylistdetails);
                buylistdetails.setBuylistId(buylistId);
                buylistdetailsMapper.addBuylistdetails(buylistdetails);
            }
        }
    }


    public Integer getPowerWithUid(Integer uid){
        User userInfo=userInfoMapper.findPowerWithUid(uid);
        if("manager".equals(userInfo.getUserPower())){
            return userInfo.getUid();
        }else {
            return Integer.parseInt(userInfo.getUserPower());
        }
    }
}
