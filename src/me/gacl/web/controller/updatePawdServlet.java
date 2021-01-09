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

@WebServlet("/updatePawdServlet")
public class updatePawdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pawd=request.getParameter("pawd");
        User user=(User)request.getSession().getAttribute("user");
        String userId=user.id;
        String sql="UPDATE user SET pawd=? WHERE id=?";
        UserTools tool=new UserTools();
        try {
            tool.Update(sql,pawd,userId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("http://localhost:8080/Blog/static/pages/User.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
