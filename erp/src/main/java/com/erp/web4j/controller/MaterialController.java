package com.erp.web4j.controller;

import com.erp.web4j.bean.Material;
import com.erp.web4j.bean.MaterialConsume;
import com.erp.web4j.bean.MaterialReceive;
import com.erp.web4j.bean.ResponseMsg;
import com.erp.web4j.service.MaterialConsumeService;
import com.erp.web4j.service.MaterialReceiveService;
import com.erp.web4j.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    private MaterialReceiveService materialReceiveService;
    
    @Autowired
    private MaterialConsumeService materialConsumeService;

    /***
     *
     * ---------------------- Material Controller  ----------------------
     */
    @RequestMapping("/material/find")
    public String findMaterial() {
        return "material_list";
    }


    /***
     * function: list all materials by page 查询所有
     * */
    @RequestMapping("/material/list")
    @ResponseBody
    public Map<String, Object> list(@RequestParam("page") Integer pageNum, @RequestParam("rows") Integer pageSize){
        Map<String, Object> map=  materialService.listMaterialByPage(pageNum, pageSize);
        return map;
    }

    /**
     * function: search materials by id or type 按条件查询
     * @param searchValue
     * @param name
     * @param pageNum
     * @param pageSize
     * @return json
     */
    @RequestMapping("material/search_material_by_{name}")
    @ResponseBody
    public Map<String, Object> search(String searchValue, @PathVariable("name") String name, @RequestParam("page") Integer pageNum, @RequestParam("rows") Integer pageSize){
        Map<String, Object> map = null;
        if("materialId".equals(name)) {

            map=  materialService.searchMaterialById(searchValue,pageNum, pageSize);
        }
        if("materialType".equals(name)) {
            map = materialService.searchMaterialByType(searchValue,pageNum,pageSize);
        }
        return map;
    }

    @RequestMapping("/material/get/{name}")
    @ResponseBody
    public Material selectMaterialById(@PathVariable("name") String materialId){
        Material material =  materialService.getMaterial(materialId);
        return material;
    }

    @RequestMapping("material/get_data")
    @ResponseBody
    public List<Material> selectAll(){
        List<Material> materials = materialService.selectAllMaterials();
        return materials;
    }

    /***
     *  function: judge before add material
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
     * function：insert the material   添加
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
            msg.setMsg("添加失败");
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

    /**
     * jump to the update interface
     * @param materialId
     * @return
     */
    @RequestMapping("material/edit")
    public String findMaterial(String materialId) {
        return "material_edit";
    }

    /***
     * function: update Material 更新
     * @param material
     * @return
     */
    @RequestMapping("material/update_all")
    @ResponseBody
    public ResponseMsg updateMaterial(Material material) {
        boolean ret = materialService.updateMaterial(material);
        ResponseMsg msg = new ResponseMsg();
        if(ret) {
            msg.setStatus(200);
        }
        else {
            msg.setMsg("更新失败，请重试");
        }
        return msg;
    }

    @RequestMapping("material/update_note")
    @ResponseBody
    public  ResponseMsg updateNote(Material material) {
        boolean ret = materialService.updateMaterial(material);
        ResponseMsg msg = new ResponseMsg();
        if(ret) {
            msg.setStatus(200);
        }
        else {
            msg.setMsg("更新失败，请重试");
        }
        return msg;
    }


    /**
     ************************************material   Receive   Controller**************************************
     */
    @RequestMapping("/materialReceive/find")
    public String findMaterialReceive() {
        return "materialReceive_list";
    }

    /***
     * function: list all materialReceives by page 查询所有
     * */
    @RequestMapping("/materialReceive/list")
    @ResponseBody
    public Map<String, Object> materialReceiveLsit(@RequestParam("page") Integer pageNum, @RequestParam("rows") Integer pageSize){
        Map<String, Object> map=  materialReceiveService.listMaterialReceiveByPage(pageNum, pageSize);
        return map;
    }

    /**
     * function: search materials by id or type 按条件查询
     * @param searchValue
     * @param name
     * @param pageNum
     * @param pageSize
     * @return json
     */
    @RequestMapping("materialReceive/search_materialReceive_by_{name}")
    @ResponseBody
    public Map<String, Object> searchReceive(String searchValue, @PathVariable("name") String name, @RequestParam("page") Integer pageNum, @RequestParam("rows") Integer pageSize){
        Map<String, Object> map = null;
        if("materialId".equals(name)) {

            map=  materialReceiveService.searchMaterialReceiveBymaterialId(searchValue,pageNum, pageSize);
        }
        if("receiveId".equals(name)) {
            map = materialReceiveService.searchMaterialReceiveByReceiveId(searchValue,pageNum,pageSize);
        }
        return map;
    }

    /***
     *  function: judge before add material
     *  need session and authority
     *  v1.0 doesnot have the authority
     */
    @RequestMapping("/materialReceive/add_judge")
    @ResponseBody
    public ResponseMsg addJudge1(HttpServletRequest request) {
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

    @RequestMapping("/materialReceive/add")
    public String initAddMaterialReceive(){
        return "materialReceive_add";
    }

    /***
     * function：insert the MaterialReceive   添加
     * @param materialReceive
     * @return class message parased to json
     */
    @RequestMapping(value = "materialReceive/insert",produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg insertMaterialReceive(MaterialReceive materialReceive) {
        ResponseMsg msg = new ResponseMsg();

        boolean b = materialReceiveService.addMaterialReceive(materialReceive);
        if (b) {
            msg.setStatus(200);
            msg.setMsg("成功");
        }
        else{
            msg.setMsg("添加失败");
        }
        return msg;
    }

    @RequestMapping("/materialReceive/delete_judge")
    @ResponseBody
    public ResponseMsg initDeleteMaterialReceive() {
        ResponseMsg responseMsg = new ResponseMsg();
        return responseMsg;
    }

    /***
     * function: delelte batch by id， 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("materialReceive/delete_batch")
    @ResponseBody
    public ResponseMsg deleteMaterialReceive(String[] ids) {
        boolean ret = materialReceiveService.deleteMaterialReceives(ids);
        ResponseMsg responseMsg = new ResponseMsg();

        if(ret) {
            responseMsg.setStatus(200);
            responseMsg.setMsg("");
        }
        return responseMsg;

    }

    @RequestMapping("materialReceive/edit_judge")
    @ResponseBody
    public ResponseMsg initEditMaterialReceive() {
        return null;
    }

    /**
     * jump to the update interface
     * @param materialReceiveId
     * @return
     */
    @RequestMapping("materialReceive/edit")
    public String findMaterialReceive(String materialReceiveId) {
        return "materialReceive_edit";
    }

    /***
     * function: update MaterialReceive 更新
     * @param materialReceive
     * @return
     */
    @RequestMapping(value = {"materialReceive/update_add","materialReceive/update_note"})
    @ResponseBody
    public ResponseMsg updateMaterialReceive(MaterialReceive materialReceive) {

        boolean ret = materialReceiveService.updateMaterialReceive(materialReceive);
        ResponseMsg msg = new ResponseMsg();
        if(ret) {
            msg.setStatus(200);
        }
        else {
            msg.setMsg("更新失败，请重试");
        }
        return msg;
    }

    /**
     ************************************material   Consume   Controller**************************************
     */
    @RequestMapping("/materialConsume/find")
    public String findMaterialConsume() {
        return "materialConsume_list";
    }

    /***
     * function: list all materialConsumes by page 查询所有
     * */
    @RequestMapping("/materialConsume/list")
    @ResponseBody
    public Map<String, Object> materialConsumeLsit(@RequestParam("page") Integer pageNum, @RequestParam("rows") Integer pageSize){
        Map<String, Object> map=  materialConsumeService.listMaterialConsumeByPage(pageNum, pageSize);
        return map;
    }

    /**
     * function: search materials by id or type 按条件查询
     * @param searchValue
     * @param name
     * @param pageNum
     * @param pageSize
     * @return json
     */
    @RequestMapping("materialConsume/search_materialConsume_by_{name}")
    @ResponseBody
    public Map<String, Object> searchConsume(String searchValue, @PathVariable("name") String name, @RequestParam("page") Integer pageNum, @RequestParam("rows") Integer pageSize){
        Map<String, Object> map = null;
        if("materialId".equals(name)) {

            map=  materialConsumeService.searchMaterialConsumeBymaterialId(searchValue,pageNum, pageSize);
        }
        if("ConsumeId".equals(name)) {
            map = materialConsumeService.searchMaterialConsumeByConsumeId(searchValue,pageNum,pageSize);
        }
        return map;
    }

    /***
     *  function: judge before add material
     *  need session and authority
     *  v1.0 doesnot have the authority
     */
    @RequestMapping("/materialConsume/add_judge")
    @ResponseBody
    public ResponseMsg addJudge2(HttpServletRequest request) {
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

    @RequestMapping("/materialConsume/add")
    public String initAddMaterialConsume(){
        return "materialConsume_add";
    }

    /***
     * function：insert the MaterialConsume   添加
     * @param materialConsume
     * @return class message parased to json
     */
    @RequestMapping(value = "materialConsume/insert",produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg insertMaterialConsume(MaterialConsume materialConsume) {
        ResponseMsg msg = new ResponseMsg();

        boolean b = materialConsumeService.addMaterialConsume(materialConsume);
        if (b) {
            msg.setStatus(200);
            msg.setMsg("成功");
        }
        else{
            msg.setMsg("添加失败");
        }
        return msg;
    }

    @RequestMapping("/materialConsume/delete_judge")
    @ResponseBody
    public ResponseMsg initDeleteMaterialConsume() {
        ResponseMsg responseMsg = new ResponseMsg();
        return responseMsg;
    }

    /***
     * function: delelte batch by id， 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("materialConsume/delete_batch")
    @ResponseBody
    public ResponseMsg deleteMaterialConsume(String[] ids) {
        boolean ret = materialConsumeService.deleteMaterialConsume(ids);
        ResponseMsg responseMsg = new ResponseMsg();

        if(ret) {
            responseMsg.setStatus(200);
            responseMsg.setMsg("");
        }
        return responseMsg;

    }

    @RequestMapping("materialConsume/edit_judge")
    @ResponseBody
    public ResponseMsg initEditMaterialConsume() {
        return null;
    }

    /**
     * jump to the update interface
     * @param materialConsumeId
     * @return
     */
    @RequestMapping("materialConsume/edit")
    public String findMaterialConsume(String materialConsumeId) {
        return "materialConsume_edit";
    }

    /***
     * function: update MaterialConsume 更新
     * @param materialConsume
     * @return
     */
    @RequestMapping(value = {"materialConsume/update_add","materialConsume/update_note"})
    @ResponseBody
    public ResponseMsg updateMaterialConsume(MaterialConsume materialConsume) {

        boolean ret = materialConsumeService.updateMaterialConsume(materialConsume);
        ResponseMsg msg = new ResponseMsg();
        if(ret) {
            msg.setStatus(200);
        }
        else {
            msg.setMsg("更新失败，请重试");
        }
        return msg;
    }





}
