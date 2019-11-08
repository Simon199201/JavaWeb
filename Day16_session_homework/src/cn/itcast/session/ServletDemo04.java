package cn.itcast.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletDemo04")
public class ServletDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        System.out.println("id is "+id);
        GoodsDao goodsDao = new GoodsDao();
        GoodBean result = goodsDao.query(id);
//        request.setAttribute("msg", request);
//        request.getRequestDispatcher("/")
        response.getWriter().write("<form action=\"/day16_session_homework/servletDemo05\" method=\"post\">");
//        response.getWriter().write("编号:<input type=\"text\"  value=\"" + id + "\">");
        response.getWriter().write("编号:<input type=\"text\" name=\"pid\" value='"+id+"'>");
        response.getWriter().write("<br/>");
        response.getWriter().write("名称:" + result.getPname());
        response.getWriter().write("<br/>");
        response.getWriter().write("简介:" + result.getPdesc());
        response.getWriter().write("<br/>");
        response.getWriter().write("价格:" + result.getPrice());
        response.getWriter().write("<br/>");
        response.getWriter().write("数量:<input type=\"text\" value=\"" + result.getNum() + "\">");
        response.getWriter().write("<br/>");
        response.getWriter().write("<input type=\"submit\" value = \"加入购物车\"></input>");
        response.getWriter().write("</form>");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
