package com.erp.web4j.controller;

import com.erp.web4j.bean.Technology;
import com.erp.web4j.service.TechnologyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/3 Time 18:00
 */
@Controller
@RequestMapping("technology")
class TechnologyController {
    @Autowired
    @Qualifier("TechnologyService")
    TechnologyService technologyService;


    /**
     *
     *
     * @return technology.jsp
     */
    @RequestMapping("find")
    public String  find(){
       /* List<Technology> technologyList =  technologyService.searchTechnology(technology);
        model.addAttribute(technologyList);*/

        return "technology_list";
    }

    /**
     * 分页并返回分页查询后的数据
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public List<Technology> list(@Param("page") Integer page,@Param("rows")Integer rows){

        List<Technology> technologyList = technologyService.findTechnology(page, rows);
        return technologyList;
    }

    /**
     *
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("search_technology_by_technologyId")
    @ResponseBody
    public List<Technology> search_technology_by_technologyId(@Param("searchValue")String  searchValue,@Param("page") Integer page,@Param("rows")Integer rows){
        System.out.println("pre");
        List<Technology> technologies = technologyService.searchByPrimaryKey(searchValue, page, rows);
        System.out.println("past");
        return technologies;
    }

    @RequestMapping("search_technology_by_technologyName")
    @ResponseBody
    public List<Technology> search_technology_by_technologyName(@Param("searchValue")String  searchValue,@Param("page") Integer page,@Param("rows")Integer rows){
        List<Technology> technologies = technologyService.searchByName(searchValue, page, rows);
        return technologies;
    }
}
