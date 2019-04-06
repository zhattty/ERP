package com.erp.web4j.service.impl;

import com.erp.web4j.bean.Process;
import com.erp.web4j.mapper.ProcessMapper;
import com.erp.web4j.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/5 Time 16:22
 */
@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    ProcessMapper processMapper;

    @Override
    public Integer countOrderRecords() {
        return processMapper.countOrderRecords();
    }

    @Override
    public List<Process> searchByPrimaryKey(Integer page, Integer rows) {
        return processMapper.searchByPrimaryKey(page,rows);
    }

    @Override
    public boolean insert(Process process) {
        return processMapper.insert(process)==1;
    }

    @Override
    public boolean update(Process process) {
        return processMapper.updateByPrimaryKey(process)==1;
    }

    @Override
    public boolean deleteBatch(int[] ids) {
        Integer i = processMapper.deleteBatch(ids);
        if(i==ids.length){
            return true;
        }
        return false;
    }

    @Override
    public List<Process> searchByPrimaryKey2(String searchValue, Integer page, Integer rows) {
        return processMapper.searchByPrimaryKey2(searchValue,page,rows);
    }

    @Override
    public List<Process> searchByTechnologyId(String searchValue, Integer page, Integer rows) {
        return processMapper.searchByTechnologyId(searchValue,page,rows);
    }
}
