<%@ page import="java.util.ArrayList" %>
<%@ page import="me.gacl.domain.Blog" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/8
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%
    ArrayList<Blog> blogList = (ArrayList<Blog>) request.getAttribute("blogList");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>博客管理页面</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="../js/BlogManage.js"></script>
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
    <div>
        <div>
            <table border="1px" class="table table-hover">
                <tr>
                    <th>博客</th>
                    <th>审核状态</th>
                    <th>设为推荐</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${blogList}" var="blog">
                    <tr>
                        <td>
                            <a href="http://localhost:8080/Blog/gotoMyBlogServlet?blogId=${blog.blogId}">${blog.blogName}</a>
                        </td>
                        <td>
                            <select id="blogLevel" name="blogLevel" >
                                <c:if test="${blog.blogLevel==1}">
                                <option value="1">审核中</option>
                                <option value="0">已发表</option>
                                </c:if>
                                <c:if test="${blog.blogLevel==0}">
                                    <option value="0">已发表</option>
                                    <option value="1">审核中</option>
                                </c:if>
                            </select>
                        </td>
                        <td>
                            <select id="blogIndex" name="blogIndex">
                                <c:if test="${blog.blogIndex==1}">
                                <option value=1>是</option>
                                <option value=0>否</option>
                                </c:if>
                                <c:if test="${blog.blogIndex==0}">
                                    <option value=0>否</option>
                                    <option value=1>是</option>
                                </c:if>
                            </select>
                        </td>
                        <td><button onclick="updateBlog(${blog.blogId})" class="btn btn-default">更改</button>
                        <button onclick="deleteBlog(${blog.blogId})" class="btn btn-default">删除</button></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
