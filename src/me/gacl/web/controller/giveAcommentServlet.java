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
import java.sql.Timestamp;

@WebServlet("/giveAcommentServlet")
public class giveAcommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text=request.getParameter("text");
        String blogId=request.getParameter("blogId");
        User user=(User)request.getSession().getAttribute("user");
        String commentLevel=request.getParameter("commentLevel");
        String recommentId=request.getParameter("recommentId");
        String userId=user.id;
        Timestamp commentTime=new Timestamp(System.currentTimeMillis());
        String commentId="";
        try {
            commentId= random.getCommentId(15);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql="INSERT INTO blogcomment VALUES(?,?,?,?,?,?,?)";
        UserTools tool=new UserTools();
        try {
            tool.Add(sql,commentId,text,commentTime,userId,blogId,commentLevel,recommentId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        response.sendRedirect("http://localhost:8080/Blog/gotoMyBlogServlet?blogId=" + blogId);
    }
}
