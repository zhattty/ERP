package com.erp.web4j.mapper;

import com.erp.web4j.bean.Manufacture;

public interface ManufactureMapper {
    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);
}