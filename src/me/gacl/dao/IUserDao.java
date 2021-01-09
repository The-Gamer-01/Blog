package me.gacl.dao;

import me.gacl.domain.User;

import java.sql.SQLException;

public interface IUserDao {
    User find(String email) throws SQLException, ClassNotFoundException;

    /**
     * 根据userid来查找用户
     * @param userid
     * @param userpawd
     * @return
     */
    User find(String userid, String userpawd) throws SQLException, ClassNotFoundException;

    /**
     * 增加用户
     * @param obj
     */
    void addUser(Object... obj) throws SQLException, ClassNotFoundException;

    void setPawd(String text, String pawd) throws SQLException, ClassNotFoundException;

    void setText(String text, String email) throws SQLException, ClassNotFoundException;

    /**
     * 发送验证码
     */
    void sendText();

    void deleteUser(String email) throws SQLException, ClassNotFoundException;

    public boolean setStatu(String text) throws SQLException, ClassNotFoundException;

    public void addBlog(Object... obj) throws SQLException, ClassNotFoundException;

    void updateUser();
}
