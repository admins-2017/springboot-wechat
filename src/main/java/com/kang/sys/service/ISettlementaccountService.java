package com.kang.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Settlementaccount;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kang.sys.model.SettlementaccountModel;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface ISettlementaccountService extends IService<Settlementaccount> {

    IPage<Settlementaccount> selectPage(Page<Settlementaccount> pages,String name);

    void updateStatus(Integer status,Integer id);

    void delSettlementaccount(Integer id);

    IPage<Settlementaccount> selectSettlementaccountWithStatus(Page<Settlementaccount> pages,Integer status,Integer id);
}
