package com.bubu.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.bubu.pojo.Yier;
import com.bubu.service.YierService;
import com.bubu.service.impl.YierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author qjl
 * @create 2023-01-10 11:10
 */
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private YierService yierService = new YierServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Yier> yiers = yierService.selectAll();
        String string = JSON.toJSONString(yiers);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(string);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
