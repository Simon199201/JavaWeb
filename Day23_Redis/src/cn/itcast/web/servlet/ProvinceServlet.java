package cn.itcast.web.servlet;

import cn.itcast.service.ProvinceService;
import cn.itcast.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProvinceService service = new ProvinceServiceImpl();
        String allJson = service.getAllJson();
        System.out.println("json is "+allJson);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(allJson);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
