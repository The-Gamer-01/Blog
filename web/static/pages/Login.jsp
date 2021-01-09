<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/9/16
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>登录</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../css/Login.css">
    <script type="text/javascript">
        $(document).ready(function () {
            $('.top').load('../html/top.jsp');
        });
    </script>
</head>

<body>
    <div class="top"></div>
    <div class="main">
    <div class="container mainLogin">
        <form action="http://localhost:8080/Blog/LoginServlet" method="post" class="form-signin">
            <h2 class="form-signin-heading">登录</h2>
            <div>
                <label for="id" class="sr-only"></label><input type="text" placeholder="账号" id="id" name="id" class="form-control"><br>
                <label for="pawd" class="sr-only"></label><input type="password" placeholder="密码" id="pawd" name="pawd" class="form-control"><br>
            </div>
            <div>
            <input type="submit" value="登录" class="btn btn-lg btn-primary btn-block">
            <a href="http://localhost:8080/Blog/static/pages/findPawd.jsp">忘记密码</a>
            </div>
        </form>
    </div>
    </div>
</body>

</html>