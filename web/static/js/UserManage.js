search=function () {
    var random="";
    for(var i=0;i<10;i++){
        random+=Math.round(Math.random()*9);
    }
    location.href="http://localhost:8080/Blog/static/pages/UserManage.jsp?search="+$("#searchUser").val()+"&text="+random;
}
