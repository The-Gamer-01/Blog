<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/9
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>标签管理</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/Blogs.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('.top').load('../html/top.jsp');
            $('.ManageLeft').load('../html/ManageLeft.jsp');
        });
    </script>
    <script src="../js/TagManage.js"></script>
</head>
<body>
<div class="top"></div>
<div class="ManageLeft"></div>
<div class="col-md-10 ">
    <h1>标签管理</h1>
    <div>
        <input type="text" name="newtagName" id="newtagName"> <button onclick="createTag()">添加标签</button>
    </div>
    <table border="1px">
        <tr>
            <th>标签Id</th>
            <th>标签名</th>
        </tr>
    <c:forEach items="${tags}" var="tag">
        <tr>
            <td>${tag.tagId}</td>
            <td>${tag.tagName}</td>
            <td><button onclick="deleteTag(${tag.tagId})">删除</button></td>
        </tr>
    </c:forEach>
    </table>
</div>
</body>
</html>
