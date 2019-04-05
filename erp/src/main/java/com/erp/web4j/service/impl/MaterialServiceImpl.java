package com.erp.web4j.service.impl;

import com.erp.web4j.bean.Material;
import com.erp.web4j.mapper.MaterialMapper;
import com.erp.web4j.service.MaterialService;
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
 * ClassName: MaterialServiceImpl
 * Description:
 *
 * @author mighty
 * @version 1.0
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
    public Map<String, Object> listMaterialByPage(Integer pageNum, Integer pageSize) {
        /*分页设置*/
        Integer num = pageNum!=null ? pageNum:1;
        Integer size = pageSize!=null ? pageSize:10;
        Page onePage = PageHelper.startPage(num,size,true);

        Map<String, Object> map = new HashMap<>();
        List<Material> materials= materialMapper.selectAll();
        map.put("total",onePage.getTotal());
        map.put("rows",materials);
        return map;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public boolean deleteMaterials(String[] ids) {
        int results = materialMapper.deleteByPrimaryKeyBanch(ids);
        if(results>0) {
            return true;
        }
        else {
            return false;
        }
    }



    @Override
    public boolean updateMaterial(Material material) {
        int i = materialMapper.updateByPrimaryKeySelective(material);
        return i==1;
    }

    @Override
    public Map<String, Object> searchMaterialById(String searchValue, Integer pageNum, Integer pageSize) {
        Integer num = pageNum!=null ? pageNum:1;
        Integer size = pageSize!=null ? pageSize:10;
        Page onePage = PageHelper.startPage(num,size,true);

        Map<String, Object> map = new HashMap<>();
        List<Material> materials= materialMapper.selectLikeID(searchValue);
        map.put("total",onePage.getTotal());
        map.put("rows",materials);
        return map;
    }

    @Override
    public Map<String, Object> searchMaterialByType(String searchValue, Integer pageNum, Integer pageSize) {
        Integer num = pageNum!=null ? pageNum:1;
        Integer size = pageSize!=null ? pageSize:10;
        Page onePage = PageHelper.startPage(num,size,true);

        Map<String, Object> map = new HashMap<>();
        List<Material> materials= materialMapper.selectByType(searchValue);
        map.put("total",onePage.getTotal());
        map.put("rows",materials);
        return map;
    }

    @Override
    public Material getMaterial(String materialId) {
        Material material = materialMapper.selectByPrimaryKey(materialId);
        return material;
    }

    @Override
    public List<Material> selectAllMaterials() {
        List<Material> materials = materialMapper.selectAll();
        return materials;
    }




}
