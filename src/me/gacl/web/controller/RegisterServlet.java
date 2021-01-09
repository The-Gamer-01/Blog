package me.gacl.web.controller;

import me.gacl.dao.impl.UserDaoImpl;
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

/**
 * 思路：若邮箱未注册，那么便直接注册，设置status(状态)为0表示未激活，然后发送激活邮件，点击超链接即可激活
 * 若已注册，便响应一个error表示报错
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        emailimpl emailtools=new emailimpl();
        String name=request.getParameter("name");
        String id= null;
        try {
            id = random.getId(8);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String pawd=request.getParameter("pawd");
        String sex=request.getParameter("sex");
        String birthday=request.getParameter("birthday");
        String email=request.getParameter("email");
        String text=random.getrandom(6);
        String telOremail=request.getParameter("teloremail");
        UserDaoImpl dao=new UserDaoImpl();
        try {
        boolean checkEmailFlag=emailtools.checkEmail(email);
        boolean checkStatusFlag=emailtools.checkStatus(email);
            if((!checkEmailFlag&&!checkStatusFlag)){
                dao.deleteUser(email);
                dao.addUser(id,pawd,name,sex,birthday,email,text,telOremail);
                emailtools.sendemail(email,text);
                response.getWriter().write("" +
                        "<script>" +
                        "alert('您的账号是"+
                        id+
                        "<br>请前往注册邮箱验证');" +
                        "window.location.href=\"http://localhost:8080/Blog\"" +
                        "</script>");
            }else if(checkEmailFlag&&!checkStatusFlag){
                response.getWriter().write("" +
                        "<script>" +
                        "alert('邮箱已被注册，请更换邮箱！');" +
                        "window.history.go(-1);" +
                        "</script>");
            }else {
                dao.setText(text,email);
                emailtools.sendemail(email,text);
                id=dao.find(email).id;
                response.getWriter().write("" +
                        "<script>" +
                        "alert('您的账号是" +
                        id +
                        "请前往注册邮箱验证');" +
                        "window.location.href=\"http://localhost:8080/Blog\"" +
                        "</script>");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
