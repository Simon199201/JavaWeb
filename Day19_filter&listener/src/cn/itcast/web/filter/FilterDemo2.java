package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/filterDemo2")
public class FilterDemo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo2来了...");
        chain.doFilter(req, resp);
        System.out.println("FilterDemo2执行了...");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
