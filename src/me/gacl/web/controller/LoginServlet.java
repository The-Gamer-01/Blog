package me.gacl.web.controller;

import me.gacl.dao.impl.UserDaoImpl;
import me.gacl.domain.Blog;
import me.gacl.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String pawd=request.getParameter("pawd");
        UserDaoImpl impl=new UserDaoImpl();
        User user=null;
        try {
            user=impl.find(id,pawd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(user==null){
            request.getSession().setAttribute("status","空");
            response.getWriter().write("<script>alert('登录失败！');" +
                    "history.go(-1);</script>");
        }else if(user.status==0){
            request.getSession().setAttribute("status","未验证");
            response.getWriter().write("<script>alert('未进行邮箱验证！');" +
                    "window.history.go(-1);" +
                    "</script>");
        }else{
            request.getSession().setAttribute("user",user);
            response.sendRedirect("http://localhost:8080/Blog/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
