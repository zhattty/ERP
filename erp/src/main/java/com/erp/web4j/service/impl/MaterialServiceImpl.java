package com.erp.web4j.service.impl;

import com.erp.web4j.bean.Material;
import com.erp.web4j.mapper.MaterialMapper;
import com.erp.web4j.service.MaterialService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
