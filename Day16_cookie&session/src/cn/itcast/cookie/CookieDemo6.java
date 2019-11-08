package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie快速入门
 */
@WebServlet("/cookieDemo6")
public class CookieDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建cookie对象
        Cookie c1 = new Cookie("msg", "你好");//tomcat8之后可以存储中文
        c1.setPath("/");//设置同一个服务器，不同的项目之间共享cookie
        response.addCookie(c1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
