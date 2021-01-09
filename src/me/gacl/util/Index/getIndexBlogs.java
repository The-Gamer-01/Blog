package me.gacl.util.Index;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.Blog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class getIndexBlogs {
    public static UserTools tool=new UserTools();
    public static ArrayList<Blog> getIndexBlogs(String tagId) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM blog INNER JOIN indexconblog ON blog.blogId=indexconblog.blogId WHERE tagId=?;";
        ArrayList<Blog> blogs=new ArrayList<>();
        ResultSet set=tool.Select(sql,tagId);
        while (set.next()){
            Blog blog=new Blog();
            blog.setBlogId(set.getString("blogId"));
            blog.setBlogName(set.getString("blogName"));
            blogs.add(blog);
        }
        return blogs;
    }
}
