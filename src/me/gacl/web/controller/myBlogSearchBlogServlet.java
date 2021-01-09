package me.gacl.web.controller;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.Blog;
import me.gacl.domain.Tag;
import me.gacl.domain.User;
import me.gacl.util.Blog.Blogutl;
import me.gacl.util.time.time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/myBlogSearchBlogServlet")
public class myBlogSearchBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String blogAttribute = request.getParameter("blogAttribute");
        String blogAuthorId = ((User) request.getSession().getAttribute("user")).id;
        String blogClass = request.getParameter("blogClasses");
        String blogTime = request.getParameter("date");
        String blogTag = request.getParameter("blogTag");
        if(blogTime==null) blogTime="";
        if(blogClass==null) blogClass="0";
        if(blogAttribute==null) blogAttribute="不限";
        if(blogTag==null) blogTag="0";

        String sql = "SELECT * FROM blog";
        UserTools tool = new UserTools();
        ResultSet set = null;
        try {
            set = tool.Select(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Blog> blogList = new ArrayList<>();
        Date date = new Date();
        if(!blogTime.equals(""))
        try {
            date = time.stringTodate(blogTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (!set.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Blog blog = new Blog();
            try {
                blog.setBlogTime(set.getTimestamp("blogTime"));
                blog.setBlogId(set.getString("blogId"));
                blog.setBlogName(set.getString("blogName"));
                blog.setBlogAttribute(set.getString("blogAttribute"));
                blog.setBlogClass(set.getString("blogClass"));
                blog.setBlogTags(Blogutl.getTags(blog.getBlogId()));
                Date blogDate = blog.blogTime;
                boolean flag = true;
                if (!blogTime.equals(""))
                    if (blogDate.getYear() != date.getYear() || blogDate.getMonth() != date.getMonth() || blogDate.getDay() != date.getDay()) {
                        flag=false;
                    }
                if(!blogClass.equals("0"))
                    if(!blog.getBlogClass().equals(blogClass)){
                        flag=false;
                    }
                if(!blogAttribute.equals("不限"))
                    if(!blog.getBlogAttribute().equals(blogAttribute)) {
                        flag=false;
                    }
                boolean temp=true;
                if(!blogTag.equals("0")){
                    for(Tag t:blog.getBlogTags()){
                        if(t.getTagId()==Integer.valueOf(blogTag)){
                            System.out.println("t.id:"+t.getTagId());
                            System.out.println("blogTag:"+Integer.valueOf(blogTag));
                            temp=false;
                            break;
                        }
                    }
                }else{
                    System.out.println("为空");
                    temp=false;
                }
                if(flag&&!temp)
                    blogList.add(blog);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        for(Blog b:blogList){
            System.out.println(b.blogName);
        }
        request.getSession().setAttribute("blog", blogList);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
