package com.erp.web4j.service;

import com.erp.web4j.bean.DeviceCheck;
import com.erp.web4j.bean.DeviceFault;
import com.erp.web4j.bean.DeviceMaintain;

import java.util.List;

public interface DeviceCheckService {
    List<DeviceCheck> selectAllDeviceCheck();
    boolean insertSelective(DeviceCheck record);
    boolean updateByPrimaryKeySelective(DeviceCheck record);
    boolean deleteDeviceCheck(String[] ids);
    List<DeviceCheck> toSearchDeviceCheckById(String searchValue);
    List<DeviceCheck> toSearchDeviceCheckByDeviceName(String searchValue);
    List<DeviceFault> selectAllDeviceFault();
    boolean insert(DeviceFault record);
    boolean updateByPrimaryKeySelective(DeviceFault record);
    boolean deleteDeviceFault(String[] ids);
    List<DeviceFault> searchDeviceFault(String deviceFaultId);
    List<DeviceFault> searchDeviceFaultByDeviceName(String deviceName);
    List<DeviceMaintain> findAllDeviceMaintain();
    DeviceFault selectByPrimaryKey(String deviceFaultId);
    boolean insert(DeviceMaintain record);
    boolean updateByPrimaryKeySelective(DeviceMaintain record);
    boolean deleteDeviceMaintain(String[] ids);
    List<DeviceMaintain> searchDeviceMaintain(String searchValue);
    List<DeviceMaintain> toSearchDeviceMaintainByDeviceFaultId(String searchValue);

}
