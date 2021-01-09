function saveBlog() {
    var blogLevel=$("#blogLevel option:selected").val();
    var indexBlog=$("#indexBlog option:selected").val();
    var indexTag=$("#indexTag option:selected").val();
    $.ajax({
       type:"POST",
       url:"http://localhost:8080/Blog/Manage/ManageUpdateBlogServlet",
       data:{
           Level:blogLevel,
           indexBlog:indexBlog,
           indexTag:indexTag,
           blogId:blogId
       },
       success(){
            alert('修改成功');
       }
    });
}