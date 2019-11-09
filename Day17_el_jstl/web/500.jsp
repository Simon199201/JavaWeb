<%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 2019/11/9
  Time: 2:18 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>服务器正忙</title>
</head>
<body>
服务器正忙...
<% out.print(exception.getMessage()); %>
</body>
</html>
