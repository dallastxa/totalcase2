package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    //查询所有
    @Select("select * from tb_brand;")
    @ResultMap("brandResultMap")
    List<Brand> selectALl();

    //添加数据
    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status});")
    void add(Brand brand);

    //查询一个
    @Select("select * from tb_brand where id=#{id};")
    @ResultMap("brandResultMap")
    Brand selectOne(int id);

    //更新数据
    @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status} where id=#{id}")
    void updateOne(Brand brand);

    //批量删除
    void deleteByIds(@Param("ids") int[] ids);

    //分页查询
    @Select("select * from tb_brand limit #{begin},#{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size);

    //查询总记录数
    @Select("select count(*) from tb_brand;")
    int selectTotalCount();
}
