<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
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
<%--已知map集合数据通过el标签获取map集合中的key2的value值.--%>
<%
    Map map=new HashMap();
    map.put("key1", "aaa");
    map.put("key2", "bbb");
    application.setAttribute("msg", map);


%>
${msg.key2}
</body>
</html>
