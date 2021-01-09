package me.gacl.web.controller;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.Blog;
import me.gacl.domain.User;
import me.gacl.util.random.random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/getMyCollectionServlet")
public class getMyCollectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("?");
        User user=(User)request.getSession().getAttribute("user");
        String sql="SELECT * FROM blog INNER JOIN collection ON blogAuthorId=userid AND blog.blogId=collection.blogid AND userid=?;";
        UserTools tool=new UserTools();
        ResultSet set= null;
        try {
            set = tool.Select(sql,user.id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Blog> list=new ArrayList<Blog>();
        while(true){
            try {
                if (!set.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Blog blog=new Blog();
            try {
                blog.setBlogId(set.getString("blogId"));
                blog.setBlogName(set.getString("blogName"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            list.add(blog);
        }
        request.getSession().setAttribute("mycollection",list);
        response.sendRedirect("http://localhost:8080/Blog/static/pages/myCollections.jsp?random="+ random.getRandomNum(10));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
