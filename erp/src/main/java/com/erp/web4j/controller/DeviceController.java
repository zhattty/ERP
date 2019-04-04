package com.erp.web4j.controller;

import com.erp.web4j.bean.DeviceType;
import com.erp.web4j.myutils.Message;
import com.erp.web4j.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller

public class DeviceController{
    @Autowired
    DeviceTypeService deviceTypeService;

    @RequestMapping("device/deviceType")
    public String toFindAllDevice(){
        return "deviceType";
    }

    @RequestMapping("deviceType/list")
    @ResponseBody
    public  List<DeviceType> findAllDevice(){
        List<DeviceType> deviceType = deviceTypeService.selectAllDevice();

       // model.addAttribute("deviceType",deviceTypes);
        return deviceType;
    }


    @RequestMapping("deviceType/add_judge")
    public String toAddDevice(){
        return "deviceType_add";
    }

    @RequestMapping("deviceType/add")
    public String toAddDevice1(){
        return "deviceType_add";
    }

@RequestMapping("deviceType/insert")
    @ResponseBody
    public Message  toInsertDevice(DeviceType record){
        boolean insert = deviceTypeService.insert(record);
        Message messager = new Message();
      if(insert){

          //ModelAndView model = new ModelAndView();
          messager.setMsg("OK");
          messager.setStatus(200);
          return messager;
      }else {
          messager.setMsg("删除失败");
          return messager;
      }

    }

    @RequestMapping("deviceType/edit_judge")
        public String toEditDevice(){
        return "deviceType_edit";
    }

    @RequestMapping("deviceType/edit")
    public String toAddDevice2(){
        return "deviceType_edit";
    }

    @RequestMapping("deviceType/update")
    @ResponseBody
    public String toUpdateDeviceType(DeviceType deviceType){
        boolean b = deviceTypeService.updateByPrimaryKey(deviceType);
        System.out.println("来自更新"+b);
        return "200";

    }

    @RequestMapping("deviceType/delete_judge")
    public String toDeleteDevice1(){
        return "deviceType";
    }

    @RequestMapping("deviceType/delete_batch")
    @ResponseBody
    public Message toDeleteDevice(String ids){

        String[] split = ids.split(",");
        boolean b = deviceTypeService.deleteByPrimaryKey(split);
        Message messager = new Message();
        //ModelAndView model = new ModelAndView();
        messager.setMsg("OK");
        messager.setStatus(200);
        return messager;

    }

    @RequestMapping("deviceType/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public List<DeviceType> toSearchDeviceTypeList(String searchValue){
        List<DeviceType> deviceTypeList = deviceTypeService.toSearchDeviceTypeList(searchValue);
        return  deviceTypeList;

    }

    @RequestMapping("deviceType/search_deviceType_by_deviceTypeName")
    @ResponseBody
    public List<DeviceType> toSearchDeviceTypeName(String searchValue){
        List<DeviceType> deviceTypeList = deviceTypeService.searchDeviceTypeName(searchValue);
        return  deviceTypeList;
    }



}
