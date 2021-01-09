<%@ page import="java.util.ArrayList" %>
<%@ page import="me.gacl.domain.Ad" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/11
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script>
        $(function () {
            $('#carousel-example-generic').carousel({interval: 100})
        })
    </script>
</head>
<body>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="text-align: center">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <c:forEach items="${ads}" var="ad" varStatus="adstatus">
            <li data-target="#carousel-example-generic" data-slide-to="${adstatus.index}" <c:if
                test="${adstatus.index==0}">
            class="active"
        </c:if></li>
        </c:forEach>
    </ol>
    <div class="carousel-inner" role="listbox">
        <c:forEach items="${ads}" var="ad" varStatus="adstatus">
            <div
                    <c:if test="${adstatus.index==0}">
                        class="item active"
                    </c:if>
                    <c:if test="${adstatus.index!=0}">
                        class="item"
                    </c:if>>
                <img src="http://localhost:8080/static${ad.adBackgroud}" style="text-align: center;width: 100%;">
                <div class="carousel-caption">
                    <h1>${ad.adHead}</h1>
                    <p>${ad.adP}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<%--<div class="item active">--%>
<%--    <img src="static/img/backgroud.jpg" alt="..." style="text-align: center;width: 100%;">--%>
<%--    <div class="carousel-caption">--%>
<%--        <h1>轮播1的标题</h1>--%>
<%--        <p>这是轮播一的说明</p>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<div class="item">--%>
<%--    <img src="static/img/backgroud.jpg" alt="..." style="text-align: center;width: 100%;">--%>
<%--    <div class="carousel-caption">--%>
<%--        <h1>轮播2的标题</h1>--%>
<%--        <p>这是轮播二的说明</p>--%>
<%--    </div>--%>
<%--</div>--%>
<%--</div>--%>
<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
</a>
<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
</a>
</div>
</body>
</html>
