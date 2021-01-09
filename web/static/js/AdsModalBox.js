function showImg() {
    var showDiv=document.getElementById("textDiv");
    var imgsrc=viewImage(document.getElementById("upimg"));
    var htmlText='<div id="textDiv">\n' +
        '                    <img id="bgimg" src="' +
        imgsrc +
        '" alt="..." style="text-align: center;height: 429px;width: 100%;">\n' +
        '                    <div class="carousel-caption">\n' +
        '                        <h1>' +
        $("#Adtitle").val() +
        '</h1>\n' +
        '                        <p>' +
        $("#AdP").val() +
        '</p>\n' +
        '                    </div>\n' +
        '                </div>'
    showDiv.innerHTML=htmlText;
}
function viewImage(file) {
    var src=window.URL.createObjectURL(file.files[0]);
    return src;
}

function send() {
    updata();
    uphead();
    location.href="http://localhost:8080/Blog/static/pages/AdsManage.jsp";
}
function uphead() {
    var fileObj=$("#upimg")[0].files[0];
    var form=new FormData();
    var url="http://localhost:8080/Blog/UpAdBackgroudServlet";
    form.append("head",fileObj);
    var xhr=new XMLHttpRequest();
    xhr.open("post",url,true);
    xhr.onload=function () {
        alert("上传完成");
    }
    xhr.send(form);
}

function updata() {
    var head=$("#Adtitle").val();
    var p=$("#AdP").val();
    var AdHyperlink=$("#AdHyperlink").val();
    var img=document.getElementById("upimg").files[0].name;
    alert(img);
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/Blog/UpdateAdDataServlet",
        data:{
            head:head,
            p:p,
            AdHyperlink:AdHyperlink,
            img:img
        }
    })
}

function deleteImg(AdId) {
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/Blog/Manage/DeleteAdServlet",
        data:{
            AdId:AdId
        },
        success(){
            alert('删除成功');
            location.href="http://localhost:8080/Blog/static/pages/AdsManage.jsp";
        }
    })
}