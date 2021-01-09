<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/9/20
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String search=request.getParameter("search");
%>
<html>
<head>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="../js/top.js"></script>
    <link rel="stylesheet" href="../css/top.css">
</head>
<body>
<nav class="navbar headmain">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="http://localhost:8080/Blog/gotoIndexServlet">首页</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form id="searchform" name="searchform" class="navbar-form navbar-left" action="http://localhost:8080/Blog/searchServlet?status='name7'" method="get">
                <div class="form-group">
                    <input  class="form-control" placeholder="请输入搜索内容" id="search" name="search">
                </div>
                <button type="sumbit"  class="btn btn-default" >搜索</button>
                <input style="display: none" value="name" id="status" name="status">
            </form>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${not empty user}">
                    <c:if test="${user.administrator==0}">
                        <li><a href="http://localhost:8080/Blog/static/pages/Manage.jsp">管理中心</a></li>
                    </c:if>
                    <li><a href="http://localhost:8080/Blog/static/pages/Blog.jsp">创作中心</a></li>
                    <li><a href="http://localhost:8080/Blog/static/pages/User.jsp">个人中心</a></li>
                </c:if>
                <c:if test="${empty user}">
                    <li><a href="http://localhost:8080/Blog/static/pages/Login.jsp">登录</a> </li>
                    <li><a href="http://localhost:8080/Blog/static/pages/Register.jsp">注册</a> </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
