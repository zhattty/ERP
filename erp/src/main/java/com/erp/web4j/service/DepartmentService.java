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

}
