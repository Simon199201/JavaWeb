<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 2019/11/10
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>运算符</title>

</head>
<body>
<%
    //判断字符串，集合，对象是否为空或者长度是否等于0
    request.setAttribute("str", null);
    request.setAttribute("list",new ArrayList<>());
%>

${not empty str}
${not empty list}
</body>
</html>
