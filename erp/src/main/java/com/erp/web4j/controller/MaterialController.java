package com.erp.web4j.controller;


import com.erp.web4j.bean.Material;
import com.erp.web4j.bean.Msg;
import com.erp.web4j.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin2.message.Message;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
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


    /***
     * list all materials by page
     * */
    @RequestMapping("/material/list")
    @ResponseBody
    public Map<String, Object> list(@RequestParam("page") Integer pageNum, @RequestParam("rows") Integer pageSize){
        Map<String, Object> map=  materialService.listMaterialByPage(pageNum, pageSize);
        return map;
    }

    /***
     *  add judge
     *  need session and authority
     *  v1.0 doesnot have the authority
     */
    @RequestMapping("/material/add_judge")
    @ResponseBody
    public Msg addJudge(HttpServletRequest request) {
        /***
         * 先略
         * 1. 得到session
         * 2. 得到用户
         * 3. 数据库查询是否有增加的权限
         * 4. 返回message。
         **/

        return null;
    }

    @RequestMapping("/material/add")
    public String initAddMaterial(){
        return "material_add";
    }

    @RequestMapping(value = "material/insert", method = RequestMethod.POST)
    public Msg insertMaterial(Material material) {
        Msg msg = new Msg();
        boolean ret = materialService.addMaterial(material);
        if(ret) {
            msg.setMsg("");
        }
    }


}
