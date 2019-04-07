package com.erp.web4j.service;

import com.erp.web4j.bean.Employee;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/6 Time 10:35
 */
public interface EmployeeService {
    Integer countOrderRecords();

    List<Employee> listOrders(Integer page, Integer rows);

    boolean insert(Employee employee);

    boolean update(Employee employee);

    boolean deleteBatch(int[] ids);

    Employee selectEmployeeById(String employeeId);

    List<Employee> listEmployee();
}
