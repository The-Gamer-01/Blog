<%@ page import="java.util.ArrayList" %>
<%@ page import="me.gacl.domain.Blog" %>
<%@ page import="me.gacl.domain.Tag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/8
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%
    ArrayList<Tag> indexList = (ArrayList<Tag>) request.getSession().getAttribute("indexTags");
    if(indexList==null) System.out.println("cao");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>博客管理页面</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="../js/IndexManage.js"></script>
    <script>
        $(document).ready(function () {
            $('.top').load('../html/top.jsp');
            $('.ManageLeft').load('../html/ManageLeft.jsp');
        });
    </script>
</head>
<body>
<div class="top"></div>
<div class="ManageLeft"></div>
<div class="col-md-11">
    <h1>首页分栏管理</h1>
    <div>
        <input type="text" name="newTag" id="newTag" ><button onclick="createIndexClass()">新建分栏</button>
        <div>
            <table border="1px">
                <tr>
                    <th>首页分栏Id</th>
                    <th>首页分栏名</th>
                </tr>
                <c:forEach items="<%=indexList%>" var="tag">
                    <tr>
                        <td>${tag.tagId}</td>
                        <td> ${tag.tagName}</td>
                        <td><button onclick="deleteIndexTag(${tag.tagId})">删除分栏</button></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
