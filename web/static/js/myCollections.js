function delectCol(blogId) {
    $.ajax({
       type:'GET',
        url:'http://localhost:8080/Blog/DeleteCollectionServlet',
        data:{
           blogId:blogId
        },
        success(){
           alert('删除成功');
           location.href="http://localhost:8080/Blog/getMyCollectionServlet";
        }
    });
}