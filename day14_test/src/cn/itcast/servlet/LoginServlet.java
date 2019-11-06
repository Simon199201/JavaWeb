package cn.itcast.servlet;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);
        UserDao userDao = new UserDao();
        try {
            BeanUtils.populate(loginUser, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        User result = userDao.login(loginUser);
        if (result != null) {
            //登录成功
            request.setAttribute("user",result);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/successServlet");
            requestDispatcher.forward(request,response);
        } else {
            //登录失败
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/failServlet");
            requestDispatcher.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
