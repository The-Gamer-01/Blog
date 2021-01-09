<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/9/13
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../css/Register.css">
    <script src="../js/Register.js"></script>
    <script>
        $(document).ready(function () {
            $('.top').load('../html/top.jsp');
        });
    </script>
</head>
<body>
<c:if test="${not empty error}">
    <%
        out.print("<script type=\"text/javascript\">\n" +
                "        alert(\"邮箱已注册\")\n" +
                "    </script>");
    %>
</c:if>
<div class="top"></div>
<div class="container mid">
    <div class="row mid">
        <div class=".col-md-4" style="text-align: center">
            <form action="/Blog/RegisterServlet" method="post" id="registerForm">
                <table style="margin: auto;">
                    <tr>
                        <th>
                            <div class="input-group">
                                <span>用户昵称：</span><input type="text" placeholder="昵称" id="name"
                                                                                 name="name"><span
                                    id="namespan"></span><br>
                            </div>
                        </th>
                    </tr>
                    <tr>
                        <th>
                            <div class="input-group">
                                <span>输入密码：</span><input type="password" placeholder="密码"
                                                                                 id="pawd" name="pawd"><br>
                            </div>
                        </th>
                    </tr>
                    <tr>
                        <th>
                            <div class="input-group">
                               <span>再输密码：</span><input type="password" placeholder="请再次输入密码"
                                                                                   id="repawd" name="repawd"
                                                                                   onchange="check()">
                                <svg id="repawdcheck" t="1603094364545" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                     xmlns="http://www.w3.org/2000/svg" p-id="3805" width="16" height="16">
                                    <path d="M830.122667 573.653333a18.944 18.944 0 0 0-22.058667 15.36 322.901333 322.901333 0 0 1-318.549333 266.709334c-178.346667 0-323.413333-145.152-323.413334-323.498667a323.328 323.328 0 0 1 323.456-323.498667 323.456 323.456 0 0 1 318.378667 266.112 19.029333 19.029333 0 0 0 37.504-6.698666 357.546667 357.546667 0 0 0-56.149333-138.112A361.386667 361.386667 0 0 0 489.514667 170.666667 361.429333 361.429333 0 0 0 128 532.224c0 199.338667 162.176 361.557333 361.514667 361.557333a360.832 360.832 0 0 0 356.010666-298.069333 18.986667 18.986667 0 0 0-15.402666-22.058667"
                                          p-id="3806" fill="#d81e06"></path>
                                    <path d="M655.786667 363.776a20.181333 20.181333 0 0 0-28.544 0l-139.946667 139.946667-139.946667-139.946667a20.181333 20.181333 0 0 0-28.458666 28.458667l139.946666 139.946666-139.946666 139.946667a20.181333 20.181333 0 0 0 28.458666 28.501333l139.946667-139.946666 139.946667 139.946666a20.053333 20.053333 0 0 0 28.501333 0 20.181333 20.181333 0 0 0 0-28.458666l-139.946667-139.946667 139.946667-139.946667a20.181333 20.181333 0 0 0 0-28.501333"
                                          p-id="3807" fill="#d81e06"></path>
                                </svg>

                                <br>
                            </div>
                        </th>
                    </tr>
                    <tr>
                        <th>
                            <div class="input-group">
                                <span>注册邮箱：</span><input type="email" placeholder="邮箱地址"
                                                                                  id="email" name="email" >
                                <svg id="emailcheck" t="1603094364545" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                     xmlns="http://www.w3.org/2000/svg" p-id="3805" width="16" height="16">
                                    <path d="M830.122667 573.653333a18.944 18.944 0 0 0-22.058667 15.36 322.901333 322.901333 0 0 1-318.549333 266.709334c-178.346667 0-323.413333-145.152-323.413334-323.498667a323.328 323.328 0 0 1 323.456-323.498667 323.456 323.456 0 0 1 318.378667 266.112 19.029333 19.029333 0 0 0 37.504-6.698666 357.546667 357.546667 0 0 0-56.149333-138.112A361.386667 361.386667 0 0 0 489.514667 170.666667 361.429333 361.429333 0 0 0 128 532.224c0 199.338667 162.176 361.557333 361.514667 361.557333a360.832 360.832 0 0 0 356.010666-298.069333 18.986667 18.986667 0 0 0-15.402666-22.058667"
                                          p-id="3806" fill="#d81e06"></path>
                                    <path d="M655.786667 363.776a20.181333 20.181333 0 0 0-28.544 0l-139.946667 139.946667-139.946667-139.946667a20.181333 20.181333 0 0 0-28.458666 28.458667l139.946666 139.946666-139.946666 139.946667a20.181333 20.181333 0 0 0 28.458666 28.501333l139.946667-139.946666 139.946667 139.946666a20.053333 20.053333 0 0 0 28.501333 0 20.181333 20.181333 0 0 0 0-28.458666l-139.946667-139.946667 139.946667-139.946667a20.181333 20.181333 0 0 0 0-28.501333"
                                          p-id="3807" fill="#d81e06"></path>
                                </svg>
                            </div>
                        </th>
                    </tr>
                    <tr>
                        <th>
                                <span>联系方式：</span><input type="text" placeholder="联系方式"
                                                                                       id="teloremail" name="teloremail">
                                <svg id="telcheck" t="1603094364545" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                     xmlns="http://www.w3.org/2000/svg" p-id="3805" width="16" height="16">
                                    <path d="M830.122667 573.653333a18.944 18.944 0 0 0-22.058667 15.36 322.901333 322.901333 0 0 1-318.549333 266.709334c-178.346667 0-323.413333-145.152-323.413334-323.498667a323.328 323.328 0 0 1 323.456-323.498667 323.456 323.456 0 0 1 318.378667 266.112 19.029333 19.029333 0 0 0 37.504-6.698666 357.546667 357.546667 0 0 0-56.149333-138.112A361.386667 361.386667 0 0 0 489.514667 170.666667 361.429333 361.429333 0 0 0 128 532.224c0 199.338667 162.176 361.557333 361.514667 361.557333a360.832 360.832 0 0 0 356.010666-298.069333 18.986667 18.986667 0 0 0-15.402666-22.058667"
                                          p-id="3806" fill="#d81e06"></path>
                                    <path d="M655.786667 363.776a20.181333 20.181333 0 0 0-28.544 0l-139.946667 139.946667-139.946667-139.946667a20.181333 20.181333 0 0 0-28.458666 28.458667l139.946666 139.946666-139.946666 139.946667a20.181333 20.181333 0 0 0 28.458666 28.501333l139.946667-139.946666 139.946667 139.946666a20.053333 20.053333 0 0 0 28.501333 0 20.181333 20.181333 0 0 0 0-28.458666l-139.946667-139.946667 139.946667-139.946667a20.181333 20.181333 0 0 0 0-28.501333"
                                          p-id="3807" fill="#d81e06"></path>
                                </svg>

                                <br>
                        </th>
                    </tr>
                    <tr>
                        <th>性别:<input type="radio" name="sex" value=1 checked>男<input type="radio" name="sex" value=0>女
                        </th>
                    </tr>
                    <tr>
                        <th>出生日期：<input type="date" id="birthday" name="birthday"></th>
                    </tr>
                </table>
            </form>
            <button onclick="checkAndsend()">注册</button>
        </div>
    </div>
</div>
</body>
</html>
