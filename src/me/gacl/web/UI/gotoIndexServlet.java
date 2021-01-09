package me.gacl.web.UI;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.Ad;
import me.gacl.domain.Blog;
import me.gacl.domain.Tag;
import me.gacl.util.Ads.Ads;
import me.gacl.util.Blog.Blogutl;
import me.gacl.util.Index.getIndexTags;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/gotoIndexServlet")
public class gotoIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql="SELECT * FROM blog INNER JOIN user ON blogAuthorId=id AND blogIndex=1;";
        UserTools tool=new UserTools();
        ResultSet set=null;
        ArrayList<Blog> blogs=new ArrayList<>();
        try {
            set=tool.Select(sql);
            while(set.next()){
                Blog blog=new Blog();
                blog.setBlogId(set.getString("blogId"));
                blog.setBlogName(set.getString("blogName"));
                blog.setLikesNum(Blogutl.getLikesNum(blog.getBlogId()));
                blog.setBlogVisit(set.getInt("blogVisits"));
                blog.setBlogAttribute(set.getString("blogAttribute"));
                blog.setAuthor(Blogutl.getBlogAuthor(set.getString("id")));
                blogs.add(blog);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("index",blogs);
        try {
            ArrayList<Tag> tags= getIndexTags.getIndexTags();
            request.getSession().setAttribute("indextags",tags);
            ArrayList<Ad> ads= Ads.getAds();
            request.getSession().setAttribute("ads",ads);
            sql="SELECT * FROM blog INNER JOIN user ON blogAuthorId=id WHERE blogLevel=0 ORDER BY blogVisits DESC";
            set=tool.Select(sql);
            ArrayList<Blog> headBlogs=new ArrayList<>();
            while(set.next()){
                Blog blog=new Blog();
                blog.setBlogId(set.getString("blogId"));
                blog.setBlogName(set.getString("blogName"));
                blog.setLikesNum(Blogutl.getLikesNum(blog.getBlogId()));
                blog.setBlogVisit(set.getInt("blogVisits"));
                blog.setBlogAttribute(set.getString("blogAttribute"));
                blog.setAuthor(Blogutl.getBlogAuthor(set.getString("id")));
                headBlogs.add(blog);
            }
            request.getSession().setAttribute("headBlogs",headBlogs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("http://localhost:8080/Blog/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
