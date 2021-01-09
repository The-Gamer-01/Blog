package Manage.controller;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.Tag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Manage/TagServlet")
public class TagServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchTag=request.getParameter("searchTag");
        UserTools tool=new UserTools();
        ResultSet set=null;
        if(searchTag==null){
            String sql="SELECT * FROM tags";
            try {
                set=tool.Select(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            String sql="SELECT * FROM tags WHERE tagName LIKE '%"+searchTag+"%'";
            try {
                set=tool.Select(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ArrayList<Tag> tagList=new ArrayList<>();
        while(true){
            try {
                if (!set.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Tag tag=new Tag();
            try {
                tag.setTagId(set.getInt("tagId"));
                tag.setTagName(set.getString("tagName"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            tagList.add(tag);
        }
        request.getSession().setAttribute("tags",tagList);
        response.sendRedirect("http://localhost:8080/Blog/static/pages/TagManage.jsp");
    }
}
