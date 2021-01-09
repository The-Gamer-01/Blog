<%@ page import="java.util.ArrayList" %>
<%@ page import="me.gacl.domain.Ad" %><%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/14
  Time: 11:31
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
    <script src="../js/AdsModalBox.js"></script>
</head>
<body>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h1>广告详情</h1>
            </div>
            <div class="modal-body">
                <div>
                    <span>广告标题：</span><input type="text" id="Adtitle" name="Adtitle" onchange="showImg()">
                </div>
                <div>
                    <span>广告文案：</span><input type="text" id="AdP" name="AdP" onchange="showImg()">
                </div>
                <div>
                    <span>广告链接：</span><input type="url" id="AdHyperlink" name="AdHyperlink" onchange="showImg()">
                </div>
                <div>
                    <span>广告背景：</span><input type="file" id="upimg" name="upimg" onchange="showImg()">
                </div>
                <div id="textDiv" >
                    <img id="bgimg" src="../img/backgroud.jpg" alt="..." style="text-align: center;width: 100%;">
                    <div class="carousel-caption">
                        <h1>样式</h1>
                        <p>样式</p>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="send()">提交</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
