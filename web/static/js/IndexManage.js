function createIndexClass() {
    var text=$('#newTag').val();
    $.ajax({
       type:"GET",
       url:"http://localhost:8080/Blog/Manage/CreateIndexTagServlet",
       data:{
           text:text
       } ,
       success(){
           alert('创建成功');
           location.href="http://localhost:8080/Blog/Manage/IndexServlet";
       }
    });
}

function deleteIndexTag(tagId) {
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/Blog/Manage/DelectIndexTagServlet",
        data:{
            tagId:tagId
        },
        success() {
            alert("删除成功");
            location.href="http://localhost:8080/Blog/Manage/IndexServlet";
        }
    })
}