package cn.itcast.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/servletDemo05")
public class ServletDemo05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String pid = request.getParameter("pid");
        HashMap<String, GoodBean> car = (HashMap<String, GoodBean>) session.getAttribute("car");
        if (car == null) {
            car = new HashMap<>();
            session.setAttribute("car", car);
        }
        GoodsDao goodsDao = new GoodsDao();
        GoodBean result = goodsDao.query(pid);
        car.put(pid, result);
        response.getWriter().write("商品加入购物车成功");
        response.getWriter().write("<br/>");
        response.getWriter().write("<a href=\"demo01.html\">请继续浏览商品</a>");
        response.getWriter().write("<br/>");
        response.getWriter().write("<a href=\"/day16_session_homework/servletDemo06\">浏览购物车</a>\n");
//        String id = request.getParameter("id");
//        System.out.println("id is "+id);
//        GoodsDao goodsDao = new GoodsDao();
//        GoodBean result = goodsDao.query(id);
////        request.setAttribute("msg", request);
////        request.getRequestDispatcher("/")
//        response.getWriter().write("<form action=\"/day16_session_homework/servletDemo05\" method=\"post\">");
////        response.getWriter().write("编号:<input type=\"text\"  value=\"" + id + "\">");
//        response.getWriter().write("编号:<input type=\"text\" name=\"pid\" value='"+id+"'>");
//        response.getWriter().write("<br/>");
//        response.getWriter().write("名称:" + result.getPname());
//        response.getWriter().write("<br/>");
//        response.getWriter().write("简介:" + result.getPdesc());
//        response.getWriter().write("<br/>");
//        response.getWriter().write("价格:" + result.getPrice());
//        response.getWriter().write("<br/>");
//        response.getWriter().write("数量:<input type=\"text\" value=\"" + result.getNum() + "\">");
//        response.getWriter().write("<input type=\"submit\">加入购物车</input>");
//        response.getWriter().write("</form>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
