package com.erp.web4j.service.impl;

import com.erp.web4j.bean.Employee;
import com.erp.web4j.mapper.EmployeeMapper;
import com.erp.web4j.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/6 Time 10:36
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public Integer countOrderRecords() {
        return employeeMapper.countOrderRecords();
    }

    @Override
    public List<Employee> listOrders(Integer page, Integer rows) {
        return employeeMapper.listOrders((page-1)*rows,rows);
    }

    @Override
    public boolean insert(Employee employee) {
        return employeeMapper.insert(employee) == 1;
    }

    @Override
    public boolean update(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee) == 1;
    }

    @Override
    public boolean deleteBatch(int[] ids) {
        return employeeMapper.deletBatch(ids) == ids.length ? true:false;
    }

    @Override
    public Employee selectEmployeeById(String employeeId) {
        return employeeMapper.selectByPrimaryKey(employeeId);
    }

    @Override
    public List<Employee> listEmployee() {
        return employeeMapper.listEmployee();
    }
}
