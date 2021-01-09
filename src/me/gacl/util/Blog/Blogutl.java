package me.gacl.util.Blog;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.Blog;
import me.gacl.domain.Comment;
import me.gacl.domain.Tag;
import me.gacl.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Blogutl {
    protected static UserTools tool = new UserTools();

    public static ArrayList<Blog> getBlogs(String userId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM blog WHERE blogAuthorId=? AND blogLevel=0 ORDER BY blogVisits DESC";
        ResultSet set = tool.Select(sql, userId);
        ArrayList<Blog> blogs = new ArrayList<>();
        while (set.next()) {
            Blog blog = new Blog();
            blog.setBlogId(set.getString("blogId"));
            blog.setBlogName(set.getString("blogName"));
            blog.setBlogTime(set.getTimestamp("blogTime"));
            blog.setBlogAttribute(set.getString("blogAttribute"));
            blog.setBlogText(set.getString("blogText"));
            blog.setBlogAuthorId(set.getString("blogAuthorId"));
            blog.setLikesNum(getLikesNum(blog.getBlogId()));
            blog.setBlogVisit(set.getInt("blogVisits"));
            blogs.add(blog);
        }
        return blogs;
    }

    public static User getBlogAuthor(String userId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM user WHERE user.id=?";
        ResultSet set = tool.Select(sql, userId);
        User user = new User();
        if (set.next()) {
            user.setId(set.getString("id"));
            user.setHead(set.getString("head"));
            user.setName(set.getString("name"));
        }
        return user;
    }

    public static User getAuthor(String blogId) {
        String sql = "SELECT * FROM user INNER JOIN blog ON user.id=blog.blogAuthorId AND blogId=?;";
        ResultSet set = null;
        User Author = new User();
        try {
            set = tool.Select(sql, blogId);
            while (set.next()) {
                Author.setHead(set.getString("head"));
                Author.setName(set.getString("name"));
                Author.setId(set.getString("id"));
                Author.setTelOremail(set.getString("telOremail"));
                Author.setSayings(set.getString("sayings"));
                Author.setBlogs(getBlogs(Author.getId()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Author;
    }

    public static ArrayList<Tag> getTags(String blogId) {
        String sql = "SELECT * FROM blogcontag INNER JOIN tags ON tags.tagId=blogcontag.tagId WHERE blogId=?";
        ResultSet set = null;
        ArrayList<Tag> tags = new ArrayList<>();
        try {
            set = tool.Select(sql, blogId);
            while (set.next()) {
                Tag tag = new Tag();
                tag.setTagName(set.getString("tagName"));
                tag.setTagId(set.getInt("tagId"));
                tags.add(tag);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tags;
    }

    public static ArrayList<Comment> getComments(String blogId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM user INNER JOIN blogcomment ON blogcomment.commentUser=user.id WHERE blogcomment.commentBlogid=? AND commentLevel=1";
        ResultSet set = null;
        ArrayList<Comment> comments = new ArrayList<>();
        try {
            set = tool.Select(sql, blogId);
            while (set.next()) {
                Comment c = new Comment();
                c.setCommentTime(set.getTime("commentTime"));
                c.setUserName(set.getString("name"));
                c.setCommentText(set.getString("commentText"));
                c.setUserHead(set.getString("head"));
                c.setCommentUser(set.getString("id"));
                c.setCommentId(set.getString("commentId"));
                comments.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Comment c : comments) {
            String commentId = c.commentId;
            c.setRecommentList(getReComment(commentId));
        }
        return comments;
    }

    public static ArrayList<Comment> getReComment(String commentId) throws SQLException, ClassNotFoundException {
        ArrayList<Comment> ReCommentList = new ArrayList<>();
        String sql = "SELECT * FROM user INNER JOIN blogcomment ON blogcomment.commentUser=user.id WHERE blogcomment.recommentId=? ORDER BY blogcomment.commentTime";
        ResultSet set = null;
        set = tool.Select(sql, commentId);
        while (set.next()) {
            Comment c = new Comment();
            c.setCommentTime(set.getTime("commentTime"));
            c.setUserName(set.getString("name"));
            c.setCommentText(set.getString("commentText"));
            c.setUserHead(set.getString("head"));
            c.setCommentUser(set.getString("id"));
            c.setCommentId(set.getString("commentId"));
            ReCommentList.add(c);
        }
        return ReCommentList;
    }

    public static ArrayList<Blog> searchBlog(String blogName) {
        HashMap<String, Boolean> map = new HashMap<>();
        String sql = "SELECT * FROM blog WHERE blogName LIKE '%" + blogName + "%' AND blogLevel=0";
        ArrayList<Blog> blogs = new ArrayList<>();
        ResultSet set = null;
        try {
            set = tool.Select(sql);
            while (set.next()) {
                Blog blog = new Blog();
                blog.setBlogName(set.getString("blogName"));
                blog.setBlogId(set.getString("blogId"));
                blog.setAuthor(Blogutl.getAuthor(blog.getBlogId()));
                blog.setLikesNum(Blogutl.getLikesNum(blog.getBlogId()));
                blog.setBlogVisit(set.getInt("blogVisits"));
                blog.setBlogTags(Blogutl.getTags(blog.blogId));
                blogs.add(blog);
                map.put(blog.blogId, true);
            }
            String sql2 = "SELECT * FROM (SELECT blogId,tagName FROM tags INNER JOIN blogcontag ON tags.tagId=blogcontag.tagId WHERE tagName LIKE '%"+blogName+"%') t INNER JOIN blog ON t.blogId=blog.blogId WHERE blog.blogLevel=0;";
            ResultSet set2 = tool.Select(sql2);
            while (set2.next()) {
                Blog blog = new Blog();
                blog.setBlogId(set2.getString("blogId"));
                if (map.containsKey(blog.getBlogId())) {
                    System.out.println("blogId:"+blog.getBlogId());
                    continue;
                }
                blog.setLikesNum(Blogutl.getLikesNum(blog.getBlogId()));
                blog.setBlogVisit(set2.getInt("blogVisits"));
                blog.setBlogName(set2.getString("blogName"));
                blog.setAuthor(Blogutl.getAuthor(blog.getBlogId()));
                map.put(blog.getBlogId(), true);
                blogs.add(blog);
            }
            String sql3="SELECT * FROM blog INNER JOIN classes ON blog.blogClass=classes.classId WHERE classes.className LIKE '%"+blogName+"%'  AND blogLevel=0;";
            ResultSet set3=tool.Select(sql3);
            while(set3.next()){
                Blog blog = new Blog();
                blog.setBlogId(set3.getString("blogId"));
                if (map.containsKey(blog.getBlogId())) {
                    continue;
                }
                map.put(blog.getBlogId(), true);
                blog.setLikesNum(Blogutl.getLikesNum(blog.getBlogId()));
                blog.setBlogVisit(set3.getInt("blogVisits"));
                blog.setAuthor(Blogutl.getAuthor(blog.getBlogId()));
                blog.setBlogName(set3.getString("blogName"));
                blogs.add(blog);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(Blog b:blogs){
            System.out.println("作者头像："+b.getAuthor().getHead());
        }
        return blogs;
    }

    public static ArrayList<User> searchUser(String userName) {
        String sql = "SELECT * FROM user WHERE name LIKE '%" + userName + "%' AND status=1";
        ResultSet set = null;
        ArrayList<User> userlist = new ArrayList<>();
        try {
            set = tool.Select(sql);
            while (set.next()) {
                User user = new User();
                user.setName(set.getString("name"));
                user.setHead(set.getString("head"));
                user.setId(set.getString("id"));
                userlist.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userlist;
    }

    public static int getLikesNum(String blogId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM likes WHERE blogid=?";
        ResultSet set = tool.Select(sql, blogId);
        set.last();
        return set.getRow();
    }

    public static boolean checkLike(String userId, String blogId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM likes WHERE blogid=? AND userid=?";
        ResultSet set = tool.Select(sql, blogId, userId);
        return set.next();
    }

    public static int getBlogConut(String userId) throws SQLException, ClassNotFoundException {
        String sql="SELECT count(*) FROM blog WHERE blogAuthorId=?;";
        ResultSet set=tool.Select(sql,userId);
        int n=0;
        set.next();
        n=set.getInt(1);
        return n;
    }

    public static void UpdateBlogTag(String blogId,String[] blogTags) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM blogcontag WHERE blogId=?";
        tool.Delete(sql,blogId);
        sql="INSERT INTO blogcontag VALUES(?,?)";
        if(blogTags!=null)
        for(String str:blogTags){
            tool.Add(sql,blogId,str);
        }
    }

}
