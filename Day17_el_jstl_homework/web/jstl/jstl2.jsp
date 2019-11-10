<%@ page import="cn.itcast.Person" %><%--
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
    <title>大小判断</title>
</head>
<body>
【代码题】
根据已知数据使用jstl标签判断对象是否为空
<%
    Person p1 = new Person();
    p1.setName("jack");
    p1.setValue("abcd");
    Person p2 = null;
    request.setAttribute("p1", p1);
    request.setAttribute("p2", p2);
%>

<c:if test="${not empty p1}">
    p1不为空
</c:if>
<c:if test="${empty p1}">
    p1为空
</c:if>



<c:if test="${not empty p2}">
    p2不为空
</c:if>
<c:if test="${empty p2}">
    p2为空
</c:if>


</body>
</html>
