package com.erp.web4j.service.impl;


import com.erp.web4j.bean.CustomOrder;
import com.erp.web4j.mapper.CustomOrderMapper;
import com.erp.web4j.service.CustomOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/3 Time 20:41
 */
@Service
public class CustomOrderServiceImpl implements CustomOrderService {
    @Autowired
    CustomOrderMapper customOrderMapper;

    /**
     * 在service层将 页码转成数据库偏移量，直接调用接口
     * @param page 页码
     * @param rows 每页行数
     * @return CustomOrder的List，没有限制条件
     */
    @Override
    public List<CustomOrder> listOrders(Integer page, Integer rows) {
        return customOrderMapper.listOrders((page-1)*rows,rows);
    }

    @Override
    public int countOrderRecords() {
        return customOrderMapper.countOrderRecords();
    }
}
