/*package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService =new BrandServiceImpl();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.调用service查询
        List<Brand> brands=brandService.selectAll();
        //2.转为JSON
        String jsonString= JSON.toJSONString(brands);
        //3.写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1.接收品牌数据
        BufferedReader br=req.getReader();
        String params=br.readLine();
        //转为Brand对象
        Brand brand=JSON.parseObject(params,Brand.class);
        //2.调用servlet添加
        brandService.add(brand);
        //3.响应成功的标识
        resp.getWriter().write("success");
    }
    public void selectOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br=req.getReader();
        String params=br.readLine();
        System.out.println(params);
        Integer id= JSON.parseObject(params,Integer.class);
        Brand brand=brandService.selectOne(id);
        String jsonString=JSON.toJSONString(brand);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

}*/
