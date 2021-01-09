<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="me.gacl.domain.User" %>
<%@ page import="me.gacl.dao.impl.UserTools" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="me.gacl.domain.Comment" %>
<%@ page import="me.gacl.domain.Blog" %><%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/2
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Blog blog = (Blog) request.getSession().getAttribute("seeingBlog");
    User author = (User) request.getSession().getAttribute("author");
    User user = ((User) request.getSession().getAttribute("user"));
    if (user == null) {
        user = new User();
    }
    int taglength = blog.blogTags.size();
    int likesNum = 0, visitNum = 0;
    for (Blog b : author.getBlogs()) {
        likesNum += b.getLikesNum();
        visitNum += b.getBlogVisit();
    }
%>
<html>

<head>
    <title>此为博客模板,非特殊无法访问</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/Blogs.css">
    <script src="../js/BlogFormwork.js"></script>
    <script type="text/javascript">
        var loc = window.location.search.substring(1);
        var blogId =<%=request.getParameter("blogId")%>;
        var userName = '<%=user.name%>';
        $(document).ready(function () {
            $('.top').load('../html/top.jsp');
            $('.mainDiv').load('http://localhost:8080/static/html/' + blogId + '.html');
            $('.modalBox').load('../html/BlogModalBox.jsp');
        });
    </script>
</head>

