package me.gacl.util.random;

import me.gacl.dao.impl.UserTools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class random {

    public static String getrandom(int len){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        String text="";
        for(int i=0;i<len;i++){
            int num=random.nextInt(62);
            text+=str.charAt(num);
        }
        return text;
    }

    public  static  String getRandomNum(int len){
        String str="1234567890";
        String str2="123456789";
        Random random=new Random();
        String id="";
        for(int i=0;i<len-1;i++){
            int num=random.nextInt(str2.length());
            id+=str2.charAt(num);
        }
        id+=str.charAt(random.nextInt(str.length()));
        return id;
    }

    public static String getId(int len) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM user WHERE id=?;";
        UserTools tool=new UserTools();
        while(true) {
            String id=getRandomNum(len);
            System.out.println(id);
            ResultSet resultSet = tool.Select(sql, id);
            if (!resultSet.next()) {
                return id;
            }
            resultSet.close();
        }
    }

    public static String getCommentId(int len) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM blogcomment WHERE commentId=?";
        UserTools tool=new UserTools();
        while (true){
            String id=getRandomNum(len);
            ResultSet set=tool.Select(sql,id);
            if(!set.next()){
                return id;
            }
            set.close();
        }
    }

    public static String getClassId(int len) throws SQLException, ClassNotFoundException{
        String sql="SELECT * FROM classes WHERE classId=?";
        UserTools tool=new UserTools();
        while (true){
            String id=getRandomNum(len);
            ResultSet set=tool.Select(sql,id);
            if(!set.next()){
                return id;
            }
            set.close();
        }
    }
}
