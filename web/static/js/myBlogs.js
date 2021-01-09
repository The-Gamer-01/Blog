$(document).ready(function () {
    $('.top').load('../html/top.jsp');
});
$(document).ready(function () {
    $('.left').load('../html/left.jsp');
})
var Request = new Object();
Request = GetRequest();
var pages = Request[Request.length - 1];

function GetRequest() {
    var url = location.search;
    return url;
}

function left() {
    if (pageNum == 1) {
        alert("此为第一页");
    } else {
        pageNum--;
        location.href = "http://localhost:8080/Blog/getMyBlogsServlet?page=" + pageNum;
    }
}

function right() {
    pageNum++;
    location.href = "http://localhost:8080/Blog/getMyBlogsServlet?page=" + pageNum;
}

function delect(blogId) {
    location.href = "http://localhost:8080/Blog/delectBlogServlet?blogId=" + blogId + "&page=" + pages;
}

function update(blogId) {
    location.href = "http://localhost:8080/Blog/static/pages/updateBlog.jsp?blogId=" + blogId;
}

function search() {
    var date = $("#date").val();
    var blogAttribute = $("#blogAttribute").val();
    var blogClasses = $("#blogClasses").val();
    var blogTag=$('#blogTag').val();
    alert(blogTag);
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/Blog/myBlogSearchBlogServlet",
        data: {
            date: date,
            blogAttribute: blogAttribute,
            blogClasses: blogClasses,
            blogTag:blogTag
        },
        success() {
            alert("查询成功");
            location.href="http://localhost:8080/Blog/static/pages/myBlogs.jsp?page=1";
        }
    });
}

function gotoPageNum(pageCount) {
    location.href="http://localhost:8080/Blog/getMyBlogsServlet?page="+pageCount;
}