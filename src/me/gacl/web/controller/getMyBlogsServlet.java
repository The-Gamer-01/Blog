package me.gacl.web.controller;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.Blog;
import me.gacl.domain.Classes;
import me.gacl.domain.Tag;
import me.gacl.domain.User;
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

@WebServlet("/getMyBlogsServlet")
public class getMyBlogsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String page = request.getParameter("page");
        User user = ((User) request.getSession().getAttribute("user"));
        try {
            int pageNum= Blogutl.getBlogConut(user.id);
            request.getSession().setAttribute("pageNum",pageNum);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int pageSize = 5;
        int intpage = Integer.valueOf(page) - 1;
        String userId = user.id;
        String sql = "SELECT * FROM blog WHERE blogAuthorId=? LIMIT  ?,?;";
        UserTools tool = new UserTools();
        ResultSet set = null;
        try {
            set = tool.Select(sql, userId, intpage * pageSize, pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Blog> arrayList = new ArrayList<>();
        int num = 0;
        try {
            while (set.next()) {
                Blog blog = new Blog();
                blog.setBlogId(set.getString("blogId"));
                blog.setBlogName(set.getString("blogName"));
                blog.setBlogTime(set.getTimestamp("blogTime"));
                blog.setBlogAttribute(set.getString("blogAttribute"));
                blog.setBlogText(set.getString("blogText"));
                blog.setBlogAuthorId(set.getString("blogAuthorId"));
                arrayList.add(blog);
                num++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getClassAndTag(request, response);
        if (num > 0||intpage==0) {
            request.getSession().setAttribute("blog", arrayList);
            response.sendRedirect("http://localhost:8080/Blog/static/pages/myBlogs.jsp?page=" + page);
        } else {
            response.sendRedirect("http://localhost:8080/Blog/getMyBlogsServlet?page=" + intpage);
        }

    }

    public static void getClassAndTag(HttpServletRequest request, HttpServletResponse response){
        UserTools tool = new UserTools();
        String userId = ((User) request.getSession().getAttribute("user")).id;
        String sql = "SELECT * FROM classes WHERE classUserId=?";
        ResultSet set = null;
        try {
            set = tool.Select(sql, userId);
            ArrayList<Classes> list = new ArrayList<>();
            while (set.next()) {
                Classes classes = new Classes();
                classes.setClassId(set.getString("classId"));
                classes.setClassUserId(userId);
                classes.setClassName(set.getString("className"));
                classes.setClassText(set.getString("classText"));
                list.add(classes);
            }
            request.getSession().setAttribute("classes",list);
            String sql2 = "SELECT * FROM tags";
            ResultSet set2 = null;
            set2 = tool.Select(sql2);
            ArrayList<Tag> tagList = new ArrayList<>();
            while (set2.next()) {
                Tag tag = new Tag();
                tag.setTagName(set2.getString("tagName"));
                tag.setTagId(set2.getInt("tagId"));
                tagList.add(tag);
            }
            request.getSession().setAttribute("tags",tagList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
