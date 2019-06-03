package com.kang.sys.service;

import com.kang.sys.entity.Listnumber;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-05-06
 */
public interface IListnumberService extends IService<Listnumber> {

    String findListNumber(Integer uid,Integer buysale);

     String frontCompWithZore(int sourceDate);

     void addNumber(Integer uid,Integer buysale ,String numberTime,Integer number);
}
