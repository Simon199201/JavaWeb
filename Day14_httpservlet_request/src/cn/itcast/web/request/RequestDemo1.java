package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("获取请求行");

        String method = request.getMethod();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();
        String protocol = request.getProtocol();
        String remoteAddr = request.getRemoteAddr();

        System.out.println(method);
        System.out.println(contextPath);
        System.out.println(servletPath);
        System.out.println(requestURI);
        System.out.println(requestURL);
        System.out.println(queryString);
        System.out.println(protocol);
        System.out.println(remoteAddr);

    }
}
