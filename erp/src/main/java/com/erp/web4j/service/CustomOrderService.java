package com.erp.web4j.service;

import com.erp.web4j.bean.CustomOrder;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/3 Time 20:23
 */

public interface CustomOrderService {
    List<CustomOrder> listOrders(Integer page, Integer rows);

    int countOrderRecords();

    int insert(CustomOrder customOrder);

    int updateCustomOrderByPrimaryKey(CustomOrder customOrder);

    int deleteCustomOrderByIds(int[] ids);

    List<CustomOrder> listOrdersById(String id, Integer page, Integer rows);

    Integer countOrderRecordsById(String searchValue);

    List<CustomOrder> listOrdersByCustomName(String searchValue, Integer page, Integer rows);

    Integer countOrderRecordsByCustomName(String searchValue);

    Integer countOrderRecordsByProductName(String searchValue);

    List<CustomOrder> listOrdersByProductName(String searchValue, Integer page, Integer rows);

    CustomOrder selectCustomById(String orderId);

    List<CustomOrder> listAllOrders();
}
