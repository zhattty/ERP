package com.erp.web4j.service.impl;

import com.erp.web4j.bean.Material;
import com.erp.web4j.bean.MaterialReceive;
import com.erp.web4j.bean.QueryVo;
import com.erp.web4j.mapper.MaterialMapper;
import com.erp.web4j.service.MaterialService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName: MaterialServiceImpl
 * Description:
 *
 * @author mighty
 * @version 3.0
 * @date 2019/4/3  22:35
 */
@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialMapper materialMapper;


    @Override
    public boolean addMaterial(Material material) {
        int insert = materialMapper.insert(material);
        return insert==1;
    }

    @Override
    public QueryVo<Material> listMaterialByPage(Integer pageNum, Integer pageSize) {

        QueryVo<Material> queryVo = new QueryVo<>();
        Page onePage = PageHelper.startPage(pageNum,pageSize,true);
        List<Material> materials= materialMapper.selectAll();
        /*包装*/
        queryVo.setTotal((int)onePage.getTotal());
        queryVo.setRows(materials);
        return queryVo;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public boolean deleteMaterials(String[] ids) {
        int results = materialMapper.deleteByPrimaryKeyBanch(ids);
        return results>0;
    }



    @Override
    public boolean updateMaterial(Material material) {
        int i = materialMapper.updateByPrimaryKeySelective(material);
        return i==1;
    }

   @Override
   public QueryVo<Material> searchMaterialById(String searchValue, Integer pageNum, Integer pageSize) {

       QueryVo<Material> queryVo = new QueryVo<>();
       Page onePage = PageHelper.startPage(pageNum,pageSize,true);
       List<Material> materials = materialMapper.selectLikeID(searchValue);
       /*包装*/
       queryVo.setTotal((int)onePage.getTotal());
       queryVo.setRows(materials);
       return queryVo;
   }

    @Override
    public QueryVo<Material> searchMaterialByType(String searchValue, Integer pageNum, Integer pageSize) {
        QueryVo<Material> queryVo = new QueryVo<>();
        Page onePage = PageHelper.startPage(pageNum,pageSize,true);
        List<Material> materials = materialMapper.selectByType(searchValue);
        /*包装*/
        queryVo.setTotal((int)onePage.getTotal());
        queryVo.setRows(materials);
        return queryVo;
    }

    @Override
    public Material getMaterial(String materialId) {
        return materialMapper.selectByPrimaryKey(materialId);
    }

    @Override
    public List<Material> selectAllMaterials() {
        return materialMapper.selectAll();
    }




}
