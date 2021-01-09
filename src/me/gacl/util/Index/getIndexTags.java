package me.gacl.util.Index;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.Blog;
import me.gacl.domain.Tag;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class getIndexTags {
    private static UserTools tool = new UserTools();

    public static ArrayList<Tag> getIndexTags() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM indextag";
        ResultSet set = null;
        ArrayList<Tag> tags = new ArrayList<>();
        set = tool.Select(sql);
        while (set.next()) {
            Tag tag = new Tag();
            tag.setTagName(set.getString("tagName"));
            tag.setTagId(set.getInt("tagId"));
            tags.add(tag);
        }
        return tags;
    }

    public static ArrayList<Blog> getIndexBlogs(int tagId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM indexconblog WHERE tagId=?";
        ResultSet set = null;
        set = tool.Select(sql, tagId);
        ArrayList<Blog> list=new ArrayList<>();
        while (set.next()){
            Blog blog=new Blog();
            blog.setBlogName(set.getString("blogName"));
            blog.setBlogId(set.getString("blogId"));
            list.add(blog);
        }
        return list;
    }
}
