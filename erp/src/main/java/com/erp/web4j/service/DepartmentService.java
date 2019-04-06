package com.erp.web4j.service;

import com.erp.web4j.bean.Department;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/5 Time 18:00
 */
public interface DepartmentService {
    Integer countOrderRecords();

    List<Department> listOrders();

    boolean insert(Department department);

    boolean update(Department department);

    boolean deleteBatch(int[] ids);

    List<Department> searchByDepartmentId(String searchValue, Integer page, Integer rows);

    List<Department> searchByDepartmentName(String searchValue, Integer page, Integer rows);

    List<Department> findDepartment(int page, int rows);
}
