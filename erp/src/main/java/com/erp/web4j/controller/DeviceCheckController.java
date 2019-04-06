package com.erp.web4j.controller;

import com.erp.web4j.bean.Device;
import com.erp.web4j.bean.DeviceCheck;
import com.erp.web4j.bean.DeviceFault;
import com.erp.web4j.bean.DeviceMaintain;
import com.erp.web4j.myutils.Message;
import com.erp.web4j.service.DeviceCheckService;
import com.erp.web4j.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceCheckController {
    @Autowired
    DeviceCheckService deviceCheckService;
    @Autowired
    DeviceService deviceService;
    @RequestMapping("device/deviceCheck")
    public String todeviceCheck(){
        return  "deviceCheck";
    }

    @RequestMapping("deviceCheck/list")
    @ResponseBody
    public List<DeviceCheck> toFindAllDeviceCheck(){
        List<DeviceCheck> deviceChecks = deviceCheckService.selectAllDeviceCheck();
        return  deviceChecks;

    }

    @RequestMapping("deviceList/get/{deviceId}")
    @ResponseBody
    public Device toFindADevice(@PathVariable("deviceId") String deviceId){
        Device device = deviceService.selectByPrimaryKey(deviceId);
        return device;
    }

    @RequestMapping("deviceList/update_all")
    @ResponseBody
    public Message toUpDate(Device device){
        boolean b = deviceService.updateByPrimaryKeySelective(device);
        Message message = new Message();
        if(b){
            message.setMsg("ok");
            message.setStatus(200);
        }
      return message;
    }

    @RequestMapping("deviceCheck/add")
    public String toDeviceAddJsp(){
        return "deviceCheck_add";
    }

    @RequestMapping("deviceCheck/insert")
    @ResponseBody
    public Message toInsertDeviceCheck(DeviceCheck deviceCheck){
        boolean b = deviceCheckService.insertSelective(deviceCheck);
        Message message = new Message();
        if(b){
            message.setMsg("ok");
            message.setStatus(200);
        }
        return message;
    }

    @RequestMapping("deviceCheck/edit")
    public String toDeviceEditJsp(){
        return "deviceCheck_edit";
    }

    @RequestMapping("deviceCheck/update")
    @ResponseBody
    public Message toUpdateDeviceCheck(DeviceCheck deviceCheck){
        boolean b = deviceCheckService.updateByPrimaryKeySelective(deviceCheck);
        Message message = new Message();
        if(b){
            message.setMsg("ok");
            message.setStatus(200);
        }
        return message;
    }

    @RequestMapping("deviceCheck/delete_batch")
    @ResponseBody
    public Message toDeleteDeviceCheck(String ids){
        String[] split = ids.split(",");
        boolean b = deviceCheckService.deleteDeviceCheck(split);
        Message message = new Message();
        if(b){
            message.setMsg("ok");
            message.setStatus(200);
        }
        return message;
    }

    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceCheckId")
    @ResponseBody
    public  List<DeviceCheck> toSearchDeviceCheckById(String searchValue){
        List<DeviceCheck> deviceChecks = deviceCheckService.toSearchDeviceCheckById(searchValue);
        return  deviceChecks;
    }

    /**
     * 还需测试
     **/
    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceName")
    @ResponseBody
    public  List<DeviceCheck> toSearchDeviceCheckByDeviceName(String searchValue){
        List<DeviceCheck> deviceChecks = deviceCheckService.toSearchDeviceCheckByDeviceName(searchValue);
        return  deviceChecks;

    }

    @RequestMapping("device/deviceFault")
    public  String toDeviceFaultJsp(){
        return  "deviceFault";
    }
    @RequestMapping("deviceFault/list")
    @ResponseBody
    public  List<DeviceFault> toFindAllDeviceFault(){
        List<DeviceFault> deviceFaults = deviceCheckService.selectAllDeviceFault();
        return  deviceFaults;

    }

    @RequestMapping("deviceFault/add")
    public  String toDeviceFaultAddJsp(){
        return  "deviceFault_add";
    }

    @RequestMapping("deviceFault/insert")
    @ResponseBody
    public Message toInsertDeviceFault(DeviceFault deviceFault){
        boolean insert = deviceCheckService.insert(deviceFault);
        Message message = new Message();
        if(insert){
            message.setStatus(200);
            message.setMsg("ok");
        }
        return  message;
    }

    @RequestMapping("deviceFault/edit")
    public  String toDeviceFaultEditJsp(){
        return  "deviceFault_edit";
    }

    @RequestMapping("deviceFault/update")
    @ResponseBody
    public Message toUpdateDeviceFault(DeviceFault deviceFault){
        boolean b = deviceCheckService.updateByPrimaryKeySelective(deviceFault);
        Message message = new Message();
        if(b){
            message.setStatus(200);
            message.setMsg("ok");
        }
        return  message;
    }

    @RequestMapping("deviceFault/delete_batch")
    @ResponseBody
    public Message toDeleteDeviceFault(String ids){
        String[] split = ids.split(",");
        boolean b = deviceCheckService.deleteDeviceFault(split);
        Message message = new Message();
        if(b){
            message.setStatus(200);
            message.setMsg("ok");
        }
        return  message;
    }

    @RequestMapping("deviceFault/search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public List<DeviceFault> toSearchDeviceFault(String searchValue){
        List<DeviceFault> deviceFault = deviceCheckService.searchDeviceFault(searchValue);
        return  deviceFault;

    }
    @RequestMapping("deviceFault/search_deviceFault_by_deviceName")
    @ResponseBody
    public List<DeviceFault> toSearchDeviceFaultByDeviceName(String searchValue){
        List<DeviceFault> deviceFaults = deviceCheckService.searchDeviceFaultByDeviceName(searchValue);
        return  deviceFaults;

    }
    @RequestMapping("device/deviceMaintain")
    public  String toDeviceMaintainJsp(){
        return  "deviceMaintain";
    }

    @RequestMapping("deviceMaintain/list")
    @ResponseBody
    public  List<DeviceMaintain> toFindAllDeviceMaintain(){
        List<DeviceMaintain> allDeviceMaintain = deviceCheckService.findAllDeviceMaintain();
        return allDeviceMaintain;
    }

    @RequestMapping("deviceFault/get/{value}")
    @ResponseBody
     public DeviceFault toFindADeviceFault(@PathVariable("value") String value){
        DeviceFault deviceFault = deviceCheckService.selectByPrimaryKey(value);
        return  deviceFault;
    }

    @RequestMapping("deviceFault/update_all")
    @ResponseBody
    public Message toUpdateDeviceFault1(DeviceFault deviceFault){
        boolean b = deviceCheckService.updateByPrimaryKeySelective(deviceFault);
        Message message = new Message();
        if(b){
            message.setStatus(200);
            message.setMsg("ok");
        }
        return  message;
    }

    @RequestMapping("deviceMaintain/add")
    public  String toDeviceMaintainAddJsp(){
        return  "deviceMaintain_add";
    }

    @RequestMapping("deviceFault/get_data")
    @ResponseBody
    public  List<DeviceFault> toFindDeviceFaultList(){
        List<DeviceFault> deviceFaults = deviceCheckService.selectAllDeviceFault();
        return  deviceFaults;
    }

    @RequestMapping("deviceMaintain/insert")
    @ResponseBody
    public  Message toInsertDeviceMainTain(DeviceMaintain deviceMaintain){
        boolean insert = deviceCheckService.insert(deviceMaintain);
        Message message = new Message();
        if(insert){
            message.setStatus(200);
            message.setMsg("ok");
        }
        return  message;
    }
    @RequestMapping("deviceMaintain/edit")
    public  String toDeviceMaintainEditJsp(){
        return  "deviceMaintain_edit";
    }

    @RequestMapping("deviceMaintain/update")
    @ResponseBody
    public Message toUpdateDeviceMaintain(DeviceMaintain deviceMaintain){
        boolean b = deviceCheckService.updateByPrimaryKeySelective(deviceMaintain);
        Message message = new Message();
        if(b){
            message.setStatus(200);
            message.setMsg("ok");
        }
        return  message;
    }

    @RequestMapping("deviceMaintain/delete_batch")
    @ResponseBody
    public Message toDeleteDeviceMaintain(String ids){
        String[] split = ids.split(",");
        boolean b = deviceCheckService.deleteDeviceMaintain(split);
        Message message = new Message();
        if(b){
            message.setStatus(200);
            message.setMsg("ok");
        }
        return  message;
    }

    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public  List<DeviceMaintain> toSearchDeviceMaintain(String searchValue){
        List<DeviceMaintain> deviceMaintains = deviceCheckService.searchDeviceMaintain(searchValue);
        return  deviceMaintains;
    }

    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public List<DeviceMaintain> toSearchDeviceMaintainByDeviceFaultId(String searchValue){
        List<DeviceMaintain> deviceMaintains = deviceCheckService.toSearchDeviceMaintainByDeviceFaultId(searchValue);
        return deviceMaintains;
    }
}
