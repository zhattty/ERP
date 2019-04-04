package com.erp.web4j.service;

import com.erp.web4j.bean.CustomOrder;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/3 Time 20:23
 */

public interface CustomOrderService {
    List<CustomOrder> listOrders(Integer page,Integer rows);

    int countOrderRecords();
}
