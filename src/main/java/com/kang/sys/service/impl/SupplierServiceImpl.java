package com.kang.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Supplier;
import com.kang.sys.mapper.SupplierMapper;
import com.kang.sys.service.ISupplierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierService {

    @Resource
    SupplierMapper supplierMapper;

    @Override
    public int addSupplier(Supplier supplier) {
        return supplierMapper.addSupplier(supplier);
    }

    @Override
    public int updateSupplier(Supplier supplier) {
        return supplierMapper.updateSupplier(supplier);
    }

    @Override
    public IPage<Supplier> selectPage(Page<Supplier> pages, Integer uid) {
        IPage<Supplier> customerIPage = supplierMapper.selectPage(pages,new QueryWrapper<Supplier>().eq("supplier_status","0").eq("uid",uid));
        return customerIPage;
    }

    @Override
    public void delSupplier(Integer id) {
        supplierMapper.delSupplier(id);
    }
}
