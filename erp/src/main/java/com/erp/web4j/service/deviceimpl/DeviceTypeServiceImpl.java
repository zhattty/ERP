package com.erp.web4j.service.deviceimpl;

import com.erp.web4j.bean.Device;
import com.erp.web4j.bean.DeviceType;
import com.erp.web4j.mapper.DeviceMapper;
import com.erp.web4j.mapper.DeviceTypeMapper;
import com.erp.web4j.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {


    @Autowired
    DeviceTypeMapper deviceTypeMapper;
    @Override
    public List<DeviceType> selectAllDevice() {
        List<DeviceType> deviceTypes = deviceTypeMapper.selectAllDevice();
        return deviceTypes;
    }

    @Override
    public boolean insert(DeviceType record) {
        int insert = deviceTypeMapper.insert(record);
        if(insert == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateByPrimaryKey(DeviceType deviceType) {
        int i = deviceTypeMapper.updateByPrimaryKey(deviceType);
        return i==1;
    }

    @Override
    public boolean deleteByPrimaryKey(String[] deviceTypeIds) {
        int i = 0;
        for (String deviceTypeId : deviceTypeIds) {
            deviceTypeMapper.deleteByPrimaryKey(deviceTypeId);

            i++;
        }
        if(i == deviceTypeIds.length){
            return true ;
        }else {
            return  false;
        }


    }

    @Override
    public List<DeviceType> toSearchDeviceTypeList(String searchvalue) {
        List<DeviceType> deviceTypes = deviceTypeMapper.toSearchDeviceTypeList(searchvalue);

        return deviceTypes;
    }

    @Override
    public List<DeviceType> searchDeviceTypeName(String diviceTypeName) {
        List<DeviceType> deviceTypesList = deviceTypeMapper.searchDeviceTypeName(diviceTypeName);

        return deviceTypesList;
    }

    @Override
    public DeviceType selectByPrimaryKey(String deviceTypeId) {
        DeviceType deviceType = deviceTypeMapper.selectByPrimaryKey(deviceTypeId);
        return deviceType;
    }

    @Override
    public boolean updateByPrimaryKeySelective(DeviceType record) {
        int i = deviceTypeMapper.updateByPrimaryKey(record);
        return i == 1;
    }


}
