package com.erp.web4j.service.impl;

import com.erp.web4j.bean.MaterialReceive;

import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.mapper.MaterialReceiveMapper;
import com.erp.web4j.service.MaterialReceiveService;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public QueryVo<MaterialReceive> listMaterialReceiveByPage(Integer pageNum, Integer pageSize) {

        QueryVo<MaterialReceive> queryVo = new QueryVo<>();
        Page onePage = PageHelper.startPage(pageNum,pageSize,true);
        List<MaterialReceive> materials= materialReceiveMapper.selectAll();
        /*包装*/
        queryVo.setTotal((int)onePage.getTotal());
        queryVo.setRows(materials);
        return queryVo;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public boolean deleteMaterialReceives(String[] ids) {
        int results = materialReceiveMapper.deleteByPrimaryKeyBanch(ids);
        return results>0;
    }

    @Override
    public boolean updateMaterialReceive(MaterialReceive materialReceive) {
        int row = materialReceiveMapper.updateByPrimaryKeySelective(materialReceive);
        return row==1;
    }

    @Override
    public QueryVo<MaterialReceive> searchMaterialReceiveBymaterialId(String materialId, Integer pageNum, Integer pageSize) {

        QueryVo<MaterialReceive> queryVo = new QueryVo<>();
        Page onePage = PageHelper.startPage(pageNum,pageSize,true);
        List<MaterialReceive> materialReceives = materialReceiveMapper.selectLikeMaterialId(materialId);
        /*包装*/
        queryVo.setTotal((int)onePage.getTotal());
        queryVo.setRows(materialReceives);
        return queryVo;
    }

    @Override
    public QueryVo<MaterialReceive> searchMaterialReceiveByReceiveId(String receiveId, Integer pageNum, Integer pageSize) {

        QueryVo<MaterialReceive> queryVo = new QueryVo<>();
        Page onePage = PageHelper.startPage(pageNum,pageSize,true);
        List<MaterialReceive> materialReceives = materialReceiveMapper.selectLikePrimaryKey(receiveId);
        /*包装*/
        queryVo.setTotal((int)onePage.getTotal());
        queryVo.setRows(materialReceives);
        return queryVo;

    }

    @Override
    public MaterialReceive findMaterialReceive(String receiveId) {
        return materialReceiveMapper.selectByPrimaryKey(receiveId);
    }
}
