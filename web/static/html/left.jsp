<%@ page import="me.gacl.util.random.random" %><%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/9/20
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String raodom= random.getRandomNum(10);
%>
<html>
<head>
    <title>Title</title>
    <link href="../css/left.css">
</head>
<body>
<nav class="col-md-2 left">
    <ul class="nav nav-stacked ">
        <li><a href="http://localhost:8080/Blog/gotowriteBlogServlet">发表博客</a></li>
        <li><a href="http://localhost:8080/Blog/getMyBlogsServlet?page=1">我的博客</a></li>
        <li><a href="http://localhost:8080/Blog/static/pages/myClasses.jsp?page=1&random=<%=raodom%>">我的分类</a></li>
        <li><a href="http://localhost:8080/Blog/getMyCollectionServlet">我的收藏</a> </li>
        <li><a href="http://localhost:8080/Blog/getMyFriendsServlet">我的关注</a> </li>
    </ul>
</nav>
</body>
</html>
