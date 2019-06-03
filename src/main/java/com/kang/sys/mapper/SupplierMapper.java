package com.kang.sys.mapper;

import com.kang.sys.entity.Supplier;
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
public interface SupplierMapper extends BaseMapper<Supplier> {

    int addSupplier(Supplier supplier);

    int updateSupplier(Supplier supplier);

    @Update("UPDATE supplier SET supplier_status=1  WHERE supplier_id=#{id} ")
    void delSupplier(@Param("id") Integer id);


    @Update("UPDATE supplier SET supplier_arrears=(supplier_arrears+ #{paymentPrice}) WHERE supplier_id=#{supplierId}")
    int increaseSupplierArrears(@Param("supplierId") Integer supplierid,@Param("paymentPrice") Double paymentPrice);

    @Update("UPDATE supplier SET supplier_arrears=(supplier_arrears- #{paymentPrice}) WHERE supplier_id=#{supplierId}")
    int subtractSupplierArrears(@Param("supplierId") Integer supplierid,@Param("paymentPrice") Double paymentPrice);
}
