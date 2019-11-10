<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="cn.itcast.Person" %><%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 2019/11/10
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--【代码题】--%>
<%--已知对象数据通过el标签判断对象是否为null--%>

<%
    Person p1=new Person();
    Person p2=null;
    request.setAttribute("p1", p1);
    request.setAttribute("p2", p2);
%>
${empty p1}
${empty p2}
</body>
</html>
