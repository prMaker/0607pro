package com.kaishengit.dao;

import com.kaishengit.dbutils.ConnectionManager;
import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/6/9.
 */
public class UserDao<T> {

    public void updateUser(String sql,Object...params){
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnectionManager.getConnection();
        try {
            queryRunner.update(connection,sql,params);
        } catch (SQLException e) {
            throw new DataAccessException("数据更新失败！",e);
        } finally {
            ConnectionManager.close(connection);
        }
    }

    public T queryUser(String sql , ResultSetHandler rsh, Object...params) {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnectionManager.getConnection();
        try {
            return (T) queryRunner.query(connection, sql, rsh, params);
        } catch (SQLException e) {
            throw new DataAccessException("查找数据异常", e);
        } finally {
            ConnectionManager.close(connection);
        }
    }
}
