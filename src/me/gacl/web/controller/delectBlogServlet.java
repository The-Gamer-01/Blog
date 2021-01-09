package me.gacl.web.controller;

import me.gacl.dao.impl.UserTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delectBlogServlet")
public class delectBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String blogId=request.getParameter("blogId");
        String page=request.getParameter("page");
        String sql="DELETE FROM blog WHERE blogId=?;";
        UserTools tool=new UserTools();
        try {
            tool.Delete(sql,blogId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("http://localhost:8080/Blog/getMyBlogsServlet?page=" + page);
    }
}
