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
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author qjl
 * @create 2023-01-12 16:20
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private YierService yierService = new YierServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        Yier yier = JSON.parseObject(params, Yier.class);
        yierService.add(yier);
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
