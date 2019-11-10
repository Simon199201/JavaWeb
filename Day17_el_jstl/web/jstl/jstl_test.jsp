<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 2019/11/10
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<%
    List list = new ArrayList();
    list.add(new User("张三", 18, new Date()));
    list.add(new User("李四", 28, new Date()));
    list.add(new User("王五", 38, new Date()));
    request.setAttribute("list", list);

%>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>出生年月</th>
    </tr>
    <c:forEach items="${list}" var="item" varStatus="s">
        <c:if test="${s.count%2==0}">
            <tr bgcolor="blue">
                <td>${s.count}</td>
                <td>${item.name}</td>
                <td>${item.age}</td>
                <td>${item.birDay}</td>
            </tr>
        </c:if>
        <c:if test="${s.count%2!=0}">
            <tr bgcolor="gray">
                <td>${s.count}</td>
                <td>${item.name}</td>
                <td>${item.age}</td>
                <td>${item.birDay}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
