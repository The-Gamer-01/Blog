<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/7
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的收藏</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="../js/myCollections.js"></script>
    <link href="../css/myCollections.css">
    <script type="text/javascript">
        $(document).ready(function () {
            $('.top').load('../html/top.jsp');
        });
        $(document).ready(function () {
            $('.left').load('../html/left.jsp');
        })
    </script>
</head>
<body>
<div class="top"></div>
<div class="row" style="background-image: url('../img/backgroud.jpg');background-size:100% 100%; ">
    <div class="left"></div>
    <div class="col-md-10" style="height: 100%;">
        <div style="background:  rgba(255, 255, 255, 0.5); height: 100%;">
            <h1>我的博客收藏</h1>
            <c:forEach items="${mycollection}" var="item">
                <div class="blog-div">
                    <a href="http://localhost:8080/Blog/gotoMyBlogServlet?blogId=${item.blogId}">${item.blogName}</a>
                    <button onclick="delectCol(${item.blogId})" class="btn btn-default" style="float: right">取消收藏
                    </button>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
