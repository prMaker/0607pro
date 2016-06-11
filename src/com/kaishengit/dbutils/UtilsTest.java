package com.kaishengit.dbutils;

import com.kaishengit.dao.UserDao;
import com.kaishengit.exception.DataAccessException;
import com.mysql.fabric.xmlrpc.base.Data;
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


    UserDao<User> userDao = new UserDao<>();
    @Test
    public void insertTest(){
        String sql ="insert into `user`(name,password) values(?,?)";
        userDao.updateUser(sql,"Lucy","123");

    }

    @Test
    public void updateTest(){
        String sql = "update `user` set name=? where id = ?";
        userDao.updateUser(sql,"Jack",5);
    }

    @Test
    public void deleteTest(){
        String sql = "delete from `user` where id=?";
        userDao.updateUser(sql,4);
    }

    @Test
    public void beanTest(){
        String sql = "select * from `user` where id = ?";
        System.out.println(userDao.queryUser(sql,new BeanHandler(User.class),5));
    }

    @Test
    public void testBeanList(){
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnectionManager.getConnection();
        String sql = "select * from `user`";
        List<User> list=null;
        try {
             list= queryRunner.query(connection,sql,new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            throw new DataAccessException("选择用户异常！",e);
        }finally {
            ConnectionManager.close(connection);
        }
        for(User user: list){
            System.out.println(user);
        }
    }

    @Test
    public void mapHandlerTest(){
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnectionManager.getConnection();
        String sql = "select * from `user` where id= ?";
        try {
            Map<String , Object> user =  queryRunner.query(connection,sql,new MapHandler(),1);
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(connection);
        }
    }


    @Test
    public void mapListHandlerTest(){
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = ConnectionManager.getConnection();
        String sql = "select * from `user`";
        try {
            List<Map<String ,Object>> userList = queryRunner.query(connection,sql,new MapListHandler());
            for(int i= 0; i<userList.size();i++){
                for(Map.Entry<String,Object> entry : userList.get(i).entrySet()){
                    System.out.println(entry.getKey()+":"+entry.getValue());
                }
            }
        } catch (SQLException e) {
            throw new DataAccessException("挑选用户失败！",e);
        } finally {
            ConnectionManager.close(connection);
        }
    }


}
