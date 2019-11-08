package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CookieDemo7")
public class CookieDemo7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)) {
                    flag = true;

                    String value = cookie.getValue();
                    System.out.println("解码前：" + value);
                    String decode = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后：" + decode);
                    response.getWriter().write("欢迎回来，您上次访问时间为：" + decode);


                    SimpleDateFormat sdf = new SimpleDateFormat("yy年MM月dd日 HH:mm:ss");
                    String format = sdf.format(new Date());
                    System.out.println("编码前的数据：" + format);
                    String encode = URLEncoder.encode(format, "utf-8");
                    System.out.println("编码后的数据:"+encode);
                    cookie.setValue(encode);
                    cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
                    response.addCookie(cookie);

                    break;
                }
            }
        }
        if (!flag) {
            //第一次访问
            SimpleDateFormat sdf = new SimpleDateFormat("yy年MM月dd日 HH:mm:ss");
            String format = sdf.format(new Date());
            System.out.println("编码前的数据：" + format);
            String encode = URLEncoder.encode(format, "utf-8");
            System.out.println("编码后的数据:"+encode);

            Cookie cookie = new Cookie("lastTime", encode);
            cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
            response.addCookie(cookie);
            response.getWriter().write("欢迎您首次访问");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
