<%@ page import="java.util.List" %>
<%@ page import="cn.itcast.jsp.Category" %><%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 2019/11/9
  Time: 3:22 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <style>
    </style>
</head>
<body>
<ul>
    <%
        if (request.getAttribute("msg") != null) {
            List<Category> msg = (List<Category>) request.getAttribute("msg");
            for (Category category : msg) {
                System.out.println(category.toString());
                out.write("<li><a href=\"#\">");
                out.write(category.getName());
                out.write("</a></li>");
            }
        }
    %>
</ul>
</body>
</html>
