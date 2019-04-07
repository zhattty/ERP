package com.erp.web4j.controller;

import com.erp.web4j.bean.FinalCountCheck;
import com.erp.web4j.bean.FinalMeasuretCheck;
import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.bean.StatusJson;
import com.erp.web4j.service.FinalCountCheckService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by Yana
 * Date 2019/4/6 Time 23:33
 */
@Controller
public class FinalCountCheckController {

    @Autowired
    FinalCountCheckService finalCountCheckService;



    @RequestMapping("f_count_check/find")
    public String findList(){
        return "f_count_check_list";
    }

    @RequestMapping("f_count_check/list")
    @ResponseBody
    public QueryVo<FinalCountCheck> finalCountCheckList(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows){

        if(page == null || page < 0){
            page = 1;
        }
        if(rows <= 0) {
            rows = 10;
        }

       int count = finalCountCheckService.queryAllFinalCountCheckNumber();
       ArrayList<FinalCountCheck> allFinalCountCheckList = finalCountCheckService.queryAllFinalCountCheckList(page, rows);
       QueryVo<FinalCountCheck> finalCountCheckQueryVo = new QueryVo<>();
       finalCountCheckQueryVo.setRows(allFinalCountCheckList);
       finalCountCheckQueryVo.setTotal(count);
       return finalCountCheckQueryVo;
    }

    @RequestMapping("fCountCheck/add_judge")
    @ResponseBody
    public String addJudge(){
        return "{}";
    }

    @RequestMapping("f_count_check/add")
    public String add(){
        return "p_count_check_add";
    }

    @RequestMapping("f_count_check/insert")
    @ResponseBody
    public StatusJson insert(FinalCountCheck finalCountCheck){
        StatusJson statusJson = new StatusJson();
        int insert = finalCountCheckService.insertFinalCountCheck(finalCountCheck);
        if(insert == 1){
           statusJson.setMsg("ok");
           statusJson.setStatus("200");
       }else {
            statusJson.setStatus("000");
            statusJson.setMsg("fail");
        }
        return statusJson;
    }

    @RequestMapping("fCountCheck/edit_judge")
    @ResponseBody()
    public String editJudge(){

        return "{}";
    }

    @RequestMapping("f_count_check/edit")
    public String edit(){
        return "p_count_check_edit";
    }

    @RequestMapping("fCountCheck/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "{}";
    }

    @RequestMapping("f_count_check/delete_batch")
    @ResponseBody
    public StatusJson deleteBatch(String[] ids){
        StatusJson statusJson = new StatusJson();
        int deleteCount = finalCountCheckService.deleteByIds(ids);
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



    @RequestMapping("f_count_check/update_all")
    @ResponseBody
    public StatusJson updateAll(FinalCountCheck finalCountCheck){
        StatusJson statusJson = new StatusJson();
        int update = finalCountCheckService.updateFinalCountCheck(finalCountCheck);
        if(update == 1){
            statusJson.setMsg("ok");
            statusJson.setStatus("200");
        }else {
            statusJson.setStatus("000");
            statusJson.setMsg("fail");
        }
        return statusJson;
    }

    @RequestMapping("f_count_check/search_fCountCheck_by_fCountCheckId")
    @ResponseBody
    public QueryVo<FinalCountCheck> searchFCountCheckByFCountCheckId(String searchValue, @RequestParam("page") Integer page, @RequestParam("rows")Integer rows ){
        if(page == null || page < 0){
            page=1;
        }
        if(rows <= 0){
            rows = 10;
        }

        ArrayList<FinalCountCheck> finalCountCheckList = finalCountCheckService.queryFinalCountCheckListByCheckId(searchValue, page, rows);
        int count = finalCountCheckService.queryFinalCountCheckNumberByCheckId(searchValue);
        QueryVo<FinalCountCheck> finalCountCheckQueryVo = new QueryVo<>();
        finalCountCheckQueryVo.setTotal(count);
        finalCountCheckQueryVo.setRows(finalCountCheckList);
        return finalCountCheckQueryVo;

    }

    @RequestMapping("f_count_check/search_fCountCheck_by_orderId")
    @ResponseBody
    public QueryVo<FinalCountCheck> searchFCountCheckByOrderId(String searchValue, @RequestParam("page") Integer page, @RequestParam("rows")Integer rows ) {
        if (page == null || page < 0) {
            page = 1;
        }
        if (rows <= 0) {
            rows = 10;
        }
        ArrayList<FinalCountCheck> finalCountCheckList = finalCountCheckService.queryFinalCountCheckListByCOrderId(searchValue, page, rows);
        int count = finalCountCheckService.queryFinalCountCheckNumberByOrderId(searchValue);
        QueryVo<FinalCountCheck> finalCountCheckQueryVo = new QueryVo<>();
        finalCountCheckQueryVo.setTotal(count);
        finalCountCheckQueryVo.setRows(finalCountCheckList);
        return finalCountCheckQueryVo;
    }


}












