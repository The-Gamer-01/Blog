package me.gacl.util.Index;

import me.gacl.dao.impl.UserTools;

import java.sql.SQLException;

public class ManageUpdateBlog {
    public static UserTools tool=new UserTools();

    public static void updateBlog(String blogId,String level,String indexBlog) throws SQLException, ClassNotFoundException {
        String sql="UPDATE blog SET blogLevel=?,blogIndex=? WHERE blogId=?";
        tool.Update(sql,level,indexBlog,blogId);
    }

    public static void setBlogIndexTag(String blogId,String indexTag) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO indexconblog VALUES(?,?)";
        tool.Add(sql,blogId,indexTag);
    }

    public static void deleteBlogIndexTag(String blogId) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM indexconblog WHERE blogId=?";
        tool.Delete(sql,blogId);
    }
}
