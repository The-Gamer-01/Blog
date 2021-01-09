package me.gacl.util.Index;

import me.gacl.dao.impl.UserTools;

import java.sql.SQLException;

public class IndexDelectTag {
    static UserTools tool=new UserTools();

    public static void delTagBlog(String tagId) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM blogcontag WHERE tagId=?";
        tool.Delete(sql,tagId);
    }

    public static void delTag(String tagId) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM indextag WHERE tagId=?";
        tool.Delete(sql,tagId);
    }
}
