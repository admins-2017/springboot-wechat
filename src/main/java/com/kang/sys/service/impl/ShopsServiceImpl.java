package com.kang.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Shops;
import com.kang.sys.mapper.ShopsMapper;
import com.kang.sys.service.IShopsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
@Service
public class ShopsServiceImpl extends ServiceImpl<ShopsMapper, Shops> implements IShopsService {

    @Resource
    ShopsMapper shopsMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor =Exception.class)
    public int addShop(Shops shops) { return shopsMapper.addShop(shops); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor =Exception.class)
    public int updateShop(Shops shops) {
        return shopsMapper.updateShop(shops); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public IPage<Shops> selectPage(Page<Shops> pages, Integer uid) {
        IPage<Shops> shopsIPage = shopsMapper.selectPage(pages,new QueryWrapper<Shops>().eq("shops_status","0").eq("uid",uid));
        return shopsIPage;
    }

    @Override
    public void delShop(Integer id) {
        shopsMapper.delShop(id);

    }
}
