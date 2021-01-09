<%@ page import="java.sql.ResultSet" %>
<%@ page import="me.gacl.dao.impl.UserTools" %>
<%@ page import="me.gacl.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/5
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String search = request.getParameter("search");
    String text = request.getParameter("text");
    ResultSet set = null;
    UserTools tool = new UserTools();
    if (text == null || search == "") {
        String sql = "SELECT * FROM user";
        set = tool.Select(sql);
    } else {
        String sql = "SELECT * FROM user WHERE id LIKE '%" + search + "%' OR name LIKE '%" + search + "%'";
        set = tool.Select(sql);
    }
    ArrayList<User> list = new ArrayList<>();
    while (set.next()) {
        User user = new User();
        user.setId(set.getString("id"));
        user.setPawd(set.getString("pawd"));
        user.setName(set.getString("name"));
        user.setSex(set.getInt("sex"));
        user.setBirthday(set.getDate("birthday"));
        user.setEmail(set.getString("email"));
        user.setSayings(set.getString("sayings"));
        user.setHead(set.getString("head"));
        user.setAdministrator(set.getInt("administrator"));
        user.setText(set.getString("text"));
        user.setStatus(set.getInt("status"));
        list.add(user);
    }
%>
<html>
<head>
    <title>用户管理页面</title>
    <link rel="stylesheet" href="../css/UserManage.css">
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="../js/UserManage.js"></script>
    <script>
        updateTab = function (index) {
            var tab = document.getElementById("tab");
            var id = tab.rows[index].cells[0].getElementsByTagName("input")[0].value;
            var name = tab.rows[index].cells[1].getElementsByTagName("input")[0].value;
            var pawd = tab.rows[index].cells[2].getElementsByTagName("input")[0].value;
            var sex = tab.rows[index].cells[3].getElementsByTagName("input")[0].value;
            var email = tab.rows[index].cells[4].getElementsByTagName("input")[0].value;
            var sayings = tab.rows[index].cells[5].getElementsByTagName("input")[0].value;
            var administrator = tab.rows[index].cells[6].getElementsByTagName("input")[0].value;
            var status = tab.rows[index].cells[7].getElementsByTagName("input")[0].value;
            var beforeId = tab.rows[index].cells[8].getElementsByTagName("button")[0].value;
            // var text=tab.rows[index].cells[8].getElementsByTagName("input")[0].value;
            alert("发送前");
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/Blog/Manage/UpdateUserServlet",
                data: {
                    id: id,
                    name: name,
                    pawd: pawd,
                    sex: sex,
                    email: email,
                    sayings: sayings,
                    administrator: administrator,
                    status: status,
                    beforeId, beforeId
                    // text:text,
                    // birthday:birthday
                },
                success: function (data) {
                    alert("成功");
                }
            });
            alert("发送后");
        }
        $(document).ready(function () {
            $('.top').load('../html/top.jsp');
            $('.ManageLeft').load('../html/ManageLeft.jsp');
        });
        function deleteUser(userId) {
            alert("?????");
            $.ajax({
               type:"POST",
               url:"http://localhost:8080/Blog/Manage/UpdateUserServlet",
                data:{
                   userId:userId
                }
            });
        }
    </script>
</head>
<body>
<div class="top"></div>
<div class="ManageLeft"></div>
<div class="col-md-11">
    <input placeholder="请输入用户名或者Id" id="searchUser" name="searchUser">
    <button onclick="search()">搜索</button>
    <div>
        <h1>您所搜索的用户：</h1>
        <table border="1" id="tab" name="tab" cellspacing="1px" class="table table-hover">
            <tr>
                <th>用户Id</th>
                <th>用户名</th>
                <th>用户密码</th>
                <th>用户性别</th>
                <th>用户注册邮箱</th>
                <th>用户签名</th>
                <th>用户权限</th>
                <th>操作</th>
            </tr>
            <% int num = 0;%>
            <c:forEach items="<%=list%>" var="user">
                <%num++;%>
                <tr>
                    <input type="text" value="${user.id}" style="display: none">
                    <td>${user.id}</td>
                    <td><input type="text" value="${user.name}"></td>
                    <td><input type="text" value="${user.pawd}"></td>
                    <td><input type="text" value="${user.sex}"></td>
                    <td><input type="text" value="${user.email}"></td>
                    <td><input type="text" value="${user.sayings}"></td>
                    <td><input type="text" value="${user.administrator}"></td>
                    <td>
                        <button id="but" onclick="updateTab(<%=num%>)" value="${user.id}" class="btn btn-default">修改</button>
                        <button onclick="deleteUser(${user.id})" class="btn btn-default">删除</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
