<%@ page import="me.gacl.domain.User" %>
<%@ page import="me.gacl.dao.impl.UserTools" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/2
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>点赞栏组件</title>
<%--    <link rel="stylesheet" href="../css/bottom.css">--%>
<%--    <script src="../js/bottom.js"></script>--%>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<%--    <link rel="stylesheet" href="../css/Blogs.css">--%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>
<div>
    <nav class="navbar navbar-default navbar-fixed-bottom">
        <div class="container">
            <a>
                <img src="../img/未点赞.png">
            <button type="button" class="btn btn-default navbar-btn">点赞</button>
            </a>
            <button type="button" class="btn btn-default navbar-btn">评论</button>
        </div>
    </nav>
</div>
</body>
</html>
