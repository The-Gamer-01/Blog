package me.gacl.util.User;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.Blog;
import me.gacl.domain.User;
import me.gacl.util.Blog.Blogutl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class userUtl {
    public static UserTools tool=new UserTools();

    public static User getUser(String userId) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM user WHERE id=?";
        System.out.println("userIdSS:"+userId);
        ResultSet set=tool.Select(sql,userId);
        if(set==null){
            System.out.println("空后");
        }
        User user=new User();
        while(set.next()){
            user.setName(set.getString("name"));
            user.setHead(set.getString("head"));
        }
        return user;
    }

    public static ArrayList<Blog> getBlogs(String userId) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM blog WHERE blogAuthorId=?";
        ResultSet set=tool.Select(sql,userId);
        ArrayList<Blog> blogs=new ArrayList<>();
        while(set.next()){
            Blog blog=new Blog();
            blog.setBlogName(set.getString("blogName"));
            blog.setBlogId(set.getString("blogId"));
            blog.setBlogVisit(set.getInt("blogVisits"));
            blog.setLikesNum(Blogutl.getLikesNum(blog.getBlogId()));
            blogs.add(blog);
        }
        return blogs;
    }
}
