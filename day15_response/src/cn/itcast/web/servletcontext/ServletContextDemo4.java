package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo4")
public class ServletContextDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext1 = this.getServletContext();
        String realPath = servletContext1.getRealPath("/b");
        System.out.println(realPath);

        String realPath1 = servletContext1.getRealPath("WEB-INF/c.txt");
        System.out.println(realPath1);

        String realPath2 = servletContext1.getRealPath("WEB-INF/classes/a.txt");
        System.out.println(realPath2);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
