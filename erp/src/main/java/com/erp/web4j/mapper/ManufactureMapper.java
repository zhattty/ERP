package com.erp.web4j.mapper;

import com.erp.web4j.bean.Manufacture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManufactureMapper {
    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);

    List<Manufacture> listPageManufacture(@Param("offset") Integer offset,@Param("limit") Integer limit);

    int countAllManufactureRecords();

    int deleteByIds(@Param("ids") String[] ids);

    List<Manufacture> listPageManufactureBySn(@Param("sn") String sn,
                                              @Param("offset") Integer offset,
                                              @Param("limit") Integer limit);

    int countManufactureRecordsBySn(String s);

    List<Manufacture> listPageManufactureByOrderId(@Param("orderId") String orderId,
                                                   @Param("offset") Integer offset,
                                                   @Param("limit") Integer limit);

    int countManufactureRecordsByOrderId(String s);

    List<Manufacture> listPageManufactureByTechnologyName(@Param("tName") String tName,
                                                          @Param("offset") Integer offset,
                                                          @Param("limit") Integer limit);

    int countManufactureRecordsByTechnologyName(String s);

    Manufacture selectBySn(String sn);

    List<Manufacture> listManufacture();
}