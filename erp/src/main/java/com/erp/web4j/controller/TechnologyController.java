package com.erp.web4j.controller;

import com.erp.web4j.bean.Technology;
import com.erp.web4j.service.TechnologyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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
            @Qualifier(value = "technologyService")
    TechnologyService technologyService;


    /**
     *
     *
     * @return technology.jsp
     */
    @RequestMapping("find")
    public String  find(){
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
     * 通过id查询数据
     * @param searchValue  所输入的数据
     * @param page
     * @param rows
     * @return 查询到的数据
     */
    @RequestMapping("search_technology_by_technologyId")
    @ResponseBody
    public List<Technology> search_technology_by_technologyId(@Param("searchValue")String  searchValue,@Param("page") Integer page,@Param("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        System.out.println("pre");
        List<Technology> technologies = technologyService.searchByPrimaryKey(searchValue, page, rows);
        System.out.println("past");
        return technologies;
    }

    /**
     *  通过name查询数据
     * @param searchValue
     * @param page
     * @param rows
     * @return 返回查询到的数据
     */
    @RequestMapping("search_technology_by_technologyName")
    @ResponseBody
    public List<Technology> search_technology_by_technologyName(@Param("searchValue")String  searchValue,@Param("page") Integer page,@Param("rows")Integer rows){
        if (page == null || page <= 0){
            page = 1;
        }
        if (rows<=0){
            rows = 10;
        }
        List<Technology> technologies = technologyService.searchByName(searchValue, page, rows);
        return technologies;
    }

    @RequestMapping("add_judge")
    @ResponseBody
    public String add_judge(){
        return "";
    }

    @RequestMapping("add")
    public String add(@Param("technology")Technology technology){
        //technologyService.insert(technology);
        return "technology_add";
    }

}
