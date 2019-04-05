package com.erp.web4j.service.impl;

import com.erp.web4j.bean.Technology;
import com.erp.web4j.bean.TechnologyRequirement;
import com.erp.web4j.mapper.TechnologyMapper;
import com.erp.web4j.mapper.TechnologyRequirementMapper;
import com.erp.web4j.service.TechnologyRequirementService;
import com.erp.web4j.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/4 Time 10:11
 */
@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {

    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;

    @Autowired
    TechnologyMapper technologyMapper;

    /**
     * 在service层将 页码转成数据库偏移量，直接调用接口
     * @param page 页数
     * @param rows 行数
     * @return  CustomOrder的List，没有限制条件
     */
    @Override
    public List<TechnologyRequirement> listOrders(Integer page, Integer rows) {
        return technologyRequirementMapper.listOrders((page-1)*rows,rows);
    }

    /**
     * 统计该页面所有的记录数
     * @return
     */
    @Override
    public Integer countOrderRecords() {
        return technologyRequirementMapper.countOrderRecords();
    }

    @Override
    public boolean insert(TechnologyRequirement technologyRequirement) {
        int i = technologyRequirementMapper.insert(technologyRequirement);
        return i==1;
    }

    @Override
    public boolean update(TechnologyRequirement technologyRequirement) {
        int i = technologyRequirementMapper.updateByPrimaryKey(technologyRequirement);
        return i==1;
    }

    @Override
    public boolean deleteBatch(int[] ids) {
         int i = technologyRequirementMapper.deleteBatch(ids);
         if(i==ids.length){
             return true;
         }else {
             return false;
         }
    }

    @Override
    public List<Technology> searchByName(String searchValue, Integer page, Integer rows) {
        return technologyRequirementMapper.searchByName(searchValue,(page-1)*rows,rows);

    }

    @Override
    public List<Technology> searchByPrimaryKey(String searchValue, Integer page, Integer rows) {
        return technologyRequirementMapper.searchByPrimaryKey(searchValue,(page-1)*rows,rows);

    }

   /* @Override
    public List<Technology> findTechnology(Integer page, Integer rows) {
        return null;
    }*/

    @RequestMapping("edit_judge")
    @ResponseBody
    public String edit_judge(){
        return "";
    }

    @RequestMapping("edit")
    public String edit(){
        return "technologyRequirement_edit";
    }

}
