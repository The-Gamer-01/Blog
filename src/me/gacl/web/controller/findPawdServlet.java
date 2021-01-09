package me.gacl.web.controller;

import me.gacl.dao.impl.UserTools;
import me.gacl.util.email.emailimpl;
import me.gacl.util.random.random;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;

@WebServlet("/findPawdServlet")
public class findPawdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String pawd=request.getParameter("pawd");
        String text= random.getrandom(6);
        String sql="UPDATE user SET text=? WHERE email=?";
        UserTools tool=new UserTools();
        try {
            tool.Update(sql,text,email);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        emailimpl emailtools=new emailimpl();
        try {
            emailtools.findpawd(email,text,pawd);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
