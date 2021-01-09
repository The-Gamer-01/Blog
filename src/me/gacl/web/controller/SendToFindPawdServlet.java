package me.gacl.web.controller;

import me.gacl.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/SendToFindPawdServlet")
public class SendToFindPawdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String text=request.getParameter("text");
        String pawd=request.getParameter("pawd");
        UserDaoImpl impl=new UserDaoImpl();
        try {
            impl.setPawd(text,pawd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.getWriter().write("" +
                "<script>" +
                "alert('密码已经重置')" +
                "</script>");
        response.sendRedirect("http://localhost:8080/Blog/");
    }
}
