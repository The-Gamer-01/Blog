<%@ page import="me.gacl.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/17
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//    User otherUser=(User)request.getSession().getAttribute("otherUser");
%>
<html>
<head>
    <title></title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../css/otherUserBlogs.css">
    <script>
        $(document).ready(function () {
            $('.top').load('../html/top.jsp');
        });
    </script>
</head>
<body>
    <div class="top"></div>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-2">
            <img src="http://localhost:8080/static${otherUser.head}" class="head">
        </div>
        <div class="author-div">
            <div style="text-align: center">
                <a href="http://localhost:8080/Blog/gotoOtherBlogsServlet?userId=${author.id}"><img
                        src="http://localhost:8080/static${author.head}" class="authorHead"></a>
                <%--            <img src="http://localhost:8080/static<%=author.head%>" class="authorHead">--%>
            </div>
            <hr>
            <div>
                <span>
            博主：<%=author.name%>
                     </span>
                <button class="btn btn-default float-right"
                        onclick="giveAfriend(<%=user.id%>,<%=author.id%>)">关注
                </button>
            </div>
            <div>
                <span>博客数：<%=author.getBlogs().size()%></span>
            </div>
            <div>
                <span>总点赞数：<%=likesNum%></span>
            </div>
            <div>
                <span>总浏览数：<%=visitNum%></span>
            </div>
            <div>
                <span>个性签名：<%=author.getSayings()%></span>
            </div>
        </div>
        <div>
            <span>博主名：${otherUser.name}</span>
            <span>博主</span>
        </div>
    </div>
</body>
</html>
