package com.erp.web4j.controller;

import com.erp.web4j.bean.Device;
import com.erp.web4j.bean.DeviceType;
import com.erp.web4j.myutils.Message;
import com.erp.web4j.service.DeviceService;
import com.erp.web4j.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    DeviceService deviceService;


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


   /* @RequestMapping("deviceType/add_judge")
    public String toAddDevice(){
        return "deviceType_add";
    }
*/
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

   /* @RequestMapping("deviceType/edit_judge")
        public String toEditDevice(){
        return "deviceType_edit";
    }*/

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

    /*@RequestMapping("deviceType/delete_judge")
    public String toDeleteDevice1(){
        return "deviceType";
    }
*/
    @RequestMapping("deviceType/delete_batch")
    @ResponseBody
    public Message toDeleteDevice(String ids){

        String[] split = ids.split(",");
        boolean b = deviceTypeService.deleteByPrimaryKey(split);
        Message messager = new Message();
        //ModelAndView model = new ModelAndView();
        if(b){
            messager.setMsg("OK");
            messager.setStatus(200);
        }
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

    @RequestMapping("device/deviceList")
     public String toDeviceList(){
        return "deviceList";
    }

    @RequestMapping("deviceList/list")
    @ResponseBody
    public List<Device> toFindDeviceList(){
        List<Device> deviceList = deviceService.findDeviceList();
        return deviceList;
    }

    @RequestMapping("deviceType/get/{deviceTypeId}")
    @ResponseBody
    public DeviceType toFindDeviceList(@PathVariable("deviceTypeId") String deviceTypeId){
        DeviceType deviceType = deviceTypeService.selectByPrimaryKey(deviceTypeId);
        return deviceType;
    }

    @RequestMapping("deviceType/update_all")
    @ResponseBody
    public Message toUpdateDeviceTypeFromDeviceList(DeviceType deviceType){
        boolean b = deviceTypeService.updateByPrimaryKey(deviceType);
        Message message = new Message();
        if(b){
            message.setMsg("");
            message.setStatus(200);
            return  message;
        }else {
            message.setMsg("更新失败");
            return message;
        }
    }

   /* @RequestMapping("employee/get/{empId}")
    @ResponseBody
    public DeviceType toFindDeviceKeeperMessage(@PathVariable("deviceTypeId") String empId){
       // DeviceType deviceType = deviceTypeService.selectByPrimaryKey(empId);
        //return deviceType;
    }*/
   @RequestMapping("deviceList/add")
   public String toAddDeviceList(){
       return "deviceList_add";
   }

   /**
    * 需要employee接口有待测试.....
    *
    * */
   @RequestMapping("deviceList/insert")
    @ResponseBody
    public Message addDevice(Device device){
       boolean insert = deviceService.insert(device);
       Message message = new Message();
       if(insert){
           message.setStatus(200);
           return  message;
       }else {
           message.setMsg("错误");
           return  message;
       }

   }

    @RequestMapping("deviceList/edit")
    public String toEditDeviceList(){
        return "deviceList_edit";
    }

    /**
     * 需要employee接口有待测试.....
     *
     * */
    @RequestMapping("deviceList/update")
    @ResponseBody
    public  Message updateDevice(Device device){
        boolean b = deviceService.updateByPrimaryKeySelective(device);
        Message message = new Message();
        if(b){
            message.setStatus(200);
            return message;
        }else {
            message.setMsg("错误");
            return message;
        }
    }

    @RequestMapping("deviceList/delete_batch")
    @ResponseBody
    public Message toDeleteDevice2(String ids){

        String[] split = ids.split(",");
        boolean b = deviceService.deleteByPrimaryKey(split);
        Message messager = new Message();
        if(b){
            messager.setMsg("OK");
            messager.setStatus(200);
        }
        return messager;

    }

    /*@RequestMapping("deviceList/search_device_by_deviceId")
    @ResponseBody
    public Device toSearchDeviceByDeviceId(String searchValue) {
        Device device = deviceService.selectByPrimaryKey(searchValue);
        return device;
    }*/
    @RequestMapping("deviceList/search_device_by_deviceId")
    @ResponseBody
    public List<Device> toSearchDeviceByDeviceId(String searchValue) {
        List<Device> devices = deviceService.selectByPrimaryKeyGetList(searchValue);
        return devices;
    }

    @RequestMapping("deviceList/search_device_by_deviceName")
    @ResponseBody
    public Device toSearchDeviceByDeviceName(String searchValue){
        Device device = deviceService.selectDeviceByDeviceName(searchValue);
        return device;
    }

    @RequestMapping("deviceList/search_device_by_deviceTypeName")
    @ResponseBody
    public List<Device> toSearchDeviceByDeviceTypeName(String searchValue){
        List<Device> devices = deviceService.selectByDeviceTypeNameGetList(searchValue);
        return  devices;
    }

    @RequestMapping("deviceList/get_data")
    @ResponseBody
    public List<Device> toSearchDeviceListForZY(){
        List<Device> deviceList = deviceService.findDeviceList();
        return  deviceList;
    }

    @RequestMapping("deviceType/get_data")
    @ResponseBody
    public  List<DeviceType> toDeviceTypeListForMe(){
        List<DeviceType> deviceTypes = deviceTypeService.selectAllDevice();
        return  deviceTypes;
    }
















}
