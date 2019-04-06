package com.erp.web4j.controller;

import com.erp.web4j.bean.*;
import com.erp.web4j.service.MaterialConsumeService;
import com.erp.web4j.service.MaterialReceiveService;
import com.erp.web4j.service.MaterialService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MaterialController
 * Description:  物料模块的controller
 *
 * @author mighty
 * @version 1.0
 * @date 2019/4/3  20:26
 */
@Controller
public class MaterialController {
    public static Log log = LogFactory.getLog(MaterialController.class);

    @Autowired
    private MaterialService materialService;
    @Autowired
    private MaterialReceiveService materialReceiveService;

    @Autowired
    private MaterialConsumeService materialConsumeService;


    /***
     *
     * *********************************** Material Controller  ****************************************
     */
    @RequestMapping("/material/find")
    public String findMaterial() {
        return "material_list";
    }


    /***
     * 分页查询所有的物料信息
     * @param pageNum   当前页
     * @param pageSize  页的容量
     * @return json
     */
    @RequestMapping("/material/list")
    @ResponseBody
    public QueryVo<Material> list(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "rows", defaultValue = "10") Integer pageSize){

        Integer num = pageNum>1 ? pageNum: 1;
        Integer size = pageSize>0 ? pageSize: 10;
        return materialService.listMaterialByPage(num, size);

    }

    /***
     * 按不同条件分页查询物料信息
     * @param searchValue   查询的值
     * @param name          查询条件
     * @param pageNum       第几页
     * @param pageSize      每页的容量
     * @return
     */
    @RequestMapping("material/search_material_by_{name}")
    @ResponseBody
    public QueryVo<Material> search(String searchValue, @PathVariable(value = "name", required = true) String name,
                                    @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "rows", defaultValue = "10") Integer pageSize){

        QueryVo<Material> queryVo = new QueryVo<>();
        Integer num = pageNum>1 ? pageNum: 1;
        Integer size = pageSize>0 ? pageSize: 10;

        if("materialId".equals(name)) {
            queryVo =   materialService.searchMaterialById(searchValue,num, size);
        }
        if("materialType".equals(name)) {
            queryVo = materialService.searchMaterialByType(searchValue,num, size);
        }

        return queryVo;

    }

    /***
     * 根据物料id查询物料
     * @param materialId
     * @return
     */
    @RequestMapping("/material/get/{name}")
    @ResponseBody
    public Material selectMaterialById(@PathVariable("name") String materialId){
        return   materialService.getMaterial(materialId);
    }

    /**
     * 通用接口  查询所有的物料
     * @return
     */
    @RequestMapping("material/get_data")
    @ResponseBody
    public List<Material> selectAll(){
        return materialService.selectAllMaterials();
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
     * 参数校验并添加物料
     * @param material
     * @return
     */
    @RequestMapping(value = "material/insert",produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg insertMaterial(@Valid Material material, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            String msg = "";
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                msg += fieldError.getField() +":" +  fieldError.getDefaultMessage() + "\r\n";
            }
            return new ResponseMsg(null, msg, "");
        }
        Material select = materialService.getMaterial(material.getMaterialId());
        if(select!=null) {
            return new ResponseMsg(null,"物料编号已存在，请重新输入","");
        }
        else {
            boolean ret = materialService.addMaterial(material);
            if (ret) {
                return ResponseMsg.OK;
            }
            return ResponseMsg.FAIL;

        }

    }

    /**
     * 删除的权限控制
     * @return
     */
    @RequestMapping("/material/delete_judge")
    @ResponseBody
    public ResponseMsg initDeleteMaterial() {
        ResponseMsg responseMsg = new ResponseMsg();
        return responseMsg;
    }

    /***
     * 批量删除 物料
     * @param ids
     * @return
     */
    @RequestMapping("material/delete_batch")
    @ResponseBody
    public ResponseMsg deleteMaterial(String[] ids) {
        boolean ret = materialService.deleteMaterials(ids);

        if(ret) {
            return ResponseMsg.OK;
        }
        return ResponseMsg.FAIL;
    }

    /**
     * 编辑的权限校验
     * @return
     */
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
     * function: 更新 物料
     * @param material
     * @return
     */
    @RequestMapping("material/update_all")
    @ResponseBody
    public ResponseMsg updateMaterial(@Valid Material material, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            String msg = "";
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                msg += fieldError.getDefaultMessage();
            }
            return new ResponseMsg(null,msg,"");
        }
        boolean ret = materialService.updateMaterial(material);
        if(ret) {
            return ResponseMsg.OK;
        }
        else {
            return ResponseMsg.FAIL;
        }
    }

    /**
     * 修改 物料的备注
     * @param material
     * @return
     */
    @RequestMapping("material/update_note")
    @ResponseBody
    public  ResponseMsg updateNote(Material material) {
        boolean ret = materialService.updateMaterial(material);
        if(ret) {
            return ResponseMsg.OK;
        }
        else {
            return ResponseMsg.FAIL;
        }

    }


    /**
     ************************************material   Receive   Controller**************************************
     */
    @RequestMapping("/materialReceive/find")
    public String findMaterialReceive() {
        return "materialReceive_list";
    }

    /***
     *  分页查询 物料接收 信息
     * */
    @RequestMapping("/materialReceive/list")
    @ResponseBody
    public QueryVo<MaterialReceive> materialReceiveList(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "rows", defaultValue = "10") Integer pageSize){
        Integer num = pageNum>1 ? pageNum: 1;
        Integer size = pageSize>0 ? pageSize: 10;

        return materialReceiveService.listMaterialReceiveByPage(num, size);
    }

    /**
     * 按条件分页查询 物料接收信息
     * @param searchValue 查询的条件
     * @param name        查询哪种类型
     * @param pageNum
     * @param pageSize
     * @return json
     */
    @RequestMapping("materialReceive/search_materialReceive_by_{name}")
    @ResponseBody
    public QueryVo<MaterialReceive> searchReceive(String searchValue, @PathVariable(value = "name", required = true) String name,
                                                  @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                                  @RequestParam(value = "rows", defaultValue = "10") Integer pageSize){

        Integer num = pageNum>1 ? pageNum: 1;
        Integer size = pageSize>0 ? pageSize: 10;
        Page onePage = PageHelper.startPage(num,size,true);
        QueryVo<MaterialReceive> materialReceives = null;
        if("materialId".equals(name)) {

            materialReceives=  materialReceiveService.searchMaterialReceiveBymaterialId(searchValue,num,size);
        }
        if("receiveId".equals(name)) {
            materialReceives = materialReceiveService.searchMaterialReceiveByReceiveId(searchValue,num,size);
        }

        return materialReceives;
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
     * function：添加 物料接收 信息
     * @param materialReceive  信息
     * @return json
     */
    @RequestMapping(value = "materialReceive/insert",produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg insertMaterialReceive(@Valid MaterialReceive materialReceive,BindingResult bindingResult ) {

        if(bindingResult.hasErrors()) {
            String msg = "";
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                msg += fieldError.getDefaultMessage();
                log.info(msg);
            }
            return new ResponseMsg(null,msg,"");
        }
        MaterialReceive select = materialReceiveService.findMaterialReceive(materialReceive.getReceiveId());

        if(select!=null) {
            return new ResponseMsg(null,"物料收入编号已存在，请重新输入","");
        }
        else {
            boolean b = materialReceiveService.addMaterialReceive(materialReceive);

            if (b) {
                return ResponseMsg.OK;

            }
            else{
                return ResponseMsg.FAIL;
            }
        }
    }

    @RequestMapping("/materialReceive/delete_judge")
    @ResponseBody
    public ResponseMsg initDeleteMaterialReceive() {
        ResponseMsg responseMsg = new ResponseMsg();
        return responseMsg;
    }

    /***
     * function:  批量删除 物料接收信息
     * @param ids
     * @return
     */
    @RequestMapping("materialReceive/delete_batch")
    @ResponseBody
    public ResponseMsg deleteMaterialReceive(String[] ids) {
        boolean ret = materialReceiveService.deleteMaterialReceives(ids);
        ResponseMsg responseMsg = new ResponseMsg();

        if(ret) {
            return ResponseMsg.OK;
        }
        return ResponseMsg.FAIL;

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
     * 更新 物料接收 信息
     * @param materialReceive
     * @return
     */
    @RequestMapping(value = {"/materialReceive/update_all","/materialReceive/update_note"})
    @ResponseBody
    public ResponseMsg updateMaterialReceive(@Valid MaterialReceive materialReceive, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            String msg = "";
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                msg += fieldError.getDefaultMessage();
            }
            return new ResponseMsg(null,msg,"");
        }
        boolean ret = materialReceiveService.updateMaterialReceive(materialReceive);

        if(ret) {
            return ResponseMsg.OK;
        }
        else {
            return ResponseMsg.FAIL;
        }
    }

    /**
     ************************************material   Consume   Controller**************************************
     */
    @RequestMapping("/materialConsume/find")
    public String findMaterialConsume() {
        return "materialConsume_list";
    }

    /**
     * 分页查询所有的 物料消耗 信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/materialConsume/list")
    @ResponseBody
    public QueryVo<MaterialConsume> materialConsumeLsit(@RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "rows", defaultValue = "10") Integer pageSize){

        Integer num = pageNum>1 ? pageNum: 1;
        Integer size = pageSize>0 ? pageSize: 10;

        return  materialConsumeService.listMaterialConsumeByPage(num, size);
    }


    /**
     * function: 按条件分页查询
     * @param searchValue   查询的条件
     * @param name  materialId、consumeId、workId
     * @param pageNum
     * @param pageSize
     * @return json
     */
    @RequestMapping("materialConsume/search_materialConsume_by_{name}")
    @ResponseBody
    public QueryVo<MaterialConsume> searchConsume(String searchValue, @PathVariable(value = "name", required = true) String name,
                                                  @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                                  @RequestParam(value = "rows", defaultValue = "10") Integer pageSize){
        Integer num = pageNum>1 ? pageNum: 1;
        Integer size = pageSize>0 ? pageSize: 10;
        Page onePage = PageHelper.startPage(num,size,true);
        QueryVo<MaterialConsume> materialConsumesVo = null;
        if("materialId".equals(name)) {

            materialConsumesVo =  materialConsumeService.searchMaterialConsumeBymaterialId(searchValue,num, size);
        }
        if("consumeId".equals(name)) {
            materialConsumesVo = materialConsumeService.searchMaterialConsumeByConsumeId(searchValue,num,size);
        }
        if("workId".equals(name)) {
            materialConsumesVo = materialConsumeService.searchMaterialConsumeByWorkId(searchValue,num, size);
        }

        return materialConsumesVo;
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
     * function：添加 物料消耗 信息
     * @param materialConsume
     * @return class message parased to json
     */
    @RequestMapping(value = "materialConsume/insert",produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseMsg insertMaterialConsume(@Valid MaterialConsume materialConsume,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            String msg = "";
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                msg += fieldError.getDefaultMessage();
            }
            return new ResponseMsg(null,msg,"");
        }
        MaterialConsume select = materialConsumeService.findMaterialConsume(materialConsume.getConsumeId());

        if(select!=null) {
            return new ResponseMsg(null,"物料收入编号已存在，请重新输入","");
        }
        else {
            boolean b = materialConsumeService.addMaterialConsume(materialConsume);
            if (b) {
                return new ResponseMsg(200,"添加成功！","");

            }
            else{
                return new ResponseMsg(null,"添加失败！","");
            }
        }
    }

    @RequestMapping("/materialConsume/delete_judge")
    @ResponseBody
    public ResponseMsg initDeleteMaterialConsume() {
        ResponseMsg responseMsg = new ResponseMsg();
        return responseMsg;
    }

    /***
     * function: 批量删除 物料消耗
     * @param ids 要批量删除的id
     * @return
     */
    @RequestMapping("materialConsume/delete_batch")
    @ResponseBody
    public ResponseMsg deleteMaterialConsume(String[] ids) {
        boolean ret = materialConsumeService.deleteMaterialConsume(ids);
        if(ret) {
            return ResponseMsg.OK;
        }
        return ResponseMsg.FAIL;

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
     * 更新 物料消耗 信息
     * @param materialConsume
     * @return
     */
    @RequestMapping(value = {"/materialConsume/update_all","/materialConsume/update_note"})
    @ResponseBody
    public ResponseMsg updateMaterialConsume(MaterialConsume materialConsume) {
        boolean ret = materialConsumeService.updateMaterialConsume(materialConsume);
        if(ret) {
            return ResponseMsg.OK;
        }
        else {
            return ResponseMsg.FAIL;
        }
    }

}
