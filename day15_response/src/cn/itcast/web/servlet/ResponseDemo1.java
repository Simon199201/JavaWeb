package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //访问ResponseDemo，自动跳转到/response demo2
        System.out.println("ResponseDemo1");
//        response.setStatus(302);
//        response.setHeader("location","/day15_response/responseDemo2");
        String contextPath = request.getContextPath();
        //有一种简单的重定向方法
        response.sendRedirect(contextPath+"/responseDemo2");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
