package cn.itcast.case1.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1、强制转化
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        //2、获取动态代理对象
        HttpServletRequest proxy_req = (HttpServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")) {
                    String value = (String) method.invoke(req, args);
                    System.out.println("before : "+value);
                    for (String word : list) {
                        if (value.contains(word)) {
                            value = value.replaceAll(word, "***");
                        }
                    }
                    System.out.println("after : "+value);
                    return value;
                }
                return method.invoke(req,args);
            }
        });
        //
        chain.doFilter(proxy_req, resp);
    }

    private List<String> list = new ArrayList<>();

    public void init(FilterConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(realPath));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(list);
    }

}