<body>
<div class="modalBox"></div>
<div class="top"></div>
<div class="row backgroud">
    <div class="col-md-1"></div>
    <div class="col-md-7">
        <div class="headDiv">
            <h1>
                <a href="http://localhost:8080/Blog/gotoMyBlogServlet?blogId=<%=request.getParameter("blogId")%>"><%=blog.blogName%>
                </a>
            </h1>
            <div>
                <div>
                <span><img src="../img/<%=blog.blogAttribute%>.png" id="att" style="height: 45px">
                    <c:if test="<%=taglength>0%>">
                        标签：
                        <c:forEach items="<%=blog.blogTags%>" var="tag">
                            ${tag.tagName}
                        </c:forEach>
                    </c:if>
                </span>
                    <span>最后修改时间：<%=blog.blogTime%></span>
                    <span><svg t="1602951864317" class="icon" viewBox="0 0 1024 1024" version="1.1"
                               xmlns="http://www.w3.org/2000/svg" p-id="2776" width="16" height="16"><path
                            d="M512 787.392l-212.64-212.64-96.832-96.832-9.12-9.12A127.04 127.04 0 0 1 160 383.36c0-70.624 57.408-128 128-128 32.8 0 62.432 12.704 85.12 33.088l9.76 9.76 96.544 96.512L512 427.36l32.576-32.64 96.544-96.512 9.76-9.76A126.912 126.912 0 0 1 736 255.36c70.592 0 128 57.408 128 128a127.04 127.04 0 0 1-33.408 85.472l-9.12 9.12-96.832 96.832L512 787.392zM736 191.36c-47.584 0-90.944 17.6-124.48 46.272l-0.16-0.16-2.144 2.176-19.232 19.232L512 336.832 434.016 258.88l-19.232-19.2-2.144-2.208-0.16 0.16A190.944 190.944 0 0 0 288 191.36a192 192 0 0 0-192 192c0 58.176 25.984 110.176 66.848 145.408L512 877.888l349.152-349.12A191.488 191.488 0 0 0 928 383.296a192 192 0 0 0-192-192z"
                            fill="#181818" p-id="2777"></path></svg>
                        ${seeingBlog.likesNum}</span>
                    <span><svg t="1602951697946" class="icon" viewBox="0 0 1024 1024" version="1.1"
                               xmlns="http://www.w3.org/2000/svg" p-id="2632" width="16" height="16"><path
                            d="M512 608a96 96 0 1 1 0-192 96 96 0 0 1 0 192m0-256c-88.224 0-160 71.776-160 160s71.776 160 160 160 160-71.776 160-160-71.776-160-160-160"
                            fill="#000000" p-id="2633"></path><path
                            d="M512 800c-212.064 0-384-256-384-288s171.936-288 384-288 384 256 384 288-171.936 288-384 288m0-640C265.248 160 64 443.008 64 512c0 68.992 201.248 352 448 352s448-283.008 448-352c0-68.992-201.248-352-448-352"
                            fill="#000000" p-id="2634"></path></svg>
                        ${seeingBlog.blogVisit}</span>
                </div>
                <div style="margin-left: 55px">
                    <c:if test="<%=blog.getBlogReprint()!=null%>">
                        <span>转载链接：<a href="http://<%=blog.getBlogReprint()%>"><%=blog.blogReprint%></a></span>
                    </c:if>
                </div>
            </div>
            <c:if test="${user.administrator==0}">
                <button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-default">管理员管理</button>
            </c:if>
        </div>
        <div class="main mainDiv"></div>
        <div class="utl-div">
            <div>
                <span>
                    <button class="btn btn-default float-left" onclick="giveAlike(<%=user.id%>,<%=blog.userLike%>)"
                            value="${status}"
                            id="send">
                        <c:if test="<%=blog.userLike%>">
                            已
                        </c:if>
                        点赞<%=blog.likesNum%></button>
                </span>
            </div>

            <div>
                <span>
                    <button class="btn btn-default float-left">评论<%=blog.blogcomments.size()%></button>
                </span>
            </div>

            <div>
                <span>
                    <button class="btn btn-default float-left" onclick="giveAcollect(<%=user.id%>)" value="${colstatus}"
                            id="col"
                            name="col">收藏</button>
                </span>
            </div>

            <div class="input-group">
                <input type="text" class="form-control" placeholder="请输入您的评论..." id="commentText">
                <span class="input-group-btn">
            <button onclick="giveAcomment(blogId)" type="button" class="btn btn-default">提交</button>
                </span>
            </div>
        </div>


        <div class="comments-div">
            <c:forEach items="<%=blog.blogcomments%>" var="c">
                <div class="comment">
                    <img src="http://localhost:8080/static/${c.userHead}" class="head">${c.userName}:${c.commentText}
                    <button onclick="giveTcomment(${c.commentId},<%=user.id%>,'${c.userName}')" style="float: right"
                            class="btn btn-default">评论
                    </button>
                    <c:if test="${c.commentUser==user.id}">
                        <button onclick="delectComment(${c.commentId},blogId)" style="float:right;"
                                class="btn btn-default">删除
                        </button>
                    </c:if>
                    <c:forEach items="${c.recommentList}" var="rc">
                        <div class="tcomment">
                            <img src="http://localhost:8080/static/${rc.userHead}" class="head">${rc.commentText}
                            <button onclick="giveTcomment(${c.commentId},<%=user.id%>,'${rc.userName}')"
                                    style="float: right" class="btn btn-default">评论
                            </button>
                            <c:if test="${rc.commentUser==user.id}">
                                <button onclick="delectComment(${rc.commentId},blogId)" style="float: right"
                                        class="btn btn-default">删除
                                </button>
                            </c:if>
                        </div>
                    </c:forEach>
                </div>
                <hr>
            </c:forEach>
        </div>
    </div>
    <div class="col-md-3">
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

        <div class="otherBlog-div">
                <h2><%=author.getName()%>的其他博客推荐</h2>
            <c:forEach items="<%=author.getBlogs()%>" var="b" begin="0" end="4">
                <div>
                    <div>
                        <a href="http://localhost:8080/Blog/gotoMyBlogServlet?blogId=${b.blogId}">${b.blogName}</a>
                    </div>
                    <div style="float: right">
                        <span>${b.author.name}</span>
                        <span>
                                    <svg t="1602865295538" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                         xmlns="http://www.w3.org/2000/svg" p-id="3635" width="16" height="16"><path
                                            d="M512 787.392l-212.64-212.64-96.832-96.832-9.12-9.12A127.04 127.04 0 0 1 160 383.36c0-70.624 57.408-128 128-128 32.8 0 62.432 12.704 85.12 33.088l9.76 9.76 96.544 96.512L512 427.36l32.576-32.64 96.544-96.512 9.76-9.76A126.912 126.912 0 0 1 736 255.36c70.592 0 128 57.408 128 128a127.04 127.04 0 0 1-33.408 85.472l-9.12 9.12-96.832 96.832L512 787.392zM736 191.36c-47.584 0-90.944 17.6-124.48 46.272l-0.16-0.16-2.144 2.176-19.232 19.232L512 336.832 434.016 258.88l-19.232-19.2-2.144-2.208-0.16 0.16A190.944 190.944 0 0 0 288 191.36a192 192 0 0 0-192 192c0 58.176 25.984 110.176 66.848 145.408L512 877.888l349.152-349.12A191.488 191.488 0 0 0 928 383.296a192 192 0 0 0-192-192z"
                                            fill="#181818" p-id="3636"></path></svg>
                                ${b.likesNum}</span>
                        <span>
                                    <svg t="1602865323154" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                         xmlns="http://www.w3.org/2000/svg" p-id="3778" width="16" height="16"><path
                                            d="M512 608a96 96 0 1 1 0-192 96 96 0 0 1 0 192m0-256c-88.224 0-160 71.776-160 160s71.776 160 160 160 160-71.776 160-160-71.776-160-160-160"
                                            fill="#000000" p-id="3779"></path><path
                                            d="M512 800c-212.064 0-384-256-384-288s171.936-288 384-288 384 256 384 288-171.936 288-384 288m0-640C265.248 160 64 443.008 64 512c0 68.992 201.248 352 448 352s448-283.008 448-352c0-68.992-201.248-352-448-352"
                                            fill="#000000" p-id="3780"></path></svg>
                                        ${b.blogVisit}
                                </span>
                    </div>
                    <hr>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="col-md-1"></div>
</div>
</body>

</html>