package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface BrandService {

    //查询所有
    List<Brand> selectAll();

    //添加数据
    void add(Brand brand);

    //展示一个数据
    Brand selectOne(Integer id);

    //更新数据
    void upadteOne(Brand brand);

    void deleteByIds(int[] ids);

    //分页查询
    PageBean<Brand> selectByPage(int currentPage,int pageSize);
}
