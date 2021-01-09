<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="me.gacl.domain.User" %>
<%@ page import="me.gacl.dao.impl.UserTools" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="me.gacl.domain.Blog" %><%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/7
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String classId = request.getParameter("classId");
    System.out.println("classId:"+classId);
    User user = (User) request.getSession().getAttribute("user");
    String userId = user.id;
    String sql = "SELECT * FROM classes INNER JOIN blog ON classes.classId=blog.blogClass WHERE classId=? AND classUserId=?;";
    UserTools tool = new UserTools();
    ResultSet set = tool.Select(sql, classId, userId);
    ArrayList<Blog> list = new ArrayList<Blog>();
    String name="";
    String text="";
    while (set.next()) {
        System.out.println("blog+1");
        Blog blog = new Blog();
        blog.setBlogName(set.getString("blogName"));
        blog.setBlogId(set.getString("blogId"));
        list.add(blog);
    }
    boolean checkZero=false;
    if(classId.equals("0")){
        checkZero=true;
        String sql3="SELECT * FROM blog WHERE blogClass='0' AND blogAuthorId=?;";
        ResultSet set3=tool.Select(sql3,userId);
        while(set3.next()){
            Blog blog = new Blog();
            blog.setBlogName(set3.getString("blogName"));
            blog.setBlogId(set3.getString("blogId"));
            list.add(blog);
        }
    }
    String sql2="SELECT * FROM classes WHERE classUserId=? AND classId=?;";
    ResultSet set2=tool.Select(sql2,userId,classId);
    if(set2.next()){
        name=set2.getString("className");
        text=set2.getString("classText");
    }else{
        name="默认专栏";
    }
%>
<html>
<head>
    <title>Class模板</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../css/ClassFormwork.css">
    <script src="../js/ClassFormwork.js"></script>
    <script>
        var classId=<%=request.getParameter("classId")%>
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
<div class="row">
    <div class="left"></div>
    <div class="col-md-10">
        <div class="main">
            <h1 class="head"><%=name%></h1>
            <p style="color: white">分类专栏简介：<%=text%>
            <c:if test="<%=checkZero%>">
                默认专栏
            </c:if></p>
            <c:forEach items="<%=list%>" var="item">
                <div class="classes">
                    <a href="http://localhost:8080/Blog/gotoMyBlogServlet?blogId=${item.blogId}">${item.blogName}</a>
                    <button style="float:right;"  onclick="delect(${item.blogId})">移除</button>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
