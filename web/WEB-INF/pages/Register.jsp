<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/9/13
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <c:if test="${not empty error}">
        <%
            out.print("<script type=\"text/javascript\">\n" +
                    "        alert(\"邮箱已注册\")\n" +
                    "    </script>");
        %>
    </c:if>
    <form action="/Blog/RegisterServlet" method="post">
        <input type="text" id="name" placeholder="昵称">
        <input type="password" id="pawd" placeholder="密码">
        <input type="email" id="email" name="email" placeholder="邮箱地址">
        <input type="submit" value="注册">
    </form>
</body>
</html>
