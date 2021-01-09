package me.gacl.web.controller;

import me.gacl.dao.impl.UserDaoImpl;
import me.gacl.dao.impl.UserTools;
import me.gacl.domain.User;
import me.gacl.util.file.upload;
import me.gacl.util.time.time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/updateUserServlet")

public class updateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("updateUserServlet");
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String pawd=request.getParameter("pawd");
        System.out.println("pawd:"+pawd);
        String text=request.getParameter("text");
        String birthday=request.getParameter("birthday");
        String telOremail=request.getParameter("telOremail");
        User user= (User) request.getSession().getAttribute("user");
        String userId=user.id;
        String updateUsersql="UPDATE user SET name=?,pawd=?,sayings=?,birthday=?,telOremail=? WHERE id=?;";
        String updateBlogsql="UPDATE blog SET blogAuthorId=? WHERE blogAuthorId=?;";
        UserTools tools=new UserTools();
        try {
            System.out.println("更新");
            tools.Update(updateUsersql,name,pawd,text,birthday,telOremail,userId);
            tools.Update(updateBlogsql,userId,userId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        user.name=name;
        user.pawd=pawd;
        user.sayings=text;
        user.birthday= Date.valueOf(birthday);
        user.setTelOremail(telOremail);
        request.getSession().setAttribute("user",user);
        response.getWriter().write("<script>" +
                "alert('修改成功');" +
                "history.go(-1);" +
                "location.reload();" +
                "</script>");
//        response.sendRedirect("http://localhost:8080/Blog/static/pages/User.jsp");
//        response.setContentType("text/html; charset=utf-8");
//        request.setCharacterEncoding("utf-8");
//        System.out.println("get");
//        try {
//            upload.uphead(request,response);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
