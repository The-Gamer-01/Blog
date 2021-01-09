package me.gacl.web.controller;

import me.gacl.dao.impl.UserTools;
import me.gacl.util.Blog.Blogutl;
import me.gacl.util.file.upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet("/updateBlogServlet")
public class updateBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String blogName=request.getParameter("title");
        String blogMd=request.getParameter("mdhtml");
        String html=request.getParameter("html");
        Timestamp blogTime=new Timestamp(System.currentTimeMillis());
        String blogId=request.getParameter("blogId");
        String[] blogLabel=request.getParameterValues("blogLabel");
        String blogLevel=request.getParameter("blogLevel");
        String blogAttribute=request.getParameter("Attribute");
        String classId=request.getParameter("cla");
        String blogReprint=request.getParameter("rep");
        if(classId==null) classId="0";
        String sql="UPDATE blog SET blogName=?,blogMd=?,blogTime=?,blogAttribute=?,blogLevel=1,blogClass=? WHERE blogId=?;";
        UserTools tool=new UserTools();
        try {
            tool.Update(sql,blogName,blogMd,blogTime,blogAttribute,classId,blogId);
            Blogutl.UpdateBlogTag(blogId,blogLabel);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String filePath="D:\\Blog\\html\\"+blogId+".html";
        upload.upfile(html,filePath);
        String txtPath="D:\\Blog\\md\\"+blogId+".txt";
        upload.upfile(blogMd,txtPath);
        System.out.println("filePath:"+filePath);
        System.out.println("texPath:"+txtPath);
        response.sendRedirect("http://localhost:8080/Blog/static/pages/BlogFormwork.jsp?blogId="+blogId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
