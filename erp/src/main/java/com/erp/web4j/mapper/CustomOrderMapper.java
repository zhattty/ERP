package com.erp.web4j.mapper;

import com.erp.web4j.bean.CustomOrder;

public interface CustomOrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(CustomOrder record);

    int insertSelective(CustomOrder record);

    CustomOrder selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(CustomOrder record);

    int updateByPrimaryKey(CustomOrder record);
}