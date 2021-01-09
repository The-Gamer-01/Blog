<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/7
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找回密码页面</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.top').load('../html/top.jsp');
        });
    </script>
</head>
<body>
<div class="top"></div>
    <form method="get" action="http://localhost:8080/Blog/findPawdServlet">
        请输入你要修改的密码：<input type="password" name="pawd" id="pawd">
        请输入您的邮箱：<input type="email" name="email" id="email">
        <input type="submit">
    </form>
</body>
</html>
