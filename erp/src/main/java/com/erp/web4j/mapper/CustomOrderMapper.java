package com.erp.web4j.mapper;

import com.erp.web4j.bean.CustomOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CustomOrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(CustomOrder record);

    int insertSelective(CustomOrder record);

    CustomOrder selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(CustomOrder record);

    int updateByPrimaryKey(CustomOrder record);

    List<CustomOrder> listOrders(@Param("offset") Integer offset, @Param("rows") Integer rows);

    int countOrderRecords();

    Integer deleteByIds(@Param("ids") int[] ids);

    List<CustomOrder> listOrdersById(@Param("order_id") String s,@Param("offset") Integer offset, @Param("rows") Integer rows);

    Integer countOrderRecordsById(String s);

    List<CustomOrder> listOrdersByCustomName(@Param("customName") String customName,
                                             @Param("offset") Integer offset,
                                             @Param("rows") Integer rows);

    Integer countOrderRecordsByCustomName(String s);

    List<CustomOrder> listOrdersByProductName(@Param("productName") String customName,
                                              @Param("offset") Integer offset,
                                              @Param("rows") Integer rows);

    Integer countOrderRecordsByProductName(String s);
}