<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/9/20
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String pageNum=request.getParameter("page");
%>
<html>
<head>
    <title>我的博客</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="../js/myBlogs.js"></script>
    <script>
        var pageNum=<%=pageNum%>;
    </script>
    <link rel="stylesheet" href="../css/myBlogs.css">
</head>
<body>
<div class="top"></div>
<div class="row" style="background-image: url('../img/backgroud.jpg');background-size:100% 100%;">
    <div class="left"></div>
    <div class="col-md-10">
        <div class="main">
            <h1 id="head" class="head">我的文章</h1>
            <div class="">
                <span style="color: white">筛选：</span>
                <input type="date" id="date" name="date" >
                <select id="blogAttribute" name="blogAttribute">
                    <option value="不限">不限</option>
                    <option value="原创">原创</option>
                    <option value="转载">转载</option>
                    <option value="翻译">翻译</option>
                </select>
                <select id="blogClasses" name="blogClasses">
                    <option value="0">不限</option>
                    <c:forEach items="${classes}" var="cla">
                        <option value="${cla.classId}">
                                ${cla.className}
                        </option>
                    </c:forEach>
                </select>
                <select id="blogTag" name="blogTag">
                    <option value="0">不限</option>
                    <c:forEach items="${tags}" var="t" varStatus="ts">
                        <option value="${t.tagId}">${t.tagName}</option>
                    </c:forEach>
                </select>
                <button onclick="search()">搜索</button>
            </div>
            <div style="position: relative">
            <c:forEach items="${blog}" var="item">
                <div class="blog" id="${item.blogId}">
                    <div>
                        <a href="http://localhost:8080/Blog/gotoMyBlogServlet?blogId=${item.blogId}">${item.blogName}</a>
                    </div>
                    <div>
                        <div class="item-left"><span><p>${item.blogAttribute}</p></span></div>
                        <div class="item-left"><span><p>${item.blogTime}</p></span></div>
                        <div class="item-right"><span><button onclick="delect(${item.blogId})">删除</button></span></div>
                        <div class="item-right"><span><button onclick="update(${item.blogId})">编辑</button></span></div>
                    </div>
                </div>
                <div>
                    <hr>
                </div>
            </c:forEach>
            </div>
            <nav aria-label="...">
                <ul class="pager">
                    <li><a onclick="left()"><</a></li>
                    <c:forEach begin="1" end="${pageNum}" var="n" varStatus="nv" step="5">
                        <li><a onclick="gotoPageNum(${nv.count})">${nv.count}</a></li>
                    </c:forEach>
                    <li><a onclick="right()"> > </a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
