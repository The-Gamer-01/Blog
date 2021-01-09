package junit.test;

import me.gacl.dao.impl.UserDaoImpl;
import me.gacl.dao.impl.UserTools;
import me.gacl.domain.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * @ClassName test
 * @Description TODO
 * @Author 黄乙轩
 * @Date 2021/1/8 15:41
 * @Version 1.0
 **/

public class test {
    @Test
    public void testInsertUser() throws SQLException, ClassNotFoundException {
        int id=0;
        String pawd="huangyixuan";
        String name="黄乙轩";
        int sex=1;
        Date birthday=new Date(System.currentTimeMillis());
        String email="843497509@qq.com";
        String text="123456";
        String telOremail="19974361760";
        UserDaoImpl userDao=new UserDaoImpl();
        userDao.addUser(id,pawd,name,sex,birthday,email,text,telOremail);
    }
    @Test
    public void testDeleteUser(){
        int userId=0;
        String sql="DELETE FROM user WHERE id=?;";
        UserTools tool=new UserTools();
        try {
            tool.Delete(sql,userId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void selectUser(){
        String id="0";
        String pawd="huangyixuan";
        UserDaoImpl impl=new UserDaoImpl();
        User user=null;
        try {
            user=impl.find(id,pawd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }

    @Test
    public void updateUser(){
        String name="黄乙轩";
        String pawd="huangyixuan-2001";
        String text="这个人很懒什么也没有写";
        String telOremail="15273425236";
        String userId="100000";
        String updateUsersql="UPDATE user SET name=?,pawd=?,sayings=?,telOremail=? WHERE id=?;";
        UserTools tools=new UserTools();
        try {
            System.out.println("更新");
            tools.Update(updateUsersql,name,pawd,text,telOremail,userId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert1wdata() throws SQLException, ClassNotFoundException {
        UserTools tools=new UserTools();
        Connection conn=tools.getCon();
        PreparedStatement prestmt=null;
        String sql="INSERT INTO user (id,pawd,name,sex,birthday,email,text,telOremail) VALUES (?,?,?,?,?,?,?,?)";
        prestmt=conn.prepareStatement(sql);
        for(int i=0;i<10000;i++){
            prestmt.setString(1,String.valueOf(i));
            prestmt.setString(2,"huangyixuan");
            prestmt.setString(3,"测试账号："+i);
            prestmt.setInt(4,i%2);
            prestmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            prestmt.setString(6,i+"@qq.com");
            prestmt.setString(7,"123456");
            prestmt.setString(8,"18874361760");
            prestmt.addBatch();
        }
        long start = System.currentTimeMillis();
        prestmt.executeBatch();
        long end = System.currentTimeMillis();
        System.out.println("花费时间："+(end-start));
    }
}
