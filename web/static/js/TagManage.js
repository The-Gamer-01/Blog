function deleteTag(tagId) {
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/Blog/Manage/DelectTagServlet",
        data:{
            tagId:tagId
        },
        success(){
            alert("删除成功")
        }
    })
}
function createTag() {
    var tagName=$("#newtagName").val();
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/Blog/Manage/CreateBlogServlet",
        data:{
            tagName:tagName
        },
        success() {
            alert("创建成功");
            location.reload();
        }
    })
}