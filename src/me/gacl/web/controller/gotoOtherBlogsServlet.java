package me.gacl.web.controller;

import me.gacl.domain.Blog;
import me.gacl.domain.User;
import me.gacl.util.User.userUtl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/gotoOtherBlogsServlet")
public class gotoOtherBlogsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId=request.getParameter("userId");
        System.out.println("userId:"+userId);
        try {
            User otherUser= userUtl.getUser(userId);
            ArrayList<Blog> otherUserBlogs=userUtl.getBlogs(userId);
            request.getSession().setAttribute("otherUser",otherUser);
            request.getSession().setAttribute("otherUserBlogs",otherUserBlogs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("http://localhost:8080/Blog/static/pages/otherUserBlogs.jsp?page=1");
    }
}
