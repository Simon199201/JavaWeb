<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 2019/11/10
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>
<%--
数字编号对应的星期几

--%>
<%
    request.setAttribute("num", 3);
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list",list);
%>
<c:forEach begin="1" end="10" var="i" step="1" varStatus="s">
    ${i}<br/>
    ${s.index}
    <br/>
    ${s.count}
</c:forEach>

<br/>
<h3>遍历list</h3>
<c:forEach items="${list}" var="item" varStatus="s">
    ${item}
    <br/>
    ${s.index}
    <br/>
    ${s.count}
    <br/>
</c:forEach>
</body>
</html>
