package me.gacl.web.controller;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/DeleteCollectionServlet")
public class DeleteCollectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String blogId=request.getParameter("blogId");
        String userId=((User)request.getSession().getAttribute("user")).id;
        String sql="DELETE FROM collection WHERE blogId=? AND userid=?;";
        UserTools tool=new UserTools();
        try {
            tool.Delete(sql,blogId,userId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
