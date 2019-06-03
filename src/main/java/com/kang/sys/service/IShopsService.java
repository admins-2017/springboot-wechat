package com.kang.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Shops;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface IShopsService extends IService<Shops> {

    int addShop(Shops shops);

    int updateShop(Shops shops);

    IPage<Shops> selectPage(Page<Shops> pages, Integer uid);

    void delShop(Integer id);


}
