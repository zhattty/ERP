package com.erp.web4j.mapper;

import com.erp.web4j.bean.Department;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    Integer countOrderRecords();

    List<Department> listOrders();
}