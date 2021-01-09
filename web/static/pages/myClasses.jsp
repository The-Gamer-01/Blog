<%@ page import="me.gacl.domain.User" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="me.gacl.dao.impl.UserTools" %>
<%@ page import="me.gacl.domain.Classes" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/9/29
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%
    String pageNum = request.getParameter("page");
    User user = (User) request.getSession().getAttribute("user");
    String userId = user.id;
    String sql = "SELECT * FROM classes WHERE classUserId=?";
    UserTools tool = new UserTools();
    ResultSet set = tool.Select(sql, userId);
    ArrayList<Classes> list = new ArrayList<>();
    while (set.next()) {
        Classes cla = new Classes();
        cla.setClassName(set.getString("className"));
        cla.setClassId(set.getString("classId"));
        list.add(cla);
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的类管理</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="../js/myClasses.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('.top').load('../html/top.jsp');
        });
        $(document).ready(function () {
            $('.left').load('../html/left.jsp');
            $('.modalBox').load('../html/CreateClasses.jsp');
        })
    </script>
    <link rel="stylesheet" href="../css/myClasses.css">
</head>
<body>
<div class="modalBox"></div>
<div class="top"></div>
<div class="row" style="background-image: url('../img/backgroud.jpg');background-size:100% 100%;">
    <div class="left"></div>
    <div class="col-md-10">
        <div class="main">
            <div>
                <h1 class="head">我的类别</h1>
            </div>
            <div>
<%--                <button onclick="createClass()">新建类别</button>--%>
                <button type="button" data-toggle="modal" data-target="#myModal">新建类别</button>
            </div>
            <div>
                <div class="classes">
                    <div>
                        <a href="http://localhost:8080/Blog/static/pages/ClassFormwork.jsp?classId=0">默认专栏</a>
                    </div>
                    <div>
                    </div>
                </div>
                <hr>
                <c:forEach items="<%=list%>" var="c">
                    <div class="classes">
                        <div>
                            <a href="http://localhost:8080/Blog/static/pages/ClassFormwork.jsp?classId=${c.classId}">${c.className}</a>
                        </div>
                        <div>
                            <div class="item-right"><span><button>删除</button></span></div>
                        </div>
                    </div>
                    <hr>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>
