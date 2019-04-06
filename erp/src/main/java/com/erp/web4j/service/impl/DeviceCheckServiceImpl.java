package com.erp.web4j.service.impl;

import com.erp.web4j.bean.DeviceCheck;
import com.erp.web4j.bean.DeviceFault;
import com.erp.web4j.bean.DeviceMaintain;
import com.erp.web4j.mapper.DeviceCheckMapper;
import com.erp.web4j.mapper.DeviceFaultMapper;
import com.erp.web4j.mapper.DeviceMaintainMapper;
import com.erp.web4j.service.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {
    @Autowired
    DeviceCheckMapper deviceCheckMapper;
    @Autowired
    DeviceFaultMapper deviceFaultMapper;
    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;

    @Override
    public boolean insertSelective(DeviceCheck record) {
        int insert = deviceCheckMapper.insert(record);
        return insert == 1;
    }

    @Override
    public List<DeviceCheck> toSearchDeviceCheckById(String searchValue) {
        List<DeviceCheck> deviceChecks = deviceCheckMapper.toSearchDeviceCheckById(searchValue);
        return deviceChecks;
    }

    @Override
    public List<DeviceFault> searchDeviceFault(String deviceFaultId) {
        List<DeviceFault> deviceFault = deviceFaultMapper.searchDeviceFault(deviceFaultId);
        return deviceFault;
    }

    @Override
    public List<DeviceMaintain> toSearchDeviceMaintainByDeviceFaultId(String searchValue) {
        List<DeviceMaintain> deviceMaintains = deviceMaintainMapper.toSearchDeviceMaintainByDeviceFaultId(searchValue);

        return deviceMaintains;
    }

    @Override
    public List<DeviceMaintain> searchDeviceMaintain(String searchValue) {
        List<DeviceMaintain> deviceMaintains = deviceMaintainMapper.searchDeviceMaintain(searchValue);

        return deviceMaintains;
    }

    @Override
    public boolean deleteDeviceMaintain(String[] ids) {
        int i = deviceMaintainMapper.deleteDeviceMaintain(ids);

        return i == 1 ;
    }

    @Override
    public boolean updateByPrimaryKeySelective(DeviceMaintain record) {
        int i = deviceMaintainMapper.updateByPrimaryKeySelective(record);
        return i == 1;
    }

    @Override
    public boolean insert(DeviceMaintain record) {
        int insert = deviceMaintainMapper.insert(record);
        return insert == 1;
    }

    @Override
    public DeviceFault selectByPrimaryKey(String deviceFaultId) {
        DeviceFault deviceFault = deviceFaultMapper.selectByPrimaryKey(deviceFaultId);

        return deviceFault;
    }

    @Override
    public List<DeviceMaintain> findAllDeviceMaintain() {
        List<DeviceMaintain> allDeviceMaintain = deviceMaintainMapper.findAllDeviceMaintain();
        return allDeviceMaintain;
    }

    @Override
    public List<DeviceFault> searchDeviceFaultByDeviceName(String deviceName) {
        List<DeviceFault> deviceFaults = deviceFaultMapper.searchDeviceFaultByDeviceName(deviceName);

        return deviceFaults;
    }

    @Override
    public boolean deleteDeviceFault(String[] ids) {
        int i = deviceFaultMapper.deleteDeviceFault(ids);
        return i == 1;
    }

    @Override
    public boolean updateByPrimaryKeySelective(DeviceFault record) {
        int i = deviceFaultMapper.updateByPrimaryKeySelective(record);
        return i == 1;
    }

    @Override
    public boolean insert(DeviceFault record) {
        int insert = deviceFaultMapper.insert(record);

        return insert == 1;
    }

    @Override
    public List<DeviceFault> selectAllDeviceFault() {
        List<DeviceFault> deviceFaults = deviceFaultMapper.selectAllDeviceFault();

        return deviceFaults;
    }

    @Override
    public List<DeviceCheck> toSearchDeviceCheckByDeviceName(String searchValue) {
        List<DeviceCheck> deviceChecks = deviceCheckMapper.toSearchDeviceCheckByDeviceName(searchValue);

        return deviceChecks ;
    }

    @Override
    public boolean deleteDeviceCheck(String[] ids) {
        int i = deviceCheckMapper.deleteDeviceCheck(ids);
        return i == 1;
    }

    @Override
    public boolean updateByPrimaryKeySelective(DeviceCheck record) {
        int i = deviceCheckMapper.updateByPrimaryKeySelective(record);
        return i == 1;
    }

    @Override
    public List<DeviceCheck> selectAllDeviceCheck() {
        List<DeviceCheck> deviceChecks = deviceCheckMapper.selectAllDeviceCheck();
        return deviceChecks ;
    }
}
