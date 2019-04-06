package com.erp.web4j.controller;

import com.erp.web4j.bean.Employee;
import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.bean.StatusJson;
import com.erp.web4j.bean.TechnologyPlan;
import com.erp.web4j.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/6 Time 10:35
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @RequestMapping("find")
    public String find() {
        return "employee_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public QueryVo<Employee> list(@RequestParam Integer page, @RequestParam Integer rows) {
        if (page == null || page <= 0) {
            page = 1;
        }
        if (rows <= 0) {
            rows = 10;
        }
        Integer records = employeeService.countOrderRecords();
        List<Employee> employees = employeeService.listOrders(page, rows);
        QueryVo<Employee> employeeQueryVo = new QueryVo<>();
        employeeQueryVo.setRows(employees);
        employeeQueryVo.setTotal(records);
        return employeeQueryVo;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String addJudge() {
        return "";
    }

    @RequestMapping("add")
    public String add() {
        return "employee_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public StatusJson insert(Employee employee) {
        //StatusJson statusJson = new StatusJson();

            boolean flag = employeeService.insert(employee);
            if (flag) {
                return new StatusJson("200", "OK", null);
            } else {
                return new StatusJson("0", "该工艺编号已经存在，请更换工艺编号！", null);
            }
        }


    @RequestMapping("edit_judge")
    @ResponseBody
    public String editJudge() {
        return "";
    }

    @RequestMapping("edit")
    public String edit() {
        return "employee_edit";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public StatusJson updateAll(Employee employee) {

        boolean flag = employeeService.update(employee);
        if (flag) {
            return new StatusJson("200", "OK", null);
        } else {
            return new StatusJson("0", "该工艺编号已经存在，请更换工艺编号！", null);
        }
    }

    @RequestMapping("delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "";
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public StatusJson deleteBatch(@RequestParam("ids")int[] ids){

        boolean flag = employeeService.deleteBatch(ids);
        if(flag ){
            return new StatusJson("200","OK",null);
        }else {
            return new StatusJson("0","删除失败",null);
        }
    }


}
