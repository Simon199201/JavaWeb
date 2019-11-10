<%--
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
    <title>Choose标签</title>
</head>
<body>
<%--
数字编号对应的星期几

--%>
<%
    request.setAttribute("num", 3);
%>
<c:choose>
    <c:when test="${num==1}">星期一</c:when>
    <c:when test="${num==2}">星期二</c:when>
    <c:when test="${num==3}">星期三</c:when>
    <c:when test="${num==4}">星期四</c:when>
    <c:when test="${num==5}">星期五</c:when>
    <c:when test="${num==6}">星期六</c:when>
    <c:when test="${num==7}">星期日</c:when>
    <c:otherwise>输入有误</c:otherwise>
</c:choose>
</body>
</html>
