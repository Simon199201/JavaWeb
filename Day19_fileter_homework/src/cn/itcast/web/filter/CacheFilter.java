package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CacheFilter implements Filter {
    private FilterConfig filterConfig;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        String requestURI = httpRequest.getRequestURI();
        Integer expires = 0;
        if (requestURI.toLowerCase().endsWith(".png")) {
            expires = Integer.valueOf(filterConfig.getInitParameter("png"));
        } else if (requestURI.toLowerCase().endsWith(".css")) {
            expires = Integer.valueOf(filterConfig.getInitParameter("css"));
        } else if (requestURI.toLowerCase().endsWith(".js")) {
            expires = Integer.valueOf(filterConfig.getInitParameter("js"));
        }
        httpServletResponse.setDateHeader("expires", System.currentTimeMillis() + expires * 60 * 1000);
        chain.doFilter(httpRequest, httpServletResponse);
    }

    public void init(FilterConfig config) throws ServletException {
        filterConfig = config;
    }

}
