package com.erp.web4j.service;

import com.erp.web4j.bean.Technology;
import com.erp.web4j.mapper.TechnologyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/3 Time 19:36
 */
public interface TechnologyService {

    /**
     *查询所有的technology，并且附带搜索功能
     * 此处未加上分页，后续应该可以操作
     */
    List<Technology> findTechnology(Integer page,Integer rows);

    List<Technology> searchByPrimaryKey(String  searchValue,Integer page,Integer rows);

    List<Technology> searchByName(String searchValue, Integer page, Integer rows);

    boolean insert(Technology technology);

    boolean update(Technology technology);

    boolean deleteBatch(int []ids);
}
