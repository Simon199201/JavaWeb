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
    <title>if标签</title>
</head>
<body>
<%--
c:if标签
1.属性：
    * test：必须属性：接受boolean表达式
    * 如果true，则显示if标签体内容，如果为false，则不显示标签体内容

--%>
<%
    request.setAttribute("num", 3);
%>
<c:if test="true">
    我是真
</c:if>
<br/>
<c:if test="${num%2==0}">
    ${num%2}是偶数
</c:if>
<c:if test="${num%2!=0}">
    ${num%2}是奇数
</c:if>
</body>
</html>
