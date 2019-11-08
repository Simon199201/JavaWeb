<%@ page import="cn.itcast.session.GoodBean" %><%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 2019/11/8
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>详情</title>
</head>
<body>
<form action="/day16_session_homework/servletDemo05" method="post">
编号:<input type="text" name="pid" value="">
名称:小米手环
<input type="submit">加入购物车</input>
    <a href="demo01.html">请继续浏览商品</a>
    <a href="/day16_session_homework/servletDemo06">浏览购物车</a>
</form>
</body>
</html>
