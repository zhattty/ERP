package com.erp.web4j.service.impl;

import com.erp.web4j.bean.MaterialConsume;
import com.erp.web4j.bean.MaterialReceive;
import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.mapper.MaterialConsumeMapper;
import com.erp.web4j.service.MaterialConsumeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public QueryVo<MaterialConsume> listMaterialConsumeByPage(Integer pageNum, Integer pageSize) {

        QueryVo<MaterialConsume> queryVo = new QueryVo<>();
        Page onePage = PageHelper.startPage(pageNum,pageSize,true);
        List<MaterialConsume> materialConsumes= materialConsumeMapper.selectAll();
        /*包装*/
        queryVo.setTotal((int)onePage.getTotal());
        queryVo.setRows(materialConsumes);
        return queryVo;

    }

    @Override
    public QueryVo<MaterialConsume> searchMaterialConsumeBymaterialId(String materialId, Integer pageNum, Integer pageSize) {

        QueryVo<MaterialConsume> queryVo = new QueryVo<>();
        Page onePage = PageHelper.startPage(pageNum,pageSize,true);
        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectBymaterialId(materialId, pageNum, pageSize);
        /*包装*/
        queryVo.setTotal((int)onePage.getTotal());
        queryVo.setRows(materialConsumes);
        return queryVo;


    }

    @Override
    public QueryVo<MaterialConsume> searchMaterialConsumeByConsumeId(String consumeId, Integer pageNum, Integer pageSize) {

        QueryVo<MaterialConsume> queryVo = new QueryVo<>();
        Page onePage = PageHelper.startPage(pageNum,pageSize,true);
        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectByConsumeId(consumeId, pageNum, pageSize);
        /*包装*/
        queryVo.setTotal((int)onePage.getTotal());
        queryVo.setRows(materialConsumes);
        return queryVo;

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
    public QueryVo<MaterialConsume> searchMaterialConsumeByWorkId(String workId, Integer pageNum, Integer pageSize) {

        QueryVo<MaterialConsume> queryVo = new QueryVo<>();
        Page onePage = PageHelper.startPage(pageNum,pageSize,true);
        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectByWorkId(workId, pageNum, pageSize);
        /*包装*/
        queryVo.setTotal((int)onePage.getTotal());
        queryVo.setRows(materialConsumes);
        return queryVo;
    }

    @Override
    public MaterialConsume findMaterialConsume(String consumeId) {
        return materialConsumeMapper.selectByPrimaryKey(consumeId);
    }
}
