package Manage.controller;

import me.gacl.dao.impl.UserTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Manage/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String beforeId=request.getParameter("beforeId");
       String id=request.getParameter("id");
       String name=request.getParameter("name");
       String pawd=request.getParameter("pawd");
       String sex=request.getParameter("sex");
       String email=request.getParameter("email");
       String sayings=request.getParameter("sayings");
       String administrator=request.getParameter("administrator");
       String status=request.getParameter("status");
       String sql="UPDATE user SET id=?,name=?,pawd=?,sex=?,email=?,sayings=?,administrator=?,status=? WHERE id=?";
       UserTools tool=new UserTools();
        try {
            tool.Update(sql,id,name,pawd,sex,email,sayings,administrator,status,beforeId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("修改成功");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
