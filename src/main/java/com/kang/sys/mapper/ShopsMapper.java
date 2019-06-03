package com.kang.sys.mapper;

import com.kang.sys.entity.Shops;
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
public interface ShopsMapper extends BaseMapper<Shops> {


    int addShop(Shops shops);

    int updateShop(Shops shops);

    @Update("UPDATE shops SET shops_status=2  WHERE shops_id=#{id} ")
    void delShop(@Param("id") Integer id);



}
