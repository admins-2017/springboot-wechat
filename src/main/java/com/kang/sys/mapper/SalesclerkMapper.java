package com.kang.sys.mapper;

import com.kang.sys.entity.Salesclerk;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-04-18
 */
public interface SalesclerkMapper extends BaseMapper<Salesclerk> {

    int addSalesclerk(Salesclerk salesclerk);

    int updateSalesclerk(Salesclerk salesclerk);

    @Update("UPDATE salesclerk SET salesclerk_status=1  WHERE salesclerk_id=#{id} ")
    void delSalesclerk(@Param("id") Integer id);

}
