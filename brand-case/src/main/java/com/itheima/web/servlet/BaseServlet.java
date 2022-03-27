/*package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//替换httpservlet，根据请求的最后一段路径进行方法分发
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求路径
        String uri=req.getRequestURI();
        //2.获取最后一段路径
        int index=uri.lastIndexOf('/');
        String methodName=uri.substring(index+1);
        //2.执行方法
        //2.1获取BrandServlet/UserServlet 字节码对象Class
        Class<? extends BaseServlet> cls=this.getClass();
        //2.2获取method方法
        try {
            Method method= cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //2.3执行方法
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}*/
