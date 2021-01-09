package me.gacl.web.controller;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.User;
import me.gacl.util.random.random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/createClassServlet")
public class createClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String text=request.getParameter("text");
        String userId=((User)request.getSession().getAttribute("user")).id;
        String id="";
        try {
            id= random.getClassId(10);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql="INSERT INTO classes VALUES(?,?,?,?)";
        UserTools tool=new UserTools();
        try {
            tool.Add(sql,name,userId,id,text);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
