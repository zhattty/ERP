package com.erp.web4j.mapper;

import com.erp.web4j.bean.Department;
import org.apache.ibatis.annotations.Param;

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

    Integer deletBatch(int[] ids);

    List<Department> searchByDepartmentId(@Param("searchValue")String searchValue, @Param("offset") Integer offset,@Param("rows") Integer rows);

    List<Department> searchByDepartmentName(@Param("searchValue")String searchValue, @Param("offset")Integer offset, @Param("rows")Integer rows);

    List<Department> findDepartment(@Param("offset") int offset, @Param("rows") int rows);
}