package com.kaishengit.dbutils;

import com.kaishengit.dbutils.ConnectionManager;
import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/6/9.
 */
public class DbHelper {

    public void updateUser(String sql,Object...params){
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnectionManager.getConnection();
        try {
            queryRunner.update(connection,sql,params);
        } catch (SQLException e) {
            throw new DataAccessException("执行"+sql+"异常",e);
        } finally {
            ConnectionManager.close(connection);
        }
    }

    public static <T> T queryUser(String sql , ResultSetHandler<T> rsh, Object...params) {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnectionManager.getConnection();
        try {
            return (T) queryRunner.query(connection, sql, rsh, params);
        } catch (SQLException e) {
            throw new DataAccessException("执行"+sql+"异常", e);
        } finally {
            ConnectionManager.close(connection);
        }
    }
}