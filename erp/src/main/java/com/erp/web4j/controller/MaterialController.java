package com.erp.web4j.controller;

import com.erp.web4j.service.MaterialService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * ClassName: MaterialController
 * Description:
 *
 * @author mighty
 * @version 1.0
 * @date 2019/4/3  20:26
 */
@Controller
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @RequestMapping("/material/find")
    public String findMaterial() {
        return "material_list";
    }

    /*分页显示完成*/
    @RequestMapping("/material/list")
    @ResponseBody
    public Map<String, Object> list(@RequestParam("page") Integer pageNum, @RequestParam("rows") Integer pageSize){
        Map<String, Object> map=  materialService.listMaterialByPage(pageNum, pageSize);
        return map;
    }


}
