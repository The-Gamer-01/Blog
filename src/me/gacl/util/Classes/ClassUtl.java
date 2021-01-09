package me.gacl.util.Classes;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.Blog;
import me.gacl.domain.Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassUtl {
    public static UserTools tool=new UserTools();
    public static ArrayList<Classes> getClasses(String userId) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM classes WHERE classUserId=?";
        ResultSet set=null;
        set=tool.Select(sql,userId);
        ArrayList<Classes> classList=new ArrayList<>();
        while (set.next()){
            Classes c=new Classes();
            c.setClassName(set.getString("className"));
            c.setClassId(set.getString("classId"));
            classList.add(c);
        }
        return classList;
    }

    public static ArrayList<Blog> getBlogs(String userId,String classId) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM blog WHERE blogAuthorId=? AND blogClass=?";
        ResultSet set=null;
        set=tool.Select(sql,userId,classId);
        ArrayList<Blog> blogs=new ArrayList<>();
        while(set.next()){
//            Blog blog=new Blog();
//            blog=
        }
        return blogs;
    }
}
