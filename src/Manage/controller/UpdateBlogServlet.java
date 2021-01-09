package Manage.controller;

import me.gacl.dao.impl.UserTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Manage/UpdateBlogServlet")
public class UpdateBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String blogId=request.getParameter("blogId");
        String blogLevel=request.getParameter("blogLevel");
        String blogIndex=request.getParameter("blogIndex");
        System.out.println("审核状态："+blogLevel);
        System.out.println("是否推荐："+blogIndex);
        String sql="UPDATE blog SET blogLevel=?,blogIndex=? WHERE blogId=?";
        UserTools tool=new UserTools();
        try {
            tool.Update(sql,blogLevel,blogIndex,blogId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
