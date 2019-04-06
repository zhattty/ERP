package com.erp.web4j.mapper;

import com.erp.web4j.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String empId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    Integer countOrderRecords();

    List<Employee> listOrders(@Param("offset") int offset,@Param("rows") Integer rows);

    Integer deletBatch(int[] ids);
}