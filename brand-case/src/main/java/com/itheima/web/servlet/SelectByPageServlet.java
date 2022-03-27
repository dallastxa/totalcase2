package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectByPageServlet")
public class SelectByPageServlet extends HttpServlet {

    private BrandService brandService =new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收 当前页码和每页展示数
        String _currentPage=req.getParameter("currentPage");
        String _pageSize=req.getParameter("pageSize");

        int currentPage=Integer.parseInt(_currentPage);
        int pageSize=Integer.parseInt(_pageSize);

        //2.调用service查询
        PageBean<Brand> pageBean=brandService.selectByPage(currentPage,pageSize);

        //4.转为JSON
        String jsonString= JSON.toJSONString(pageBean);
        //5.写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
