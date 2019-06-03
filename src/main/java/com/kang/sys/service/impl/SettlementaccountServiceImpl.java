package com.kang.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kang.sys.entity.Settlementaccount;
import com.kang.sys.mapper.SettlementaccountMapper;
import com.kang.sys.model.SettlementaccountModel;
import com.kang.sys.service.ISettlementaccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SettlementaccountServiceImpl extends ServiceImpl<SettlementaccountMapper, Settlementaccount> implements ISettlementaccountService {

    @Resource
    SettlementaccountMapper mapper;


    @Override
    public IPage<Settlementaccount> selectPage(Page<Settlementaccount> pages,String name) {
        IPage<Settlementaccount> iPage = mapper.selectPage(pages,new QueryWrapper<Settlementaccount>().eq("settlementaccount_status",0).like("settlementaccount_name",name)
                .or().eq("settlementaccount_status",0).like("settlementaccount_number",name)
                .or().eq("settlementaccount_status",0).like("settlementaccount_type",name));
        return iPage;
    }

    @Override
    public void updateStatus(Integer status,Integer id) {
        Settlementaccount settlementaccount=new Settlementaccount();
        settlementaccount.setSettlementaccountStatus(status);
        mapper.update(settlementaccount,new QueryWrapper<Settlementaccount>().eq("settlementaccount_id",id));
    }

    @Override
    public void delSettlementaccount(Integer id) {
        mapper.deleteById(id);
    }

    @Override
    public IPage<Settlementaccount> selectSettlementaccountWithStatus(Page<Settlementaccount> pages, Integer status,Integer id) {
        if(status==0) {
            IPage<Settlementaccount> iPage = mapper.selectPage(pages, new QueryWrapper<Settlementaccount>().eq("settlementaccount_status",status).eq("uid",id));
            return iPage;
        }else {
            IPage<Settlementaccount> iPage = mapper.selectPage(pages, new QueryWrapper<Settlementaccount>().eq("settlementaccount_status",status).eq("uid",id));
            return iPage;
        }
    }


}
