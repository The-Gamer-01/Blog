<%--
  Created by IntelliJ IDEA.
  User: 黄乙轩
  Date: 2020/9/16
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <!-- Editor css... -->
    <link rel="stylesheet" href="../mdeditor/css/style.css" />
    <link rel="stylesheet" href="../mdeditor/css/editormd.css" />
    <script src="../mdeditor/js/editormd.min.js"></script>
    <title>编辑博客</title>
    <script type="text/javascript">
        $(document).ready(function () {
            $('.modalBox').load('../html/modalBox.jsp');
        });
        function returnLast(){
            history.go(-1);
        }
    </script>
</head>

<body>
<div class="modalBox"></div>
<button style="float: left;margin-left: 5%" onclick="returnLast()">返回</button>
<form action="http://localhost:8080/Blog/writeBlogServlet" id="htmlform" name=""htmlform method="post">
    <div style="display:none;">作者账号：<input type="text" id="authorId" name="authorId" value="${user.id}"></div>
    <div style="display:none;">作者昵称：<input type="text" id="authorName" name="authorName" value="${user.name}"></div>
    标题:<input type="text" id="title" name="title">
    <button type="button" data-toggle="modal" data-target="#myModal">提交</button>
</form>
<div id="test-editormd">
    <div id="my-editormd">
        <textarea class="editormd-markdown-textarea" name="mdhtml" id="mdhtml" style="display:none;" form="htmlform"></textarea>
        <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
        <textarea class="editormd-html-textarea" name="html" id="html" form="htmlform"></textarea>
    </div>
</div>


<script type="text/javascript">
    var testEditor;
    $(function () {
        testEditor = editormd("my-editormd", {
            placeholder:"开始写博客吧",
            width: "90%",
            height: 640,
            syncScrolling: "single",
            path: "../lib/",
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            saveHTMLToTextarea: true,
            imageUpload: true,
            imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL: "http://localhost:8080/Blog/uploadImage",//注意你后端的上传图片服务地址
            codeFold: true,
            saveHTMLToTextarea: true,
            emoji: true,
            tocm: true, // Using [TOCM]
            onload: function() {
                console.log('onload', this);
            }
        });
    });
</script>
</div>
</body>

</html>