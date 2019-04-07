package com.erp.web4j.controller;

import com.erp.web4j.bean.ProcessCountCheck;
import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.bean.StatusJson;
import com.erp.web4j.service.ProcessCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by Yana
 * Date 2019/4/7 Time 22:10
 */
@Controller
public class ProcessCountCheckController {

    @Autowired
    ProcessCountCheckService processCountCheckService;


    @RequestMapping("p_count_check/find")
    public String find() {
        return "p_count_check_list";
    }

    @RequestMapping("p_count_check/list")
    @ResponseBody
    public QueryVo<ProcessCountCheck> proccessCountCheckList(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){

        if(page == null || page < 0){
            page = 1;
        }
        if(rows <= 0) {
            rows = 10;
        }
        ArrayList<ProcessCountCheck> processCountCheckList = processCountCheckService.queryAllList(page,rows);
        int count = processCountCheckService.queryCount();
        QueryVo<ProcessCountCheck> processCountCheckQueryVo = new QueryVo<>();
        processCountCheckQueryVo.setRows(processCountCheckList);
        processCountCheckQueryVo.setTotal(count);
        return processCountCheckQueryVo;

    }

    @RequestMapping("pCountCheck/add_judge")
    @ResponseBody
    public String addJudge(){
        return "{}";
    }


    @RequestMapping("p_count_check/add")
    public String add(){
        return "p_count_check_add";
    }

    @RequestMapping("p_count_check/insert")
    @ResponseBody
    public StatusJson insert(ProcessCountCheck processCountCheck){
        StatusJson statusJson = new StatusJson();
        int insert = processCountCheckService.insert(processCountCheck);
        if(insert == 1){
            statusJson.setMsg("ok");
            statusJson.setStatus("200");
        }else {
            statusJson.setStatus("000");
            statusJson.setMsg("fail");
        }
        return statusJson;
    }

    @RequestMapping("pCountCheck/edit_judge")
    @ResponseBody()
    public String editJudge(){

        return "{}";
    }

    @RequestMapping("p_count_check/edit")
    public String edit(){
        return "p_count_check_edit";
    }

    @RequestMapping("p_count_check/update_all")
    @ResponseBody
    public StatusJson update(ProcessCountCheck processCountCheck){
        StatusJson statusJson = new StatusJson();
        int update = processCountCheckService.update(processCountCheck);
        if(update == 1) {
            statusJson.setMsg("0k");
            statusJson.setStatus("200");
        }else {
            statusJson.setMsg("fail");
            statusJson.setStatus("000");
        }
        return statusJson;
    }

    @RequestMapping("pCountCheck/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "{}";
    }

    @RequestMapping("p_count_check/delete_batch")
    @ResponseBody
    public StatusJson deleteBatch(String[] ids){
        StatusJson statusJson = new StatusJson();
        int deleteCount = processCountCheckService.deleteByIds(ids);
        if(ids == null || ids.length == 0 ){
            statusJson.setMsg("not check");
            statusJson.setStatus("000");
        } else if(deleteCount > 0 && deleteCount < ids.length ){
            statusJson.setMsg("only delete part");
            statusJson.setMsg("000");
        }else if(deleteCount == ids.length){
            statusJson.setStatus("200");
            statusJson.setMsg("ok");
        }else {
            statusJson.setMsg("fail");
            statusJson.setStatus("000");
        }
        return statusJson;
    }

    @RequestMapping("p_count_check/search_pCountCheck_by_pCountCheckId")
    @ResponseBody
    public QueryVo<ProcessCountCheck> searchFCountCheckByCountCheckId(String searchValue, @RequestParam("page") Integer page, @RequestParam("rows")Integer rows ){
        if(page == null || page < 0){
            page=1;
        }
        if(rows <= 0){
            rows = 10;
        }

        ArrayList<ProcessCountCheck> processCountCheckArrayList = processCountCheckService.queryListByCheckId(searchValue, page, rows);
        int count = processCountCheckService.queryNumberByCheckId(searchValue);
        QueryVo<ProcessCountCheck>  processCountCheckQueryVo = new QueryVo<>();
        processCountCheckQueryVo.setTotal(count);
        processCountCheckQueryVo.setRows( processCountCheckArrayList);
        return  processCountCheckQueryVo;

    }

}
