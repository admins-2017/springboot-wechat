package com.kang.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Depot;
import com.kang.sys.mapper.DepotMapper;
import com.kang.sys.service.IDepotService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
public class DepotServiceImpl extends ServiceImpl<DepotMapper, Depot> implements IDepotService {

    @Resource
    DepotMapper depotMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int addDepot(Depot depot) {
        return depotMapper.addDepot(depot);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int updateDepot(Depot depot) {
        return depotMapper.updateDepot(depot);
    }

    @Override
    public IPage<Depot> selectPage(Page<Depot> pages,Integer shops) {
        IPage<Depot> userIPage = depotMapper.selectPage(pages,new QueryWrapper<Depot>().eq("depot_status","0").eq("shops_id",shops));
        return userIPage;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void delDepot(Integer id) {
        depotMapper.delDepot(id);
    }
}
