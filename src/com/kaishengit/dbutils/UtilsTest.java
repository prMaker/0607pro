package com.kaishengit.dbutils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/8.
 */
public class UtilsTest {


    @Test
    public void insertTest(){
        QueryRunner queryRunner = new QueryRunner();
        String sql ="insert into `user`(name,password) values(?,?)";
        try {
            queryRunner.update(ConnManager.getConnection(),sql,"Tom","123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateTest(){
        QueryRunner queryRunner=new QueryRunner();
        String sql = "update `user` set name=? where id = ?";
        Connection connection = ConnManager.getConnection();
        try {
            queryRunner.update(connection,sql,"Jim",3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteTest(){
        QueryRunner queryRunner = new QueryRunner();
        String sql = "delete from `user` where id=?";
        Connection connection =ConnManager.getConnection();
        try {
            queryRunner.update(connection,sql,2);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void beanTest(){
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from `user` where id = ?";
        Connection connection = ConnManager.getConnection();
        User user=null;
        try {
            user= queryRunner.query(connection,sql, new BeanHandler<>(User.class),1);
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testBeanList(){
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnManager.getConnection();
        String sql = "select * from `user`";
        List<User> list=null;
        try {
             list= queryRunner.query(connection,sql,new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        for(User user: list){
            System.out.println(user);
        }
    }

    @Test
    public void mapHandlerTest(){
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnManager.getConnection();
        String sql = "select * from `user` where id= ?";
        try {
            Map<String , Object> user =  queryRunner.query(connection,sql,new MapHandler(),1);
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void mapListHandlerTest(){
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnManager.getConnection();
        String sql = "select * from `user`";
        try {
            List<Map<String ,Object>> userList = queryRunner.query(connection,sql,new MapListHandler());
            for(int i= 0; i<userList.size();i++){
                for(Map.Entry<String,Object> entry : userList.get(i).entrySet()){
                    System.out.println(entry.getKey()+":"+entry.getValue());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
