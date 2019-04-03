package com.erp.web4j.mapper;

import com.erp.web4j.bean.Product;

public interface ProductMapper {
    int insert(Product record);

    int insertSelective(Product record);
}