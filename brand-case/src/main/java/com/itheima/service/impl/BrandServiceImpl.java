package com.itheima.service.impl;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    //1.创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory= SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        //2.获取SqlSession对象
        SqlSession sqlSession=factory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        List<Brand> brands=mapper.selectALl();
        //5.释放资源
        sqlSession.close();

        return brands;
    }

    @Override
    public void add(Brand brand) {
        SqlSession sqlSession=factory.openSession();
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        mapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Brand selectOne(Integer id) {
        SqlSession sqlSession=factory.openSession();
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        Brand brand=mapper.selectOne(id);
        sqlSession.close();
        return brand;
    }

    @Override
    public void upadteOne(Brand brand) {
        SqlSession sqlSession=factory.openSession();
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        mapper.updateOne(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession=factory.openSession();
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession=factory.openSession();
        BrandMapper mapper=sqlSession.getMapper(BrandMapper.class);
        //1.计算开始索引
        int begin=(currentPage-1)*pageSize;
        //2.计算查询条目
        int size=pageSize;

        List<Brand> rows=mapper.selectByPage(begin,size);
        int totalCount=mapper.selectTotalCount();
        PageBean<Brand> pageBean=new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        sqlSession.close();

        return pageBean;
    }

}
