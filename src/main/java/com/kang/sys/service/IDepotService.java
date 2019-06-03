package com.kang.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Depot;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface IDepotService extends IService<Depot> {

    int addDepot(Depot depot);

    int updateDepot(Depot depot);

    IPage<Depot> selectPage(Page<Depot> pages,Integer shops);

    void delDepot(Integer id);
}
