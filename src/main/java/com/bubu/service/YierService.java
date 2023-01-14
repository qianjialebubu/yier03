package com.bubu.service;

import com.bubu.pojo.PageBean;
import com.bubu.pojo.Yier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qjl
 * @create 2023-01-09 17:34
 */
public interface YierService {
    List<Yier> selectAll();
    void add(Yier yier);
    void deleteByIds(int[] ids);
    void deleteById(int id);
    PageBean<Yier> selectByPage(int currentPage,int pageSize);
    PageBean<Yier> selectByPageAndCondition(int currentPage,int pageSize,Yier yier);
    void update(Yier yier);
}
