package Manage.controller;

import me.gacl.util.Index.ManageUpdateBlog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Manage/ManageUpdateBlogServlet")
public class ManageUpdateBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String blogLevel=request.getParameter("Level");
        String indexBlog=request.getParameter("indexBlog");
        String indexTag=request.getParameter("indexTag");
        String blogId=request.getParameter("blogId");
        try {
            ManageUpdateBlog.deleteBlogIndexTag(blogId);
            ManageUpdateBlog.setBlogIndexTag(blogId,indexTag);
            ManageUpdateBlog.updateBlog(blogId,blogLevel,indexBlog);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
