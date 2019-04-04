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
}
