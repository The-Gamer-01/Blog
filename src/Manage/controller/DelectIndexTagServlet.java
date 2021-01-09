package Manage.controller;

import me.gacl.domain.Tag;
import me.gacl.util.Index.IndexDelectTag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Manage/DelectIndexTagServlet")
public class DelectIndexTagServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tagId=Integer.valueOf(request.getParameter("tagId"));
        String tagIdstr=request.getParameter("tagId");
        ArrayList<Tag> tags=(ArrayList<Tag>)request.getSession().getAttribute("indextags");
        for(Tag t:tags){
            if(t.getTagId()==tagId){
                tags.remove(t);
                break;
            }
        }
        request.getSession().setAttribute("indextags",tags);
        try {
            IndexDelectTag.delTagBlog(tagIdstr);
            IndexDelectTag.delTag(tagIdstr);
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
