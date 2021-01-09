<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="me.gacl.domain.Tag" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="me.gacl.domain.Blog" %><%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/15
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Tag> indexTags = (ArrayList<Tag>) request.getSession().getAttribute("indextags");
    ArrayList<Blog> indexTagBlogs=(ArrayList<Blog>)request.getSession().getAttribute("indextagBlogs");
%>
<html>
<head>
    <link rel="stylesheet" href="../css/index.css">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <title></title>
    <script>
        $(document).ready(function () {
            $('.top').load('../html/top.jsp');
        });
    </script>
</head>
<body>
<div class="top"></div>
    <nav class="col-md-2 tagNav" >
        <ul class=" nav nav-pills nav-stacked navbar navbar-default">
            <c:forEach items="<%=indexTags%>" var="tag">
                <li role="presentation"><a href="http://localhost:8080/Blog/gotoIndexBlogsServlet?tagId=${tag.tagId}">${tag.tagName}</a></li>
            </c:forEach>
        </ul>
    </nav>
    <div class="col-md-10">
        <c:forEach items="<%=indexTagBlogs%>" var="blog">
            <div>
                <a href="http://localhost:8080/Blog/gotoMyBlogServlet?blogId=${blog.blogId}">${blog.blogName}</a>
            </div>
        </c:forEach>
    </div>
</body>
</html>
