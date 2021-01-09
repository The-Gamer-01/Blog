function deleteBlog(blogId) {
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/Blog/Manage/DelectBlogServlet",
        data:{
            blogId:blogId
        },
        success(){
            alert("删除成功");
            location.href="http://localhost:8080/Blog/gotoBlogManageServlet";
        }
    });
}
function updateBlog(blogId) {
    var attr=$("#blogLevel option:selected").val();
    var ind=$("#blogIndex option:selected").val();
    alert("审核状态："+attr+" 是否设置为推荐："+ind);
    alert($("#blogLevel option:selected").text());
    alert($("#blogIndex option:selected").text());
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/Blog/Manage/UpdateBlogServlet",
        data:{
            blogId:blogId,
            blogLevel:attr,
            blogIndex:ind
        },
        success() {
            alert("修改成功");
            location.href="http://localhost:8080/Blog/static/pages/Manage.jsp";
        }
    })
}