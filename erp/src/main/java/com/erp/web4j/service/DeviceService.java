package com.erp.web4j.service;

import com.erp.web4j.bean.Device;

import java.util.List;

public interface DeviceService {
    List<Device> findDeviceList();
    Device selectByPrimaryKey(String deviceId);
    boolean insert(Device record);
    boolean updateByPrimaryKeySelective(Device record);
    boolean deleteByPrimaryKey(String[] deviceId);
    List<Device> selectByPrimaryKeyGetList(String deviceId);
    Device selectDeviceByDeviceName(String deviceName);
    List<Device> selectByDeviceTypeNameGetList(String deviceTypeName);


}
