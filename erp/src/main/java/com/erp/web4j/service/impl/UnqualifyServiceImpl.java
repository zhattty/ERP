package com.erp.web4j.service.impl;

import com.erp.web4j.bean.UnqualifyApply;
import com.erp.web4j.mapper.UnqualifyApplyMapper;
import com.erp.web4j.service.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Yana
 * Date 2019/4/4 Time 11:20
 */
@Service("unqualityService")
public class UnqualifyServiceImpl implements UnqualifyService {

    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;

    @Override
    public ArrayList<UnqualifyApply> queryUnqualifyApply(Integer page, Integer rows) {
        return unqualifyApplyMapper.queryUnqualifyApply((page-1)*rows,rows);
    }

    @Override
    public Integer countUnqualifyRecords() {
        return unqualifyApplyMapper.countUnqualifyRecords();
    }

    @Override
    public int insertUnqualifyApply(UnqualifyApply unqualifyApply) {

        int insert = unqualifyApplyMapper.insertSelective(unqualifyApply);
        return insert;
    }

    @Override
    public int updateUnqualifyApply(UnqualifyApply unqualifyApply) {
        int update = unqualifyApplyMapper.updateByPrimaryKeySelective(unqualifyApply);
        return update;
    }

    @Override
    public int deleteUnqualifyApply(int[] ids) {

       return unqualifyApplyMapper.deleteByIds(ids);

    }

    @Override
    public int countUnqualifyRecordsById(String id) {

        return  unqualifyApplyMapper.countUnqualifyRecordsById(id);
    }

    @Override
    public ArrayList<UnqualifyApply> listUnqualifyApply(String searchValue, Integer page, Integer rows) {
        return unqualifyApplyMapper.listUnqualifyApply("%"+searchValue+"%",(page-1)*rows,rows);
    }

    @Override
    public ArrayList<UnqualifyApply> listUnqualifyApplyByProductName(String searchValue, Integer page, Integer rows) {
        return unqualifyApplyMapper.listUnqualifyApplyByProductName("%"+searchValue+"%",(page-1)*rows,rows);
    }

    @Override
    public int countUnqualifyRecordsByProductName(String searchValue) {
        return unqualifyApplyMapper.countUnqualifyRecordsByProductName(searchValue);
    }
}
