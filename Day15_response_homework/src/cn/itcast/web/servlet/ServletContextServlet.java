package cn.itcast.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/servletContextServlet")
public class ServletContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
        ServletContext servletContext = this.getServletContext();
        HashSet<String> set = null;
        if (servletContext.getAttribute("host") != null) {
            set = (HashSet) servletContext.getAttribute("host");
            System.out.println(set);
        } else {
            set = new HashSet<>();
        }
        set.add(remoteAddr);
        servletContext.setAttribute("host", set);
        response.getWriter().write("欢迎使用我们的系统，您的IP是" + remoteAddr + "<br>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
