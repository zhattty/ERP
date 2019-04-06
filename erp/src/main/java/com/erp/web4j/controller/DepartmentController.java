package com.erp.web4j.controller;

import com.erp.web4j.bean.*;
import com.erp.web4j.bean.Process;
import com.erp.web4j.service.DepartmentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("edit_judge")
    @ResponseBody
    public String editJudge(){
        return "";
    }

    @RequestMapping("edit")
    public String edit(){
        return "process_edit";
    }

    /**
     * 更新数据库
     * @param department
     * @return
     */
    @RequestMapping("update_all")
    @ResponseBody
    public StatusJson updateAll(Department department){

        boolean flag = departmentService.update(department);
        if(flag ){
            return new StatusJson("200","OK",null);
        }else {
            return new StatusJson("0","该工艺编号已经存在，请更换工艺编号！",null);
        }
    }


    @RequestMapping("delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "";
    }

    /**
     * 批量删除
     * @param ids 前端传输过来的数据
     * @return  StatusJson
     */
    @RequestMapping("delete_batch")
    @ResponseBody
    public StatusJson deleteBatch(@RequestParam("ids")int[] ids){

        boolean flag = departmentService.deleteBatch(ids);
        if(flag ){
            return new StatusJson("200","OK",null);
        }else {
            return new StatusJson("0","删除失败",null);
        }
    }

    @RequestMapping("search_department_by_departmentId")
    @ResponseBody
    public List<Department> searchProcessByDepartmemtId(@RequestParam String  searchValue,@RequestParam Integer page,@RequestParam Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Department> departments = departmentService.searchByDepartmentId(searchValue, page, rows);
        return departments;
    }

    /**
     *  通过name查询数据
     * @param searchValue
     * @param page
     * @param rows
     * @return 返回查询到的数据
     */
    @RequestMapping("search_department_by_departmentName")
    @ResponseBody
    public List<Department> searchTechnologyByTechnologyName(@RequestParam("searchValue")String  searchValue,@Param("page") Integer page,@Param("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Department> departments = departmentService.searchByDepartmentName(searchValue, page, rows);
        return departments;
    }


    @RequestMapping("get_data")
    @ResponseBody
    public List<Department> getData() {
        return departmentService.findDepartment(1, 30);

    }
}

