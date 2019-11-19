package cn.itcast.case1.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1、强制转换req
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        //2、判断是否是登录相关的请求、css、js、font、图片，如果是，放行
        String requestURI = httpServletRequest.getRequestURI();
        if (requestURI.contains("/login.jsp") || requestURI.contains("loginServlet")|| requestURI.contains("/css/") || requestURI.contains("/js/")
                || requestURI.contains("/fonts/") || requestURI.contains(".png") || requestURI.contains("/checkCode")) {
            chain.doFilter(req, resp);
        } else {
            if (httpServletRequest.getSession().getAttribute("user") != null) {
                chain.doFilter(req, resp);
            } else {
                req.setAttribute("login_msg","请先登录");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
