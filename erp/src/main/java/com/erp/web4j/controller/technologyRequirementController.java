package com.erp.web4j.controller;

import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.bean.TechnologyRequirement;
import com.erp.web4j.service.TechnologyRequirementService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wawawa
 * Date 2019/4/4 Time 10:10
 */
@Controller
@RequestMapping("technologyRequirement")
public class technologyRequirementController {

    @Autowired
    TechnologyRequirementService requirementService;

    @RequestMapping("find")
    public String find(){
        return "technologyRequirement_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public QueryVo<TechnologyRequirement> list(@Param("page") Integer page, @Param("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        return null;

    }
}
