package com.erp.web4j.controller;

import com.erp.web4j.bean.*;
import com.erp.web4j.bean.Process;
import com.erp.web4j.service.ProcessService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/5 Time 16:21
 */
@Controller
@RequestMapping("process")
public class ProcessController {

    @Autowired
    ProcessService processService;

    @RequestMapping("find")
    public String find(){
        return "process_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public QueryVo<Process> list(Integer page,Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        QueryVo<Process> processQueryVo = new QueryVo<>();
        Integer records = processService.countOrderRecords();
        List<Process> technologyPlans = processService.searchByPrimaryKey(page, rows);

        processQueryVo.setRows(technologyPlans);
        processQueryVo.setTotal(records);
        return processQueryVo;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String addJudge() {
        return "";
    }

    @RequestMapping("add")
    public String add() {
        return "process_add";
    }

    @RequestMapping("insert")
    @ResponseBody
    public StatusJson insert(Process process) {
        //StatusJson statusJson = new StatusJson();

            boolean flag = processService.insert(process);
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
     * @param process
     * @return
     */
    @RequestMapping("update_all")
    @ResponseBody
    public StatusJson updateAll(Process process){

            boolean flag = processService.update(process);
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

            boolean flag = processService.deleteBatch(ids);
            if(flag ){
                return new StatusJson("200","OK",null);
            }else {
                return new StatusJson("0","删除失败",null);
            }
        }

    @RequestMapping("search_process_by_processId")
    @ResponseBody
    public List<Process> searchProcessByProcessId(String  searchValue, Integer page,@Param("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Process> technologies = processService.searchByPrimaryKey2(searchValue, page, rows);
        return technologies;
    }

    /**
     *  通过name查询数据
     * @param searchValue
     * @param page
     * @param rows
     * @return 返回查询到的数据
     */
    @RequestMapping("search_process_by_technologyPlanId")
    @ResponseBody
    public List<Process> searchTechnologyByTechnologyName(@RequestParam("searchValue")String  searchValue,@Param("page") Integer page,@Param("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Process> technologies = processService.searchByTechnologyId(searchValue, page, rows);
        return technologies;
    }


    @RequestMapping("get_data")
    @ResponseBody
    public List<Process> getData() {
        return processService.searchByPrimaryKey(1,30);

    }
}




