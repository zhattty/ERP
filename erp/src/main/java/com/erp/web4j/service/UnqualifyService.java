package com.erp.web4j.service;

import com.erp.web4j.bean.UnqualifyApply;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Yana
 * Date 2019/4/4 Time 11:20
 */
public interface UnqualifyService {

    ArrayList<UnqualifyApply> queryUnqualifyApply(Integer page, Integer rows);

    Integer countUnqualifyRecords();
}
