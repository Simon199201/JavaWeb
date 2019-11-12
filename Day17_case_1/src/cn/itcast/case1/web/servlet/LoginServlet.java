package cn.itcast.case1.web.servlet;

import cn.itcast.case1.domain.User;
import cn.itcast.case1.service.UserService;
import cn.itcast.case1.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1设置编码
        request.setCharacterEncoding("utf-8");
        //2获取验证码
        String vcode = request.getParameter("verifycode");
        //3校验验证码
        HttpSession session = request.getSession();
        if (session.getAttribute("CHECKCODE_SERVER") != null) {
            String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
            if (!checkcode_server.equalsIgnoreCase(vcode)) {
                request.setAttribute("login_msg", "验证码错误");
                request.getRequestDispatcher( "/login.jsp").forward(request, response);
                return;
            }
        } else {
            request.setAttribute("login_msg", "验证码错误");
            request.getRequestDispatcher( "/login.jsp").forward(request, response);
            return;
        }

        //获取用户信息
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserService userService = new UserServiceImpl();
        User loginUser = userService.findUser(user);
        if (loginUser != null) {
            response.sendRedirect(request.getContextPath() + "/userListServlet");
        } else {
            request.setAttribute("login_msg", "用户名或密码错误");
            request.getRequestDispatcher( "/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
