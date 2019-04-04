package com.erp.web4j.service.impl;

import com.erp.web4j.bean.Material;
import com.erp.web4j.bean.MaterialReceive;

import com.erp.web4j.mapper.MaterialReceiveMapper;
import com.erp.web4j.service.MaterialReceiveService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: MaterialReceiveServiceImpl
 * Description:
 *
 * @author mighty
 * @version 1.0
 * @date 2019/4/4  19:55
 */
@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {
    @Autowired
    MaterialReceiveMapper materialReceiveMapper;

    @Override
    public boolean addMaterialReceive(MaterialReceive materialReceive) {
        int i = materialReceiveMapper.insertSelective(materialReceive);
        return i==1;
    }

    @Override
    public Map<String, Object> listMaterialReceiveByPage(Integer pageNum, Integer pageSize) {
        Integer num = pageNum!=null ? pageNum:1;
        Integer size = pageSize!=null ? pageSize:10;
        Page onePage = PageHelper.startPage(num,size,true);

        Map<String, Object> map = new HashMap<>();
        List<MaterialReceive> materials= materialReceiveMapper.selectAll();
        map.put("total",onePage.getTotal());
        map.put("rows",materials);
        return map;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public boolean deleteMaterialReceives(String[] ids) {
        int results = materialReceiveMapper.deleteByPrimaryKeyBanch(ids);
        if(results>0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean updateMaterialReceive(MaterialReceive materialReceive) {
        int row = materialReceiveMapper.updateByPrimaryKeySelective(materialReceive);
        return row==1;
    }

    @Override
    public Map<String, Object> searchMaterialReceiveBymaterialId(String materialId, Integer pageNum, Integer pageSize) {
        Integer num = pageNum!=null ? pageNum:1;
        Integer size = pageSize!=null ? pageSize:10;
        Page onePage = PageHelper.startPage(num,size,true);

        Map<String, Object> map = new HashMap<>();
        List<MaterialReceive> materialReceives = materialReceiveMapper.selectLikeMaterialId(materialId);
        map.put("total",onePage.getTotal());
        map.put("rows",materialReceives);
        return map;
    }

    @Override
    public Map<String, Object> searchMaterialReceiveByReceiveId(String receiveId, Integer pageNum, Integer pageSize) {
        Integer num = pageNum!=null ? pageNum:1;
        Integer size = pageSize!=null ? pageSize:10;
        Page onePage = PageHelper.startPage(num,size,true);

        Map<String, Object> map = new HashMap<>();
        List<MaterialReceive> materialReceives = materialReceiveMapper.selectLikePrimaryKey(receiveId);
        map.put("total",onePage.getTotal());
        map.put("rows",materialReceives);
        return map;

    }
}
