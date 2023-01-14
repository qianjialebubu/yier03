package com.bubu.web.servlet;

import com.alibaba.fastjson.JSON;
import com.bubu.pojo.PageBean;
import com.bubu.pojo.Yier;
import com.bubu.service.YierService;
import com.bubu.service.impl.YierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author qjl
 * @create 2023-01-14 0:26
 */
@WebServlet("/yier/*")
public class YierServlet extends BaseServlet{
    private YierService yierService = new YierServiceImpl();
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Yier> yiers = yierService.selectAll();
        String string = JSON.toJSONString(yiers);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(string);

    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        Yier yier = JSON.parseObject(params, Yier.class);
//        System.out.println(yier);
        yierService.add(yier);
        resp.getWriter().write("success");

    }

    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        int[] ids = JSON.parseObject(params, int[].class);

        yierService.deleteByIds(ids);
        resp.getWriter().write("success");

    }
    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        BufferedReader reader = req.getReader();
        String params = reader.readLine();


        int id = JSON.parseObject(params, int.class);
//        System.out.println(id);
        yierService.deleteById(id);
//        String sid = req.getParameter("id");
//        //convert to int
//        System.out.println(sid);
//        int id = Integer.parseInt(sid);
//        yierService.deleteById(id);

        resp.getWriter().write("success");

    }

    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        System.out.println(_currentPage);
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        PageBean<Yier> yierPageBean = yierService.selectByPage(currentPage, pageSize);
        String string = JSON.toJSONString(yierPageBean);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(string);

    }

    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        BufferedReader br = req.getReader();
        String params = br.readLine();//json字符串

        //转为 Brand
        Yier yier = JSON.parseObject(params, Yier.class);
        System.out.println(yier);
//        params=new String(params.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(yier);
        PageBean<Yier> yierPageBean = yierService.selectByPageAndCondition(currentPage, pageSize,yier);
        String string = JSON.toJSONString(yierPageBean);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(string);

    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // solve garbled char problem first
        req.setCharacterEncoding("utf-8");
        //get params in JSON from req
        BufferedReader reader = req.getReader();
        String params = reader.readLine();//no matter how long, it is one line
        //get a brand ob from json
        Yier yier = JSON.parseObject(params, Yier.class);
        //invoke update method put brand in ()
        yierService.update(yier);

        //till now no problem, resp a bingo
        resp.getWriter().write("success");

    }



}
