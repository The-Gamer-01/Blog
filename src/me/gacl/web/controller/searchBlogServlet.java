package me.gacl.web.controller;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.Blog;
import me.gacl.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "searchBlogServlet")
public class searchBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text=request.getParameter("text");
        String userId=request.getParameter("userId");
        String sql=new String();
        if (userId == null || userId == "") {
            sql="SELECT FROM blog WHERE blogName=?;";
        }else{
            sql="SELECT FROM blog WHERE blogAuthorId=? AND blogName=? AND blogLevel=1;";
        }
        UserTools tool=new UserTools();
        ResultSet set=null;
        try {
            set=tool.Select(sql,text,userId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Blog> arrayList=new ArrayList<>();
        try {
            while(set.next()){
                Blog blog=new Blog();
                blog.setBlogId(set.getString("blogId"));
                blog.setBlogName(set.getString("blogName"));
                blog.setBlogTime(set.getTimestamp("blogTime"));
                blog.setBlogAttribute(set.getString("blogAttribute"));
                blog.setBlogText(set.getString("blogText"));
                blog.setBlogAuthorId(set.getString("blogAuthorId"));
                arrayList.add(blog);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getSession().setAttribute("blog",arrayList);
    }
}
