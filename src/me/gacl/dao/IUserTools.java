package me.gacl.dao;

import me.gacl.dao.impl.UserTools;

import java.sql.*;

public interface IUserTools {
    public final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String DB_URL = "jdbc:mysql://localhost:3306/blog?serverTimezone=UTC&rewriteBatchedStatements=true";
    public final static String USER = "root";
    public final static String PASS = "huangyixuan";

    public Statement getStmt() throws SQLException, ClassNotFoundException;
    public PreparedStatement getPrestmt(String sql,Object... obj) throws SQLException, ClassNotFoundException;
    public Connection getCon() throws ClassNotFoundException, SQLException;
    public static void close(Statement stmt,Connection conn) throws SQLException {
        if(stmt!=null){
            stmt.close();
            if(conn!=null){
                conn.close();
            }
        }
    }
    public static void close(PreparedStatement prestmt,Connection conn) throws SQLException {
        if(prestmt!=null){
            prestmt.close();
            if(conn!=null){
                conn.close();
            }
        }
    }
    public static void close(ResultSet rs,PreparedStatement prestmt,Connection conn) throws SQLException {
        if(rs!=null){
            rs.close();
            if(prestmt!=null) {
                prestmt.close();
                if(conn!=null){
                    conn.close();
                }
            }
        }
    }

    public boolean Add(String sql,Object... obj) throws SQLException, ClassNotFoundException;
    public boolean Delete(String sql,Object... obj) throws SQLException, ClassNotFoundException;
    public int Update(String sql,Object... obj) throws SQLException, ClassNotFoundException;
    public ResultSet Select(String sql, Object... obj) throws SQLException, ClassNotFoundException;

    boolean doTransaction(String... sql) throws SQLException, ClassNotFoundException;
}
