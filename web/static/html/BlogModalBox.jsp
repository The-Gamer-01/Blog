<%@ page import="java.util.ArrayList" %>
<%@ page import="me.gacl.domain.Tag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/15
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Tag> indexTags=(ArrayList<Tag>)request.getSession().getAttribute("indextags");
%>
<html>
<head>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="../js/BlogModalBox.js"></script>
</head>
<body>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h1>管理员编辑</h1>
            </div>
            <div class="modal-body">
                <table>
                    <tr>
                        <th>博客审核</th>
                        <td>
                            <select id="blogLevel" name="blogLevel">
                                <option value="0">已发表</option>
                                <option value="1">审核中</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>博客首页推荐</th>
                        <td>
                            <select id="indexBlog" name="indexBlog">
                                <option value="1">是</option>
                                <option value="0">否</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>首页标签设置</th>
                        <td>
                            <select id="indexTag" name="indexTag">
                                <option>无选择</option>
                                <c:forEach items="<%=indexTags%>" var="tag">
                                    <option value="${tag.tagId}">${tag.tagName}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button>取消</button>
                <button onclick="saveBlog()">提交</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
