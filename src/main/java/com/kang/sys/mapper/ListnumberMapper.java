package com.kang.sys.mapper;

import com.kang.sys.entity.Listnumber;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-05-06
 */
public interface ListnumberMapper extends BaseMapper<Listnumber> {

    @Select("select number from listnumber where uid=#{uid} and buyorsale=#{buyorsale} and number_time = #{numberTime} order by number_id DESC limit 1")
    Integer findListNumber(@Param("uid")Integer uid,@Param("buyorsale")Integer buysale ,@Param("numberTime")String numberTime);

    @Insert("INSERT INTO listnumber (uid,buyorsale,number_time,number) VALUES (#{uid},#{buyorsale},#{numberTime},#{number})")
    void addNumber(@Param("uid")Integer uid,@Param("buyorsale")Integer buysale ,@Param("numberTime")String numberTime,@Param("number")Integer number);
}
