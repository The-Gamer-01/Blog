package me.gacl.web.controller;

import me.gacl.dao.impl.UserDaoImpl;
import me.gacl.dao.impl.UserTools;
import me.gacl.domain.*;
import me.gacl.util.Blog.Blogutl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/gotoMyBlogServlet")
public class gotoMyBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserTools tool=new UserTools();
        String blogId=request.getParameter("blogId");
        User user=(User)request.getSession().getAttribute("user");
        String sql1="SELECT * FROM blog WHERE blogId=?;";
        Blog blog=new Blog();
        try {
            ResultSet set1=tool.Select(sql1,blogId);
            if(set1.next()){
                  blog.setBlogId(blogId);
                  blog.setBlogName(set1.getString("blogName"));
                  blog.setBlogTime(set1.getTimestamp("blogTime"));
                  blog.setBlogAttribute(set1.getString("blogAttribute"));
                  blog.setBlogTags(Blogutl.getTags(blog.blogId));
                  blog.setBlogcomments(Blogutl.getComments(blog.blogId));
                  blog.setLikesNum(Blogutl.getLikesNum(blogId));
                  if(user!=null)
                      blog.setUserLike(Blogutl.checkLike(user.id,blogId));
                  else
                      blog.setUserLike(false);
                  blog.setBlogVisit(set1.getInt("blogVisits")+1);
                  blog.setBlogReprint(set1.getString("blogReprint"));
                  String sql2="UPDATE blog SET blogVisits=? WHERE blogId=?";
                  tool.Update(sql2,blog.getBlogVisit(),blogId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("seeingBlog",blog);
        User Author= Blogutl.getAuthor(blogId);
        request.getSession().setAttribute("author",Author);
        response.sendRedirect("http://localhost:8080/Blog/static/pages/BlogFormwork.jsp?blogId="+blogId);
    }
}
