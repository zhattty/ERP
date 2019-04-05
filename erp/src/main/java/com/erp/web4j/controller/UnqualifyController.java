package com.erp.web4j.controller;

import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.bean.UnqualifyApply;
import com.erp.web4j.service.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Yana
 * Date 2019/4/4 Time 11:17
 */

@Controller
public class UnqualifyController {
    @Autowired
    UnqualifyService unqualityService;

    @RequestMapping("unqualify/find")
    public String findUnqualifyApply(){
        return "unqualify_list";
    }

    @RequestMapping("unqualify/list")
    @ResponseBody()
    public QueryVo<UnqualifyApply> listUnqualify(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){

        if(page == null || page < 0 ){
            page = 1;
        }
        if(rows <= 0){
            rows=10;
        }
        Integer records =unqualityService.countUnqualifyRecords();
        ArrayList<UnqualifyApply> unqualifyApplies = unqualityService.queryUnqualifyApply(page, rows);
        QueryVo<UnqualifyApply> unqualifyQueryVo = new QueryVo<>();
        unqualifyQueryVo.setRows(unqualifyApplies);
        unqualifyQueryVo.setTotal(records );

        return unqualifyQueryVo;

    }




}
