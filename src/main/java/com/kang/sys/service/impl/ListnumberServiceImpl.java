package com.kang.sys.service.impl;

import com.kang.sys.entity.Listnumber;
import com.kang.sys.mapper.ListnumberMapper;
import com.kang.sys.service.IListnumberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-05-06
 */
@Service
public class ListnumberServiceImpl extends ServiceImpl<ListnumberMapper, Listnumber> implements IListnumberService {

    @Resource
    ListnumberMapper listnumberMapper;


    /**
     * 生成订单编号
     */
    @Override
    public String findListNumber(Integer uid, Integer buysale) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        Integer number=listnumberMapper.findListNumber(uid,buysale,df.format(new Date()));
        if(number==null){
            listnumberMapper.addNumber(uid,buysale,df.format(new Date()),1);
            String listnumber = this.frontCompWithZore(1);
            return  df.format(new Date())+listnumber;
        }else {
            listnumberMapper.addNumber(uid,buysale,df.format(new Date()),number+1);
            String listnumber = this.frontCompWithZore(number+1);
            return df.format(new Date())+listnumber;
        }
    }

    @Override
    public String frontCompWithZore(int sourceDate) {
     String newString = String.format("%04d", sourceDate);
     return newString;
    }

    @Override
    public void addNumber(Integer uid, Integer buysale, String numberTime, Integer number) {
        listnumberMapper.addNumber(uid,buysale,numberTime,number);
    }

}
