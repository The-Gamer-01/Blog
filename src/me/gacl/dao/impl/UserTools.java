package me.gacl.dao.impl;

import me.gacl.dao.IUserTools;

import java.sql.*;

/**
 * IUserTools的实现类
 */
public class UserTools implements IUserTools {

    @Override
    public Statement getStmt() throws SQLException, ClassNotFoundException {
        Connection con=getCon();
        Statement stmt=null;
        stmt=con.createStatement();
        return stmt;
    }

    @Override
    public PreparedStatement getPrestmt(String sql,Object... obj) throws SQLException, ClassNotFoundException {
        Connection con=getCon();
        PreparedStatement prestmt=null;
        prestmt=con.prepareStatement(sql);
        for(int i=1;i<=obj.length;i++){
            if(obj[i-1]=="NULL"||obj[i-1]==null)
                prestmt.setNull(i,Types.INTEGER);
            else
            prestmt.setObject(i,obj[i-1]);
        }
        return prestmt;
    }

    @Override
    public Connection getCon() throws ClassNotFoundException, SQLException {
        Class.forName(IUserTools.JDBC_DRIVER);
        return DriverManager.getConnection(IUserTools.DB_URL,IUserTools.USER,IUserTools.PASS);
    }

    @Override
    public boolean Add(String sql, Object... obj) throws SQLException, ClassNotFoundException {
        PreparedStatement prestmt=getPrestmt(sql,obj);
        return prestmt.execute();
    }

    @Override
    public boolean Delete(String sql, Object... obj) throws SQLException, ClassNotFoundException {
        PreparedStatement prestmt=getPrestmt(sql,obj);
        return prestmt.execute();
    }

    @Override
    public int Update(String sql, Object... obj) throws SQLException, ClassNotFoundException {
        PreparedStatement prestmt=getPrestmt(sql,obj);
        return prestmt.executeUpdate();
    }

    @Override
    public ResultSet Select(String sql, Object... obj) throws SQLException, ClassNotFoundException {
        PreparedStatement prestmt=getPrestmt(sql,obj);
        return prestmt.executeQuery();
    }

    @Override
    public boolean doTransaction(String... sql) throws SQLException, ClassNotFoundException {
        return false;
    }


//    @Override
//    public boolean doTransaction(String... sql,Object[]... obj) throws SQLException, ClassNotFoundException {
//        Connection conn=getCon();
//        conn.setAutoCommit(false);
//        for(String str:sql){
//
//        }
//    }
}
