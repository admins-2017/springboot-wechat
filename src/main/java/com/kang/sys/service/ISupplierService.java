package com.kang.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Supplier;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface ISupplierService extends IService<Supplier> {
    int addSupplier(Supplier supplier);

    int updateSupplier(Supplier supplier);

    IPage<Supplier> selectPage(Page<Supplier> pages, Integer uid);

    void delSupplier(Integer id);
}
