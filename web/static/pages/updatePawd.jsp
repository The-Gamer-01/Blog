<%@ page import="me.gacl.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/10
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user=(User)request.getSession().getAttribute("user");
%>
<html>
<head>
    <title>修改密码</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src='../js/updatePawd.js'></script>
    <script>
        var userPawd='<%=user.pawd%>';
        $(document).ready(function () {
            $('.top').load('../html/top.jsp');
        });
    </script>
</head>
<body>
<div class="top"></div>
<div>
<form action="http://localhost:8080/Blog/updatePawdServlet" method="post" class="form-signin" id="pwadForm" name="pawdForm">
    <h2 class="form-signin-heading">修改密码</h2>
    <div>
        <label for="pawd" class="sr-only"></label><input type="password" placeholder="旧密码" id="pawd" name="pawd" class="form-control"><br>
        <label for="repawd" class="sr-only"></label><input type="password" placeholder="新密码" id="repawd" name="repawd" class="form-control"><br>
    </div>
    <div style="text-align: center">
        <button type="button" onclick="check(userPawd)" class="btn btn-lg btn-primary">修改</button>
    </div>
</form>
</div>
</body>
</html>
