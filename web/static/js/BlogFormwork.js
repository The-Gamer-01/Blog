giveAlike = function (userId,status) {
    if(userId!=null) {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/Blog/giveALikeServlet",
            data: {
                status: status,
                blogId: blogId
            },
            success: function () {
                if (!status)
                alert("点赞成功");
                else
                    alert("取消成功");
            }
        })
        location.href = "http://localhost:8080/Blog/gotoMyBlogServlet?blogId=" + blogId;
    }else{
        alert("请登录后点赞");
    }
}
giveAcomment = function (blogId) {
    if(blogId!=null) {
        var text = $("#commentText").val();
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/Blog/giveAcommentServlet",
            data: {
                blogId: blogId,
                text: text,
                commentLevel:1
            },
            success: function () {
                alert("评论成功");
            }
        });
        location.href="http://localhost:8080/Blog/gotoMyBlogServlet?blogId="+blogId;
    }else{
        alert("请登录后评论");
    }
}

giveTcomment=function(commentId,userId,name){
    if(userId==null){
        alert("请先登录");
    }else {
        var text = prompt('请输入评论');
        if(name!=null)text=userName+"回复"+name+"："+text
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/Blog/giveAcommentServlet",
            data: {
                blogId: blogId,
                text: text,
                commentLevel: 2,
                recommentId: commentId
            },
            success: function () {
                alert("评论成功");
                location.href="http://localhost:8080/Blog/gotoMyBlogServlet?blogId="+blogId;
            }
        });
    }
}

giveAcollect = function (userId) {
    if (userId != null) {
        var col = $('#col').val();
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/Blog/giveAcollectionServlet",
            data: {
                status: col,
                userId, userId,
                blogId: blogId,
            },
            success: function () {
                if (col == "true") {
                    alert("移除收藏成功");
                } else {
                    alert("收藏成功")
                }
            }
        })
        var random = "";
        for (var i = 0; i < 10; i++) {
            random += Math.round(Math.random() * 9);
        }
        location.href = "http://localhost:8080/Blog/gotoMyBlogServlet?blogId=" + blogId;
    }else{
        alert("请登录后评论");
    }
}

function delectComment(commentId,blogId) {
    $.ajax({
       type:"GET",
       url:"http://localhost:8080/Blog/DelectCommentServlet",
       data:{
           commentId:commentId,
           blogId:blogId
       },
       success(){
           alert("删除成功");
           location.href="http://localhost:8080/Blog/gotoMyBlogServlet?blogId="+blogId;
       }
    });
}

function giveAfriend(userId,authorId){
    if(userId==null){
        alert("请先登录");
    }else {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/Blog/giveAfriendServlet",
            data: {
                authorId: authorId,
                userId: userId
            },
            success() {
                alert("关注成功");
                location.href = "http://localhost:8080/Blog/gotoMyBlogServlet?blogId=" + blogId;
            }
        })
    }
}