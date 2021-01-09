package me.gacl.web.controller;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/giveALikeServlet")
public class giveALikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean status = Boolean.valueOf(request.getParameter("status"));
        User user = (User) request.getSession().getAttribute("user");
        String userId = user.id;
        String blogId = request.getParameter("blogId");
        UserTools tool = new UserTools();
        System.out.println("status:" + status);
        System.out.println("blogId:" + blogId);
        try {
            if (status) {
                System.out.println("删除");
                String sql="DELETE FROM likes WHERE userid=?";
                tool.Delete(sql,userId);
            } else {
                System.out.println("增加");
                String sql = "INSERT INTO likes VALUES(?,?);";
                tool.Add(sql, userId, blogId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
