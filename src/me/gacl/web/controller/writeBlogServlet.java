package me.gacl.web.controller;

import me.gacl.dao.impl.UserDaoImpl;
import me.gacl.dao.impl.UserTools;
import me.gacl.domain.Blog;
import me.gacl.domain.User;
import me.gacl.util.file.upload;
import me.gacl.util.random.random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

@WebServlet("/writeBlogServlet")
public class writeBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String html=request.getParameter("html");
        String title=request.getParameter("title");
        String id=request.getParameter("authorId");
        String name=request.getParameter("authorName");
        String mdhtml=request.getParameter("mdhtml");
        Timestamp blogTime=new Timestamp(System.currentTimeMillis());
        String blogAttribute=request.getParameter("Attribute");
        String blogId=new String();
        String[] blogLabel=request.getParameterValues("blogLabel");
        String blogLevel=request.getParameter("blogLevel");
        String classId=request.getParameter("cla");
        if(classId==null) classId="0";
        String blogReprint=request.getParameter("rep");
        try {
            blogId= random.getId(15);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Blog blog=new Blog();
        blog.setBlogAttribute(blogAttribute);
        blog.setBlogAuthor(name);
        blog.setBlogAuthorId(id);
        blog.setBlogId(blogId);
        blog.setBlogName(title);
        blog.setBlogTime(blogTime);
        blog.setBlogMd(mdhtml);
        UserTools tool=new UserTools();
        if(blogLabel!=null)
        for(String s:blogLabel){
            String sql="INSERT INTO blogcontag VALUES(?,?)";
            try {
                tool.Add(sql,blogId,s);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        UserDaoImpl impl=new UserDaoImpl();
        String filePath="D:\\Blog\\html\\"+blog.blogId+".html";
        try {
            impl.addBlog(blogId,title,blogTime,blogAttribute,filePath,id,blogLevel,mdhtml,classId,blogReprint);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        upload.upfile(html,filePath);
        String mdhtmlFilepath="D:\\Blog\\md\\"+blog.blogId+".txt";
        upload.upfile(mdhtml,mdhtmlFilepath);
        User user=(User)request.getSession().getAttribute("user");
        user.blogs.add(blog);
        response.sendRedirect("http://localhost:8080/Blog/gotoMyBlogServlet?blogId="+blogId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
