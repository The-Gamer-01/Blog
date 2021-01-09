package Manage.controller;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.Blog;
import me.gacl.domain.User;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/gotoBlogManageServlet")
public class gotoBlogManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search=request.getParameter("search");
        if(search==null) search="";
        String sql="SELECT * FROM blog WHERE blogName LIKE '%"+search+"%';";
        UserTools tool=new UserTools();
        ResultSet set=null;
        try {
            set=tool.Select(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Blog> blogList=new ArrayList<>();
        while(true){
            try {
                if (!set.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Blog blog=new Blog();
            try {
                blog.setBlogLevel(set.getString("blogLevel"));
                blog.setBlogName(set.getString("blogName"));
                blog.setBlogId(set.getString("blogId"));
                blog.setBlogAttribute(set.getString("blogAttribute"));
                blog.setBlogIndex(set.getString("blogIndex"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            blogList.add(blog);
        }
        request.getSession().setAttribute("blogList",blogList);
        response.sendRedirect("http://localhost:8080/Blog/static/pages/BlogManage.jsp");
    }
}
