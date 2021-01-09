package me.gacl.web.controller;

import me.gacl.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/SendemailServlet")
public class SendemailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String text=request.getParameter("text");
        UserDaoImpl impl=new UserDaoImpl();
        boolean flag=true;
        try {
            flag=impl.setStatu(text);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(flag) {
            response.getWriter().write("<script>" +
                    "alert('验证成功');" +
                    "location.href='http://localhost:8080/Blog/'" +
                    "</script>");
        }else{
            response.getWriter().write("<script>" +
                    "alert('验证失败，请点击最新的验证链接');" +
                    "location.href='http://localhost:8080/Blog/'" +
                    "</script>");
        }
    }
}
