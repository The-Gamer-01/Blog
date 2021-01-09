<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/6
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新建类别</title>
</head>
<body>
    <form action="http://localhost:8080/Blog/createClassServlet" method="post">
        <table>
            <tr>
                <td>类别名：<input type="text" id="name" name="name"></td>
            </tr>
            <tr>
                <td>类别介绍：<input type="text" id="text" name="text"></td>
            </tr>
            <tr>

            </tr>
            <tr>
                <td><button type="submit">新建类别</button></td>
            </tr>
        </table>
    </form>
</body>
</html>
