<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/14
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>广告管理</title>
    <link rel="stylesheet" href="../css/AdsManage.css">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.top').load('../html/top.jsp');
            $('.ManageLeft').load('../html/ManageLeft.jsp');
            $('.modalBox').load('../html/AdsModalBox.jsp');
            $('.modalBox').load('../html/AdsSelectedModalBox.jsp');
        });
    </script>
</head>
<body>
<div class="modalBox"></div>
<div class="imgmodalBox" id="imgmodalBox"></div>
<div class="top"></div>
<div class="ManageLeft"></div>
<div class="col-md-11">
    <div style="text-align: center">
    <button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-default" >
        添加广告
    </button></div>
    <div class="row">
        <c:forEach items="${ads}" var="ad" varStatus="adv">
            <div class="col-md-3 backimgDiv">
                    <%--                <h5>${ad.adHead}</h5>--%>
                <img id="bgimg" src="http://localhost:8080/static${ad.adBackgroud}" alt="..." class="backimg">
                <div style="text-align: center">
                    <button class="btn btn-default" onclick="deleteImg(${ad.adId})">删除</button>
                </div>
                <div class="carousel-caption">
                    <h1>${ad.adHead}</h1>
                    <p>${ad.adP}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
