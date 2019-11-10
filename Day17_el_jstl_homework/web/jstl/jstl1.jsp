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
    <title>大小判断</title>
</head>
<body>
<%
    request.setAttribute("num",109);
%>
<%--【代码题】--%>
<%--根据已知数据使用jstl标签对数据大小进行判断--%>
<c:if test="${num>100}">
    输入的数字大于100
</c:if>
<c:if test="${num<=100}">
    输入的数字小于等于100
</c:if>
</body>
</html>
