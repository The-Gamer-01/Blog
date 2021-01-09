package me.gacl.web.controller;

import me.gacl.domain.Ad;
import me.gacl.domain.Blog;
import me.gacl.util.Ads.Ads;
import me.gacl.util.Index.getIndexBlogs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/gotoIndexBlogsServlet")
public class gotoIndexBlogsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tagId=request.getParameter("tagId");
        try {
            ArrayList<Blog> blogs= getIndexBlogs.getIndexBlogs(tagId);
            request.getSession().setAttribute("indextagBlogs",blogs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("http://localhost:8080/Blog/static/pages/IndexBlogsFormwork.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
