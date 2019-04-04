package com.erp.web4j.controller;


import com.erp.web4j.bean.Material;
import com.erp.web4j.bean.ResponseMsg;
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
    public ResponseMsg addJudge(HttpServletRequest request) {
        /***
         * 先略
         * 1. 得到session
         * 2. 得到用户
         * 3. 数据库查询是否有增加的权限
         * 4. 返回message。
         **/

        ResponseMsg responseMsg = new ResponseMsg();
        return responseMsg;
    }

    @RequestMapping("/material/add")
    public String initAddMaterial(){
        return "material_add";
    }

    /***
     * function：insert the material
     * @param material
     * @return class message parased to json
     */
    @RequestMapping(value = "material/insert",produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg insertMaterial(Material material) {
        ResponseMsg msg = new ResponseMsg();
        boolean b = materialService.addMaterial(material);
        if (b) {
            msg.setStatus(200);
            msg.setMsg("成功");
        }
        else{
            msg.setMsg("我自己的失败");
        }
        return msg;
    }


    @RequestMapping("/material/delete_judge")
    @ResponseBody
    public ResponseMsg initDeleteMaterial() {
        ResponseMsg responseMsg = new ResponseMsg();
        return responseMsg;
    }

    /***
     * function: delelte batch by id， 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("material/delete_batch")
    @ResponseBody
    public ResponseMsg deleteMaterial(String[] ids) {
        boolean ret = materialService.deleteMaterials(ids);
        ResponseMsg responseMsg = new ResponseMsg();

        if(ret) {
            responseMsg.setStatus(200);
            responseMsg.setMsg("");
        }

        return responseMsg;

    }

    @RequestMapping("material/edit_judge")
    @ResponseBody
    public ResponseMsg initEditMaterial() {
        return null;
    }

    @RequestMapping("material/edit")
    @ResponseBody
    public Material findMaterial(String materialId) {
        Material material =   materialService.findMaterialById(materialId);
        System.out.println(material);
        return material;
    }
}
