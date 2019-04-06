package com.erp.web4j.service.impl;

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
    public List<MaterialReceive> listMaterialReceiveByPage(Integer pageNum, Integer pageSize) {

        List<MaterialReceive> materials= materialReceiveMapper.selectAll();
        return materials;
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
    public List<MaterialReceive> searchMaterialReceiveBymaterialId(String materialId, Integer pageNum, Integer pageSize) {

        List<MaterialReceive> materialReceives = materialReceiveMapper.selectLikeMaterialId(materialId);

        return materialReceives;
    }

    @Override
    public List<MaterialReceive> searchMaterialReceiveByReceiveId(String receiveId, Integer pageNum, Integer pageSize) {

        List<MaterialReceive> materialReceives = materialReceiveMapper.selectLikePrimaryKey(receiveId);

        return materialReceives;

    }

    @Override
    public MaterialReceive findMaterialReceive(String receiveId) {
        MaterialReceive materialReceive = materialReceiveMapper.selectByPrimaryKey(receiveId);
        return materialReceive;
    }
}
