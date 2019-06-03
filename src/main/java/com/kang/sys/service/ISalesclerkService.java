package com.kang.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Salesclerk;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface ISalesclerkService extends IService<Salesclerk> {
    int addSalesclerk(Salesclerk salesclerk);

    int updateSalesclerk(Salesclerk salesclerk);

    IPage<Salesclerk> selectPage (Page<Salesclerk>page,Integer uid);

    void delSalesclerk( Integer id);

}
