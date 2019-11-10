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
使用jstl标签进行0~10数据偶数的循环遍历输出
<c:forEach begin="0" end="10" var="i">
    <c:if test="${i%2==0}">
        <br/>
        ${i}为偶数
    </c:if>
</c:forEach>

</body>
</html>
