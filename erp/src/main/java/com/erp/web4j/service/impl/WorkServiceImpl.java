package com.erp.web4j.service.impl;

import com.erp.web4j.bean.Work;
import com.erp.web4j.mapper.WorkMapper;
import com.erp.web4j.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/5 Time 10:11
 */
@Service
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper workMapper;

    @Override
    public List<Work> listPageWork(Integer page, Integer rows) {
        return workMapper.listPageWork((page-1)*rows, rows);
    }

    @Override
    public int countAllRecords(){

        return workMapper.countAllRecords();
    }

    @Override
    public int updateWorkById(Work work) {
        return workMapper.updateByPrimaryKeySelective(work);
    }

    @Override
    public int deleteWorkByIds(String[] ids) {
        return workMapper.deleteWorkByIds(ids);
    }

    @Override
    public List<Work> searchWorkById(String searchValue, Integer page, Integer rows) {
        return workMapper.listPageWorkById("%" + searchValue + "%", (page-1)*rows, rows);
    }

    @Override
    public int countWorkRecordsById(String searchValue) {
        return workMapper.countWorkRecordsById("%" + searchValue + "%");
    }

    @Override
    public List<Work> searchWorkByProcessId(String searchValue, Integer page, Integer rows) {
        return workMapper.listPageWorkByProcessId("%" + searchValue + "%", (page-1)*rows, rows);
    }

    @Override
    public int countWorkRecordsByProcessId(String searchValue) {
        return workMapper.countWorkRecordsByProcessId("%" + searchValue + "%");
    }

    @Override
    public List<Work> searchWorkByProductName(String searchValue, Integer page, Integer rows) {
        return workMapper.listPageWorkByProductName("%" + searchValue + "%", (page-1)*rows, rows);
    }

    @Override
    public int countWorkRecordsByProductName(String searchValue) {
        return workMapper.countWorkRecordsByProductName("%" + searchValue + "%");
    }

    @Override
    public List<Work> searchWorkByDeviceName(String searchValue, Integer page, Integer rows) {
        return workMapper.listPageWorkByDeviceName("%" + searchValue + "%", (page-1)*rows, rows);
    }

    @Override
    public int countWorkRecordsByDeviceName(String searchValue) {
        return workMapper.countWorkRecordsByDeviceName("%" + searchValue + "%");
    }

    @Override
    public Work selectWorkById(String workId) {
        return workMapper.selectByPrimaryKey(workId);
    }

    @Override
    public List<Work> listWork() {
        return workMapper.listWork();
    }

    @Override
    public boolean checkWorkId(String workId) {
        return workMapper.countWorkRecordsByIdExplicit(workId) > 0;
    }

    @Override
    public int insertWork(Work work) {
        return workMapper.insert(work);
    }
}
