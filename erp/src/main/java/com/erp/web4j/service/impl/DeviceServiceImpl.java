package com.erp.web4j.service.impl;

import com.erp.web4j.bean.Device;
import com.erp.web4j.mapper.DeviceMapper;
import com.erp.web4j.service.DeviceService;
import com.erp.web4j.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;
    @Override
    public List<Device> findDeviceList() {
        List<Device> deviceList = deviceMapper.findDeviceList();
        return deviceList;
    }

    @Override
    public List<Device> selectByDeviceTypeNameGetList(String deviceTypeName) {
        List<Device> devices = deviceMapper.selectByDeviceTypeNameGetList(deviceTypeName);

        return devices;
    }

    @Override
    public Device selectDeviceByDeviceName(String deviceName) {
        Device device = deviceMapper.selectDeviceByDeviceName(deviceName);
        return device;
    }

    @Override
    public List<Device> selectByPrimaryKeyGetList(String deviceId) {
        List<Device> devices = deviceMapper.selectByPrimaryKeyGetList(deviceId);

        return devices;
    }

    @Override
    public Device selectByPrimaryKey(String deviceId) {
        Device device = deviceMapper.selectByPrimaryKey(deviceId);

        return device;
    }

    @Override
    public boolean insert(Device record) {
        int insert = deviceMapper.insert(record);
        return insert == 1;
    }

    //sql in()
    @Override
    public boolean deleteByPrimaryKey(String[] deviceId) {
        int y = 0;
        for (String s : deviceId) {
             deviceMapper.deleteByPrimaryKey(s);
            y++;
        }
       if (y == deviceId.length){
           return true;
       }else{
           return false;

       }

    }

    @Override
    public boolean updateByPrimaryKeySelective(Device record) {
        int i = deviceMapper.updateByPrimaryKeySelective(record);
        return i == 1;
    }
}
