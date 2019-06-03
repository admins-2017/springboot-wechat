package com.kang.sys.service;

import com.kang.sys.entity.Receivables;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kang.sys.vo.ReceivablesWithCustomerVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface IReceivablesService extends IService<Receivables> {

    String addReceivables(Receivables receivables);

    List<ReceivablesWithCustomerVo> findReceivables(Integer uid, String datas);

    String delReceivables(Integer id);

    List<ReceivablesWithCustomerVo> queryHistoryReceivables(Integer status,Integer uid);
}
