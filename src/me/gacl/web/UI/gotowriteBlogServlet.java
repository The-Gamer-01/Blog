package me.gacl.web.UI;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.Classes;
import me.gacl.domain.Tag;
import me.gacl.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/gotowriteBlogServlet")
public class gotowriteBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserTools tool = new UserTools();
        String userId = ((User) request.getSession().getAttribute("user")).id;
        String sql = "SELECT * FROM classes WHERE classUserId=?";
        ResultSet set = null;
        try {
            set = tool.Select(sql, userId);
            ArrayList<Classes> list = new ArrayList<>();
            while (set.next()) {
                Classes classes = new Classes();
                classes.setClassId(set.getString("classId"));
                classes.setClassUserId(userId);
                classes.setClassName(set.getString("className"));
                classes.setClassText(set.getString("classText"));
                list.add(classes);
            }
            request.getSession().setAttribute("classes",list);
            String sql2 = "SELECT * FROM tags";
            ResultSet set2 = null;
            set2 = tool.Select(sql2);
            ArrayList<Tag> tagList = new ArrayList<>();
            while (set2.next()) {
                Tag tag = new Tag();
                tag.setTagName(set2.getString("tagName"));
                tag.setTagId(set2.getInt("tagId"));
                tagList.add(tag);
            }
            request.getSession().setAttribute("tags",tagList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("http://localhost:8080/Blog/static/pages/writeBlog.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
