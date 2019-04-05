package com.erp.web4j.service.impl;

import com.erp.web4j.bean.MaterialConsume;
import com.erp.web4j.mapper.MaterialConsumeMapper;
import com.erp.web4j.service.MaterialConsumeService;
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
 * ClassName: MaterialConsumeService
 * Description:
 *
 * @author mighty
 * @version 1.0
 * @date 2019/4/4  23:59
 */
@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {
    @Autowired
    MaterialConsumeMapper materialConsumeMapper;

    @Override
    public boolean addMaterialConsume(MaterialConsume materialConsume) {
        int i = materialConsumeMapper.insertSelective(materialConsume);
        return i==1;
    }

    @Override
    public List<MaterialConsume> listMaterialConsumeByPage(Integer pageNum, Integer pageSize) {

        List<MaterialConsume> materialConsumes= materialConsumeMapper.selectAll();

        return materialConsumes;
    }

    @Override
    public List<MaterialConsume> searchMaterialConsumeBymaterialId(String materialId, Integer pageNum, Integer pageSize) {

        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectBymaterialId(materialId, pageNum, pageSize);

        return materialConsumes;

    }

    @Override
    public List<MaterialConsume> searchMaterialConsumeByConsumeId(String consumeId, Integer pageNum, Integer pageSize) {

        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectByConsumeId(consumeId, pageNum, pageSize);

        return materialConsumes;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public boolean deleteMaterialConsume(String[] ids) {
        int ret = materialConsumeMapper.deleteByPrimaryKeyBantch(ids);
        return ret>0;
    }

    @Override
    public boolean updateMaterialConsume(MaterialConsume materialConsume) {
        int ret =  materialConsumeMapper.updateByPrimaryKeySelective(materialConsume);
        return ret==1;
    }

    @Override
    public List<MaterialConsume> searchMaterialConsumeByWorkId(String workId, Integer pageNum, Integer pageSize) {

        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectByWorkId(workId, pageNum, pageSize);
        return materialConsumes;
    }

    @Override
    public MaterialConsume findMaterialConsume(String consumeId) {
        MaterialConsume materialConsume = materialConsumeMapper.selectByPrimaryKey(consumeId);
        return materialConsume;
    }
}
