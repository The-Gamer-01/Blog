<%@ page import="me.gacl.dao.impl.UserTools" %>
<%@ page import="me.gacl.domain.User" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="me.gacl.domain.Blog" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/6
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String status = request.getParameter("status");
%>
<html>
<head>
    <title>搜索结果</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('.top').load('../html/top.jsp');
        });
        $(document).ready(function () {
            $('.searchLeft').load('../html/searchLeft.jsp');
            $('#blogDiv').show();
            $('#userDiv').hide();
            $('#tagDiv').hide();
            $('#classDiv').hide();
        })

        function playBlog() {
            $('#blogDiv').show();
            $('#userDiv').hide();
            $('#tagDiv').hide();
            $('#classDiv').hide();
        }

        function playUser() {
            $('#blogDiv').hide();
            $('#userDiv').show();
            $('#tagDiv').hide();
            $('#classDiv').hide();
        }

        function playTag() {
            $('#blogDiv').hide();
            $('#userDiv').hide();
            $('#tagDiv').show();
            $('#classDiv').hide();
        }

        function playClass() {
            $('#blogDiv').hide();
            $('#userDiv').hide();
            $('#tagDiv').hide();
            $('#classDiv').show();
        }
    </script>
    <link rel="stylesheet" href="../css/Search.css">
</head>
<body>
<div class="top"></div>
<div style="background-image: url('../img/backgroud.jpg');background-size:100% 100%;">
    <nav class="col-md-1 " style="height: 100%;">
        <ul class="nav nav-stacked ">
            <li>
                <a onclick="playBlog()">博客搜索</a>
            </li>
            <li>
                <a onclick="playUser()">博主搜索</a>
            </li>
        </ul>
    </nav>
    <div class="col-md-8 mainDiv">
        <div id="blogDiv" name="blogDiv" style="display: block">
            <h1>博客</h1>
            <ul class="nav nav-pills nav-stacked">
                <c:forEach items="${search}" var="blog">
                    <hr>
                    <div class="blog">
                        <div>
                            <li>
                                <a href="http://localhost:8080/Blog/gotoMyBlogServlet?blogId=${blog.getBlogId()}">${blog.blogName}</a>
                                <c:if test="${blog.blogTags.size()>0}">
                                    <span>博客标签</span>
                                    <c:forEach items="${blog.blogTags}" var="tag">
                                        <span>${tag.tagName}</span>
                                    </c:forEach>
                                </c:if>
                            </li>
                            <span><img src="http://localhost:8080/static${blog.author.head}" class="head"></img></span>
                            <span>${blog.author.name}</span>
                            <span>
                                    <svg t="1602865295538" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3635" width="16" height="16"><path d="M512 787.392l-212.64-212.64-96.832-96.832-9.12-9.12A127.04 127.04 0 0 1 160 383.36c0-70.624 57.408-128 128-128 32.8 0 62.432 12.704 85.12 33.088l9.76 9.76 96.544 96.512L512 427.36l32.576-32.64 96.544-96.512 9.76-9.76A126.912 126.912 0 0 1 736 255.36c70.592 0 128 57.408 128 128a127.04 127.04 0 0 1-33.408 85.472l-9.12 9.12-96.832 96.832L512 787.392zM736 191.36c-47.584 0-90.944 17.6-124.48 46.272l-0.16-0.16-2.144 2.176-19.232 19.232L512 336.832 434.016 258.88l-19.232-19.2-2.144-2.208-0.16 0.16A190.944 190.944 0 0 0 288 191.36a192 192 0 0 0-192 192c0 58.176 25.984 110.176 66.848 145.408L512 877.888l349.152-349.12A191.488 191.488 0 0 0 928 383.296a192 192 0 0 0-192-192z" fill="#181818" p-id="3636"></path></svg>
                                    ${blog.likesNum}</span>
                            <span>
                                    <svg t="1602865323154" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3778" width="16" height="16"><path d="M512 608a96 96 0 1 1 0-192 96 96 0 0 1 0 192m0-256c-88.224 0-160 71.776-160 160s71.776 160 160 160 160-71.776 160-160-71.776-160-160-160" fill="#000000" p-id="3779"></path><path d="M512 800c-212.064 0-384-256-384-288s171.936-288 384-288 384 256 384 288-171.936 288-384 288m0-640C265.248 160 64 443.008 64 512c0 68.992 201.248 352 448 352s448-283.008 448-352c0-68.992-201.248-352-448-352" fill="#000000" p-id="3780"></path></svg>
                                        ${blog.blogVisit}
                                </span>
                        </div>
                    </div>
                </c:forEach>
                <hr>
            </ul>
        </div>
        <div id="userDiv" name="userDiv">
            <h1>博主</h1>
            <div class="row">
            <c:forEach items="${searchuser}" var="item" varStatus="iv">
                <div class="user-item col-md-4">
                    <div>
                        <a href="http://localhost:8080/Blog/gotoOtherBlogsServlet?userId=${item.id}"><img src="http://localhost:8080/static${item.head}" class="head"></a>
                        <span>昵称：${item.name}</span>
                    </div>
                </div>
            </c:forEach>
            </div>
        </div>
        <div id="tagDiv" name="tagDiv">
            <h1>标签</h1>
        </div>
        <div id="classDiv" name="classDiv">
            <h1>分类专栏</h1>
        </div>
    </div>
</div>
</body>
</html>
