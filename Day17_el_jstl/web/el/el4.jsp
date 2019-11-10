<%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 2019/11/10
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el隐式对象</title>
</head>
<body>
${
        pageContext.request
        }
<br/>
<h4>动态获取虚拟目录</h4>
${
pageContext.request.contextPath
}
${"a"=="aa"}
<%--${"a"+"b"}--%>
</body>
</html>
