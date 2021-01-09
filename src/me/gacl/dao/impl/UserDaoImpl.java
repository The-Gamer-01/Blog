package me.gacl.dao.impl;

import me.gacl.dao.IUserDao;
import me.gacl.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * IUerDao的实现类
 */
public class UserDaoImpl implements IUserDao {

    @Override
    public User find(String email) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM user WHERE email=?";
        UserTools tool=new UserTools();
        ResultSet res=tool.Select(sql,email);
        User user=null;
        if(res.next()){
            user=new User();
            user.setId(res.getString(1));
            user.setPawd(res.getString(2));
            user.setName(res.getString(3));
            user.setSex(res.getInt(4));
            user.setBirthday(res.getDate(5));
            user.setEmail(res.getString(6));
            user.setSayings(res.getString(7));
            user.setHead(res.getString(8));
            user.setAdministrator(res.getInt(9));
            user.setText(res.getString(10));
            user.setStatus(res.getInt(11));
        }
        return user;
    }

    @Override
    public User find(String userid, String userpawd) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM user WHERE id=? AND pawd=?;";
        UserTools tool=new UserTools();
        ResultSet res=tool.Select(sql,userid,userpawd);
        User user=null;
        if(res.next()){
            user=new User();
            user.setId(res.getString(1));
            user.setPawd(res.getString(2));
            user.setName(res.getString(3));
            user.setSex(res.getInt(4));
            user.setBirthday(res.getDate(5));
            user.setEmail(res.getString(6));
            user.setSayings(res.getString(7));
            user.setHead(res.getString(8));
            user.setAdministrator(res.getInt(9));
            user.setText(res.getString(10));
            user.setStatus(res.getInt(11));
            user.setTelOremail(res.getString(12));
        }
        return user;
    }

    @Override
    public void addUser(Object... obj) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO user (id,pawd,name,sex,birthday,email,text,telOremail) VALUES (?,?,?,?,?,?,?,?);";
        UserTools tool=new UserTools();
        tool.Add(sql,obj);
    }

    @Override
    public void addBlog(Object... obj) throws SQLException, ClassNotFoundException {
        String sql="INSERT INTO blog (blogId,blogName,blogTime,blogAttribute,blogText,blogAuthorId,blogLevel,blogMd,blogClass,blogReprint) VALUES (?,?,?,?,?,?,?,?,?,?);";
        UserTools tool=new UserTools();
        tool.Add(sql,obj);
    }

    @Override
    public void deleteUser(String email) throws SQLException, ClassNotFoundException {
        String sql="DELETE FROM user WHERE email=?";
        UserTools tool=new UserTools();
        tool.Delete(sql,email);
        System.out.println("删除用户");
    }

    @Override
    public boolean setStatu(String text) throws SQLException, ClassNotFoundException {
        String sql="UPDATE user SET `status`=1 WHERE text=?;";
        UserTools tool=new UserTools();
        return (tool.Update(sql,text)==1);
    }

    @Override
    public void setPawd(String text, String pawd) throws SQLException, ClassNotFoundException {
        System.out.println("重置密码");
        String sql="UPDATE user SET pawd=?,text=? WHERE text=?;";
        UserTools tool=new UserTools();
        tool.Update(sql,pawd,"NULL",text);
    }

    @Override
    public void setText(String text, String email) throws SQLException, ClassNotFoundException {
        String sql="UPDATE user SET text=? WHERE email=?";
        UserTools tool=new UserTools();
        tool.Update(sql,text,email);
    }

    @Override
    public void sendText() {

    }

    @Override
    public void updateUser(){

    }
}
