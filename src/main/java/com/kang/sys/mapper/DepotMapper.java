package com.kang.sys.mapper;

import com.kang.sys.entity.Depot;
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
public interface DepotMapper extends BaseMapper<Depot> {

    int addDepot(Depot depot);

    int updateDepot(Depot depot);

    @Update("UPDATE shops SET shops_status=1 WHERE shops_id=#{id}")
    void delDepot(@Param("id") Integer id);
}
