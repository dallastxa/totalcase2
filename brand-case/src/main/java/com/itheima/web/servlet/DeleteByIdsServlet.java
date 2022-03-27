package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/deleteByIdsServlet")
public class DeleteByIdsServlet extends HttpServlet {

    private BrandService brandService =new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br=req.getReader();
        String params=br.readLine();

        int[] ids=JSON.parseObject(params,int[].class);
        brandService.deleteByIds(ids);
        resp.getWriter().write("success");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
