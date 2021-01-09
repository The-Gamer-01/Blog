package me.gacl.web.controller;

import me.gacl.dao.impl.UserTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/giveAcollectionServlet")
public class giveAcollectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        String userId = request.getParameter("userId");
        String blogId = request.getParameter("blogId");
        UserTools tool = new UserTools();
        boolean flag = Boolean.valueOf(status);
        System.out.println("状态："+flag);
        if (flag) {
            String sql="DELETE FROM collection WHERE userid=? AND blogId=?";
            try {
                tool.Delete(sql,userId,blogId);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            String sql = "INSERT INTO collection VALUES(?,?);";
            try {
                tool.Add(sql, userId, blogId);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            response.getWriter().write("" +
                    "<script>" +
                    "history.go(-1);" +
                    "</script>");
        }
    }
}
