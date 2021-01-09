function delect(blogId) {
    var random="";
    for(var i=0;i<10;i++){
        random+=Math.round(Math.random()*9);
    }
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/Blog/DelFromClaServlet",
        data:{
            blogId:blogId
        },
        success(){
            alert("博客已移到默认专栏");
            location.href="http://localhost:8080/Blog/static/pages/ClassFormwork.jsp?classId="+classId+"&random="+random;
            location.reload();
        }
    });
}