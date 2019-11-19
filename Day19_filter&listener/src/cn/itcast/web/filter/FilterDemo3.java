package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")

public class FilterDemo3 implements Filter {
    /**
     * 服务器正常关闭后，会销毁
     */
    public void destroy() {
        System.out.println("destroy ...");
    }

    /**
     * 每一次请求被拦截资源时，会执行一次，
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter ...");
        chain.doFilter(req, resp);
    }

    /**
     * 服务器启动后，会创建Filter对象，然后调用init方法
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init ... ");
    }

}
