<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/10/18
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script>
        function send() {
            var name=$("#className").val();
            var text=$("#classText").val();
            $.ajax({
                type:"GET",
                url:"http://localhost:8080/Blog/createClassServlet",
                data:{
                    name:name,
                    text:text
                },
                success(){
                    alert('创建成功');
                    location.href="http://localhost:8080/Blog/static/pages/myClasses.jsp?page=1";
                }
            })
        }
    </script>
</head>
<body>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新建类别</h4>
            </div>
            <div class="modal-body" >
                <div class="input-group input-group-lg">
                <table class="table">
                    <tr>
                        <th>新建类别名：</th>
                        <td>
                            <input type="text" id="className" name="className" placeholder="类别名" class="form-control">
                        </td>
                    </tr>
                    <tr>
                        <th><label>类别介绍：</label></th>
                        <th>
                            <input class="form-control" type="text" id="classText" name="classText" placeholder="类别介绍..." style="height: 100px">
                        </th>
                    </tr>
                </table>
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
