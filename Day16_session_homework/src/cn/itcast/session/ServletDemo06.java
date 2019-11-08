package cn.itcast.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

@WebServlet("/servletDemo06")
public class ServletDemo06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        HashMap<String, GoodBean> car = (HashMap<String, GoodBean>) session.getAttribute("car");
        if (car != null) {
            Set<String> strings = car.keySet();
            for (String key : strings) {
                GoodBean goodBean = car.get(key);
                response.getWriter().write("商品名称:" + goodBean.getPname() + "<br/>");
                response.getWriter().write("商品价格:" + goodBean.getPrice() + "<br/>");
                response.getWriter().write("商品数量:" + goodBean.getNum());
                response.getWriter().write("<br/>");
                response.getWriter().write("<br/>");
            }
        }
        response.getWriter().write("<a href=\"demo01.html\">请继续浏览商品</a>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
