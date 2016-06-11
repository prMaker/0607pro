package com.kaishengit.dbutils;

import com.kaishengit.exception.DataAccessException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/6/8.
 */
public class ConnectionManager {


    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///mydb", "root", "root");
            return connection;
        } catch (ClassNotFoundException e) {
            throw new DataAccessException("加载数据库驱动异常",e);
        } catch (SQLException e) {
            throw new DataAccessException("获取数据库连接异常",e);
        }
    }

    public static void close(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DataAccessException("数据库连接关闭异常",e);
        }
    }
}
