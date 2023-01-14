package com.bubu.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author qjl
 * @create 2023-01-14 0:23
 */
//基础的servlet，进行方法的分发
public class BaseServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //1. 获取请求路径
    String uri = req.getRequestURI(); // /brand-case/brand/selectAll
//        System.out.println(uri);
    //2. 获取最后一段路径，方法名
    int index = uri.lastIndexOf('/');
    String methodName = uri.substring(index + 1); //  /selectAll? selectAll?
    System.out.println("----------------");
    System.out.println(methodName);

//        System.out.println(methodName);

    //2. 执行方法
    //2.1 获取BrandServlet /UserServlet 字节码对象 Class
    //System.out.println(this);

    Class<? extends BaseServlet> cls = this.getClass();
    //2.2 获取方法 Method对象
    try {
//        System.out.println(methodName);
        Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        //2.3 执行方法
        method.invoke(this,req,resp);
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    }


}
}
