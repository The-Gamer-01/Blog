giveAlike=function () {
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/Blog/giveALikeServlet",
        data:{status:"<%=status%>",
        blogId:blogId},
        success:function () {
            alert("点赞成功");
        }
    })
}
giveAcomment=function () {
    var text=$("#commentText").val();
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/Blog/giveAcommentServlet",
        data:{
            blogId:blogId,
            text:text
        },
        success:function () {
            alert("评论成功");
        }
    })
}
