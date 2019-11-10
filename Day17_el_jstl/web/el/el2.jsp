<%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 2019/11/10
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL获取域中的数据</title>
</head>
<body>
<%
    request.setAttribute("name", "张三");
    session.setAttribute("age", 19);
%>
${END}
<h3>获取值</h3>
${
        requestScope.name
        }
${
        sessionScope.age
        }
</body>
</html>
