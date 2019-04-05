package com.erp.web4j.service.impl;

import com.erp.web4j.bean.Technology;
import com.erp.web4j.bean.TechnologyPlan;
import com.erp.web4j.mapper.TechnologyMapper;
import com.erp.web4j.mapper.TechnologyPlanMapper;
import com.erp.web4j.service.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/5 Time 13:15
 * 工艺计划模块
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class TechnologyPlanServiceImpl implements TechnologyPlanService {
    @Autowired
    TechnologyPlanMapper technologyPlanMapper;


    @Override
    public Integer countOrderRecords() {
        return technologyPlanMapper.countOrderRecords();
    }

    @Override
    public List<TechnologyPlan> listOrders(Integer page, Integer rows) {
        return technologyPlanMapper.listOrders((page-1)*rows,rows);
    }

    @Override
    public boolean insert(TechnologyPlan technologyPlan) {
        int i = technologyPlanMapper.insert(technologyPlan);
        return i==1;
    }

    @Override
    public boolean update(TechnologyPlan technologyPlan) {
        return technologyPlanMapper.updateByPrimaryKey(technologyPlan)==1;
    }

    @Override
    public boolean deleteBatch(int[] ids) {
        int i = technologyPlanMapper.deleteBatch(ids);
        if(i==ids.length){
            return true;
        }
        return false;
    }

    @Override
    public List<TechnologyPlan> searchByPrimaryKey(String searchValue, Integer page, Integer rows) {
        return technologyPlanMapper.searchByPrimaryKey(searchValue,(page-1)*rows,rows);
    }

    @Override
    public List<TechnologyPlan> searchByName(String searchValue, Integer page, Integer rows) {
        return technologyPlanMapper.searchByName(searchValue,(page-1)*rows,rows);
    }


}
