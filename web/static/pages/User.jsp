<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/9/16
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/User.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script rel="stylesheet" type="text/javascript" src="../js/User.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('.top').load('../html/top.jsp');
        });
        outlogin=function () {
            location.href="http://localhost:8080/Blog/logoffServlet";
        }
    </script>
</head>
<body>
<div class="top"></div>

<div class="container" id="div1" name="div1">
    <div class="row">
    </div>
    <div class="row">
        <div class=".col-md-12">
            <table class="table ">
                <tr>
                    <th style="text-align: center"><img src="http://localhost:8080/static${user.head}" class="head">
                    </th>
                </tr>
                <tr>
                    <th>账号：${user.id} <button onclick="updatePawd(${user.id})" class="btn btn-default" style="float: right">修改密码</button></th>
                </tr>
                <tr>
                    <th>昵称：${user.name}</th>
                </tr>
                <tr>
                    <th>邮箱：${user.email}</th>
                </tr>
                <tr>
                    <th>签名：${user.sayings}</th>
                </tr>
                <tr>
                    <th>生日：${user.birthday}</th>
                </tr>
                <tr>
                    <th>联系方式：${user.telOremail}</th>
                </tr>
            </table>
        </div>
    </div>
</div>
<div class="container" id="div2" name="div2">
    <div class="row">
        <div class=".col-md-12">
            <table class="table">
                <form method="post" action="http://localhost:8080/Blog/upHeadServlet" enctype="multipart/form-data"
                      name="updateHead" id="updateHead">
                    <tr>
                        <th style="text-align: center" id="head"><img src="http://localhost:8080/static${user.head}"
                                                                      class="head" id="upHead"></th>
                    </tr>
                    <tr style="display: none">
                        <th><input type="file" id="file" name="file" onchange="viewImage(this)"></th>
                    </tr>
                </form>
                <label for="file">上传头像</label>
                <form method="post" action="http://localhost:8080/Blog/updateUserServlet" name="updateData"
                      id="updateData">
                    <tr>
                        <th>账号：${user.id}</th>
                    </tr>
                    <tr>
                        <th>密码：<input type="text" value="${user.pawd}" name="pawd" id="pawd"></th>
                    </tr>
                    <tr>
                        <th>昵称：<input type="text" value="${user.name}" name="name" id="name"></th>
                    </tr>
                    <tr>
                        <th>邮箱：${user.email}</th>
                    </tr>
                    <tr>
                        <th>签名：<input type="text" value="${user.sayings}" name="text" id="text"></th>
                    </tr>
                    <tr>
                        <th>生日：<input type="date" value="${user.birthday}" name="birthday" id="birthday"></th>
                    </tr>
                    <tr>
                        <th>联系方式：<input type="text" value="${user.telOremail}" name="telOremail" id="telOremail"></th>
                    </tr>
                </form>
            </table>
        </div>
    </div>
</div>
<div style="text-align: center" id="update" name="update">
    <button onclick="updateUser()" class="btn btn-default">修改信息</button>
    <button onclick="outlogin()" class="btn btn-default">退出登录</button>
</div>
<div style="text-align: center" id="save" name="save">
    <button onclick="saveUser()" class="btn btn-default">保存信息</button>
</div>
</body>
</html>
