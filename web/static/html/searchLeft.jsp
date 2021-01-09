<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/8
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        function gotoBlog() {
            window.location.replace("http://localhost:8080/Blog/searchServlet?status=name");
        }
    </script>
</head>
<body>
<nav class="col-md-1 " style="height: 100%;">
    <ul class="nav nav-stacked ">
<%--        <a href="http://localhost:8080/Blog/searchServlet?status=name">博客</a>--%>
        <li><button onclick="gotoBlog()">博客</button></li>
        <li><a href="http://localhost:8080/Blog/searchServlet?status=user">用户</a></li>
    </ul>
</nav>
</body>
</html>
