package com.erp.web4j.controller;

import com.erp.web4j.bean.Department;
import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.bean.StatusJson;
import com.erp.web4j.bean.TechnologyPlan;
import com.erp.web4j.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/5 Time 17:57
 */
@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @RequestMapping("find")
    public String find(){return "department_list";}

    @RequestMapping("list")
    @ResponseBody
    public QueryVo<Department> list(){
        QueryVo<Department> departmentQueryVo = new QueryVo<>();
        Integer records = departmentService.countOrderRecords();
        List<Department> departments = departmentService.listOrders();

        departmentQueryVo.setRows(departments);
        departmentQueryVo.setTotal(records);
        return departmentQueryVo;
    }


    @RequestMapping("add_judge")
    @ResponseBody
    public String addJudge() {
        return "";
    }

    @RequestMapping("add")
    public String add() {
        return "department_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public StatusJson insert(Department department) {
        //StatusJson statusJson = new StatusJson();

            boolean flag = departmentService.insert(department);
            if (flag) {
                return new StatusJson("200", "OK", null);
            } else {
                return new StatusJson("0", "该工艺编号已经存在，请更换工艺编号！", null);
            }
        }
}

