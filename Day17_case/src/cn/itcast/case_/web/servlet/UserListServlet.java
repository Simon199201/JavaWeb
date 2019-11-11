package cn.itcast.case_.web.servlet;

import cn.itcast.case_.domain.User;
import cn.itcast.case_.domain.impl.UserListServiceImpl;
import cn.itcast.case_.service.UserListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserListService userListService = new UserListServiceImpl();
        List<User> allUser = userListService.findAllUser();
        request.setAttribute("users", allUser);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
