updateUser=function () {
    document.getElementById("div1").style.display="none";
    document.getElementById("div2").style.display="block";
    document.getElementById("save").style.display="block";
    document.getElementById("update").style.display="none";
}
saveUser=function () {
    document.getElementById("div1").style.display="block";
    document.getElementById("div2").style.display="none";
    document.getElementById("save").style.display="none";
    document.getElementById("update").style.display="block";
    function f() {
        var name=$("#name").val();
        var pawd=$("#pawd").val();
        var text=$("#text").val();
        var birthday=$("#birthday").val();
        var telOremail=$("#telOremail").val();
        alert(telOremail);
        $.ajax({
            type:"POST",
            url:"http://localhost:8080/Blog/updateUserServlet",
            data:{
                name:name,
                pawd:pawd,
                text:text,
                birthday:birthday,
                telOremail:telOremail
            },
            success:function (data) {
                location.reload();
            }
        });
    }
    f();
    var fileObj=$("#file")[0].files[0];
    var form=new FormData();
    var url="http://localhost:8080/Blog/upHeadServlet";
    form.append("head",fileObj);
    var xhr=new XMLHttpRequest();
    xhr.open("post",url,true);
    xhr.onload=function () {
        alert("上传完成");
    }
    xhr.send(form);
}
function viewImage(file) {
    var preview = document.getElementById('upHead');
    if (file.files && file.files[0]) {
        //火狐下
        preview.style.display = "block";
        preview.style.width = "350px";
        preview.style.height = "350px";
        preview.src = window.URL.createObjectURL(file.files[0]);
    } else {
        //ie下，使用滤镜
        file.select();
        var imgSrc = document.selection.createRange().text;
        var localImagId = document.getElementById("upHead");
        //必须设置初始大小
        localImagId.style.width = "350px";
        localImagId.style.height = "350px";
        try {
            localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            locem("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
        } catch (e) {
            alert("您上传的图片格式不正确，请重新选择!");
            return false;
        }
        // preview.style.display = 'none';
        document.selection.empty();
    }
    var head=document.getElementById('head');
    head.style.textAlign="center";
    return true;
}
function updatePawd() {
    location.href="http://localhost:8080/Blog/static/pages/updatePawd.jsp";
}