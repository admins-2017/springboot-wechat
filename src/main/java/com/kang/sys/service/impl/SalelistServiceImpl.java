package com.kang.sys.service.impl;

import com.kang.sys.entity.Salelist;
import com.kang.sys.entity.Salelistdetails;
import com.kang.sys.entity.Stock;
import com.kang.sys.entity.User;
import com.kang.sys.mapper.*;
import com.kang.sys.model.SaleListWithDetails;
import com.kang.sys.service.ISalelistService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
@Service
public class SalelistServiceImpl extends ServiceImpl<SalelistMapper, Salelist> implements ISalelistService {

    @Resource
    SalelistMapper salelistMapper;
    @Resource
    SalelistdetailsMapper salelistdetailsMapper;
    @Resource
    CustomerMapper customerMapper;
    @Resource
    StockMapper stockMapper;
    @Resource
    UserInfoMapper userInfoMapper;
    @Resource
    ListnumberMapper listnumberMapper;

    /**
     * 新增销售单
     * @param saleListWithDetails
     * @return
     */
    @Override
    public int addSaleList(SaleListWithDetails saleListWithDetails) {
        Salelist salelist=new Salelist();
        Salelistdetails salelistdetails=new Salelistdetails();
        BeanUtils.copyProperties(saleListWithDetails,salelist);
        int uid=getPowerWithUid(saleListWithDetails.getInsertUser());
        salelist.setUid(uid);
        if(salelist!=null&&salelist.getSalelistStockorback()==1){
            salelistMapper.addSaleList(salelist);
            Integer salelistId=salelist.getSalelistId();
            for (int i=0;i<saleListWithDetails.getSalelistdetails().size();i++){
                if (saleListWithDetails.getSalelistdetails().get(i).getSalelistSettle()==2){
                    customerMapper.increaseSupplierArrears(saleListWithDetails.getSalelistdetails().get(i).getCustomerId(),saleListWithDetails.getSalelistdetails().get(i).getSalelistUnpaid());
                }
                Stock stock;
                if (stockMapper.findStockNullOrNotNull(saleListWithDetails.getSalelistdetails().get(i).getGoodsId(),saleListWithDetails.getSalelistdetails().get(i).getDepotId(),uid)!=null) {
                    stock = stockMapper.findStockNullOrNotNull(saleListWithDetails.getSalelistdetails().get(i).getGoodsId(), saleListWithDetails.getSalelistdetails().get(i).getDepotId(), uid);
                    stockMapper.reduceStock(stock.getStockId(), saleListWithDetails.getSalelistdetails().get(i).getSaleNumber(), saleListWithDetails.getInsertUser());
                }
                BeanUtils.copyProperties(saleListWithDetails.getSalelistdetails().get(i),salelistdetails);
                salelistdetails.setSalelistId(salelistId);
                salelistdetailsMapper.insert(salelistdetails);
            }
        }else if (salelist!=null&&salelist.getSalelistStockorback()==2){
            salelistMapper.addSaleList(salelist);
            Integer salelistId=salelist.getSalelistId();
            for (int i=0;i<saleListWithDetails.getSalelistdetails().size();i++){
                if (saleListWithDetails.getSalelistdetails().get(i).getSalelistSettle()==2){
                    customerMapper.subtractSupplierArrears(saleListWithDetails.getSalelistdetails().get(i).getCustomerId(),saleListWithDetails.getSalelistdetails().get(i).getSalelistUnpaid());
                }
                Stock stock;
                if (stockMapper.findStockNullOrNotNull(saleListWithDetails.getSalelistdetails().get(i).getGoodsId(),saleListWithDetails.getSalelistdetails().get(i).getDepotId(),uid)!=null) {
                    stock = stockMapper.findStockNullOrNotNull(saleListWithDetails.getSalelistdetails().get(i).getGoodsId(), saleListWithDetails.getSalelistdetails().get(i).getDepotId(), uid);
                    stockMapper.increaseStock(stock.getStockId(), saleListWithDetails.getSalelistdetails().get(i).getSaleNumber(), saleListWithDetails.getInsertUser());
                }else{
                    System.out.println("为空");
                    stock=new Stock();
                    stock.setGoodsId(saleListWithDetails.getSalelistdetails().get(i).getGoodsId());
                    stock.setDepotId(saleListWithDetails.getSalelistdetails().get(i).getDepotId());
                    stock.setStockNumber(saleListWithDetails.getSalelistdetails().get(i).getSaleNumber());
                    stock.setLastaddUser(saleListWithDetails.getInsertUser());
                    stock.setUid(uid);
                    stockMapper.addStock(stock);
                }
                BeanUtils.copyProperties(saleListWithDetails.getSalelistdetails().get(i),salelistdetails);
                salelistdetails.setSalelistId(salelistId);
                salelistdetailsMapper.insert(salelistdetails);
            }
        }

        return 0;
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
