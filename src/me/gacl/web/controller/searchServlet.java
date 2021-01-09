package me.gacl.web.controller;

import me.gacl.domain.Blog;
import me.gacl.domain.User;
import me.gacl.util.Blog.Blogutl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        if (search != "" && search != null) {
            String status = request.getParameter("status");
            ArrayList<Blog> bloglist = Blogutl.searchBlog(search);
            request.getSession().setAttribute("search", bloglist);
            ArrayList<User> userlist = Blogutl.searchUser(search);
            request.getSession().setAttribute("searchuser", userlist);
            response.sendRedirect("http://localhost:8080/Blog/static/pages/Seach.jsp?status=" + status);
        }else{
            response.getWriter().write("" +
                    "<script>" +
                    "history.go(-1);" +
                    "alert('请不要输入空')" +
                    "</script>");
        }
    }
}
