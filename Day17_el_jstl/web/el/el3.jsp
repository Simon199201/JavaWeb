<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 2019/11/10
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取对象</title>
</head>
<body>
<%
    User user = new User();
    user.setName("张三");
    user.setAge(18);
    user.setBirthday(new Date());

    request.setAttribute("u", user);

//    list
    List list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    list.add(user);
    request.setAttribute("list", list);

    Map map = new HashMap<>();
    map.put("sname", "王五");
    map.put("gender", "男");
    map.put("user", user);
    request.setAttribute("map", map);


%>
<h3>获取对象中的值</h3>
${requestScope.u}
<br/>
<%--通过对象的属性获取值  setter , getter，去掉set，get，，然后首字母变小写--%>
${requestScope.u.name}
<br/>
${requestScope.u.age}
<br/>
${requestScope.u.birthday}
<br/>
${requestScope.u.birthday.year}
<br/>
${requestScope.u.birthday.month}
<br/>
${
        requestScope.u.birDay
        }

<br/>
<h3>获取List的值</h3>
${list}
<br/>
${list[0]}
<br/>
${list[1]}
<br/>
${list[10]}

<br/>
${list[2].name}

<h3>获取Map的值</h3>
${requestScope.map["sname"]}
${map.gender}
${map.user.name}
</body>
</html>
