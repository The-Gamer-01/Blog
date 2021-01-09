<%@ page import="me.gacl.dao.impl.UserTools" %>
<%@ page import="me.gacl.domain.User" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="me.gacl.domain.Classes" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="me.gacl.domain.Tag" %><%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/9/20
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script>
        function send() {
            $("#htmlform").submit();
        }
        function displayDiv() {
            $("#otherhref").style.display="none";
        }
        function playDiv() {
            $("#otherhref").style.display="block";
        }
        function test() {
            var attr=$("#Attribute").val();
            var td=$("#hreftd");
            var th=$("#hrefth");
            if(attr=="转载"){
                td.css('display','');
                th.css('display','');
            }else {
                td.css('display','none');
                th.css('display','none');
            }
        }
    </script>
</head>
<body>
<div id="box"></div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">提交博客</h4>
            </div>
            <div class="modal-body">
                <table>
                    <tr>
                        <th>文章标签：</th>
                        <td>
                            <c:forEach items="${tags}" var="tag">
                                ${tag.tagName}<input type="checkbox" value="${tag.tagId}" id="blogLabel" name="blogLabel" form="htmlform">
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <th><label>分类专栏：</label></th>
                        <th>
                            <div style="width: 450px ; height: 200px; border: 1px solid black;">
                                <p>只能选一个分类专栏</p>
                                <hr />
                                <c:forEach items="${classes}" var="cla">
                                    <input type="radio" id="cla" name="cla" value="${cla.classId}" form="htmlform">${cla.className}<br>
                                </c:forEach>
                            </div>
                        </th>
                    </tr>
                    <tr>
                        <th>文章类型：</th>
                        <td>
                        <select form="htmlform" id="Attribute" name="Attribute" onchange=test()>
                            <option value="原创" onclick="displayDiv()">原创</option>
                            <option value="转载" onclick="playDiv()">转载</option>
                            <option value="翻译" onclick="displayDiv()">翻译</option>
                        </select>
                        </td>
                    </tr>
                    <tr id="otherhref" name="otherhref" >
                        <th style="display: none" id="hrefth">转载链接：</th>
                        <td style="display: none" id="hreftd"><input type="text" placeholder="转载链接" form="htmlform" id="rep" name="rep"></td>
<%--                        <td><input type="text"></td>--%>
                    </tr>
                    <tr>
                        <th>发布形式：</th>
                        <td>
                            <input type="radio" value="1" checked form="htmlform" id="blogLevel" name="blogLevel">公开
                            <input type="radio" value="2" form="htmlform" id="blogLevel" name="blogLevel">私密
<%--                            <input type="radio" name="Attribute" value="3">--%>
                        </td>
                    </tr>
                </table>
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
