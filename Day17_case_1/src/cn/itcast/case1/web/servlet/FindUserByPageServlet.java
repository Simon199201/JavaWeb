package cn.itcast.case1.web.servlet;


import cn.itcast.case1.domain.PageBean;
import cn.itcast.case1.domain.User;
import cn.itcast.case1.service.UserService;
import cn.itcast.case1.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Map<String, String[]> parameterMap = request.getParameterMap();
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if (currentPage == null || currentPage.equals("")) {
            currentPage = "1";
        }
        if (rows == null || rows.equals("")) {
            rows = "5";
        }
        //1.调用UserService完成查询
        UserService service = new UserServiceImpl();
        PageBean<User> pageBean = service.findUserByPage(currentPage,rows,parameterMap);
        //2.将list存入request域
        request.setAttribute("pb",pageBean);
        request.setAttribute("condition",parameterMap);
        //3.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
