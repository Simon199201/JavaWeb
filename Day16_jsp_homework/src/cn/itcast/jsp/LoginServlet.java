package cn.itcast.jsp;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserDao userDao = new UserDao();
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        User login = userDao.login(loginUser);
        response.setContentType("text/html;charset=utf-8");

        if (login != null) {
            Cookie cookie = new Cookie("username", login.getUsername());
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
            response.getWriter().write("欢迎：" + login.getUsername());
        } else {
            response.getWriter().write("账户密码不匹配,请<a href='/day16/login.html' >重新登录</a>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
