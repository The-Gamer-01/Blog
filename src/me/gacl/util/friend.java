package me.gacl.util;

import me.gacl.dao.impl.UserTools;
import me.gacl.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class friend {
    static UserTools tool=new UserTools();

    public static void giveAfriend(String authorId,String fanId) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO friend VALUES(?,?)";
        tool.Add(sql,authorId,fanId);
    }

    public static void deleteAfriend(String authorId,String fan) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM friend WHERE author=? AND fan=?";
        tool.Delete(sql,authorId,fan);
    }

    public static ArrayList<User> getMyfriends(String userId) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM friend INNER JOIN user ON author=id WHERE fan=?";
        ResultSet set=tool.Select(sql,userId);
        ArrayList<User> friends=new ArrayList<>();
        while(set.next()){
            User user=new User();
            user.setHead(set.getString("head"));
            user.setId(set.getString("id"));
            user.setName(set.getString("name"));
            friends.add(user);
        }
        return friends;
    }
}
