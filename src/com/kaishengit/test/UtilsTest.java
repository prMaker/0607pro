package com.kaishengit.test;

import com.kaishengit.dao.UserDao;
import com.kaishengit.dbutils.ConnectionManager;
import com.kaishengit.entity.User;
import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/6/8.
 */
public class UtilsTest {

    UserDao userDao = new UserDao();

    @Test
    public void insertTest(){
        String name = "Yuan";
        String password = "321";
        userDao.insertUser(name,password);
    }

    @Test
    public void updateTest(){
        String name = "Yuan";
        String password = "123";
        userDao.updateUser(name,password);
    }

    @Test
    public void deleteTest(){
        userDao.deleteUserById(8);
    }


    @Test
    public void findByIdTest(){
        Integer id = 7;
        userDao.findById(id);
    }

    @Test
    public void findAllTest(){
        userDao.findAll();
    }

    @Test
    public void findByIdMapTest(){
        Integer id = 7;
        userDao.findByIdMap(id);
    }

    @Test
    public void findAllMapListTest(){
        userDao.findAllMapList();
    }

    @Test
    public void countUserTest(){
        Assert.assertEquals(new Long(5), userDao.countUser());
    }

    @Test
    public void nameListTest(){
        Assert.assertNotNull(userDao.nameList());
    }

//    @Test
//    public void beanTest(){
//        String sql = "select * from `user` where id = ?";
//        Connection connection = ConnectionManager.getConnection();
//        QueryRunner queryRunner = new QueryRunner();
//        try {
//            User user = queryRunner.query(connection,sql,new BeanHandler<>(User.class),5);
//            System.out.println(user);
//            Assert.assertNotNull(user);
//        } catch (SQLException e) {
//            throw new DataAccessException("数据处理异常",e);
//        }
//
//
////        String sql = "select * from `user` where id = ?";
////        System.out.println(dbHelper.queryUser(sql,new BeanHandler<>(User.class),5));
//    }
//
//    @Test
//    public void testBeanList(){
//        QueryRunner queryRunner = new QueryRunner();
//        Connection connection = ConnectionManager.getConnection();
//        String sql = "select * from `user`";
//        List<User> list=null;
//        try {
//             list= queryRunner.query(connection,sql,new BeanListHandler<>(User.class));
//        } catch (SQLException e) {
//            throw new DataAccessException("选择用户异常！",e);
//        }finally {
//            ConnectionManager.close(connection);
//        }
//        for(User user: list){
//            System.out.println(user);
//        }
//
////        String sql = "select * from `user`";
////        List<User> list=  dbHelper.queryUser(sql,new BeanListHandler<>(User.class));
//
//    }
//
//    @Test
//    public void mapHandlerTest(){
////        QueryRunner queryRunner = new QueryRunner();
////        Connection connection = ConnectionManager.getConnection();
////        String sql = "select * from `user` where id= ?";
////        try {
////            Map<String , Object> user =  queryRunner.query(connection,sql,new MapHandler(),1);
////            System.out.println(user);
////        } catch (SQLException e) {
////            e.printStackTrace();
////        } finally {
////            ConnectionManager.close(connection);
////        }
//        String sql = "select * from `user` where id = ?";
//        Map<String , Object> map = userDao.queryUser(sql,new MapHandler(),5);
//        for(Map.Entry<String ,Object> entry : map.entrySet()){
//            System.out.println(entry.getKey()+":"+entry.getValue());
//        }
//    }
//
//    @Test
//    public void mapListHandlerTest(){
////        QueryRunner queryRunner = new QueryRunner();
////        Connection connection = ConnectionManager.getConnection();
////        String sql = "select * from `user`";
////        try {
////            List<Map<String ,Object>> userList = queryRunner.query(connection,sql,new MapListHandler());
////            for(int i= 0; i<userList.size();i++){
////                for(Map.Entry<String,Object> entry : userList.get(i).entrySet()){
////                    System.out.println(entry.getKey()+":"+entry.getValue());
////                }
////            }
////        } catch (SQLException e) {
////            throw new DataAccessException("挑选用户失败！",e);
////        } finally {
////            ConnectionManager.close(connection);
////        }
//
//        String sql = "select * from `user`";
//        List<Map<String , Object>> list =dbHelper.queryUser(sql,new MapListHandler());
//        for(int i=0;i<list.size();i++){
//            for(Map.Entry<String,Object> entry : list.get(i).entrySet()){
//                System.out.println(entry.getKey()+":"+entry.getValue());
//            }
//        }
//    }
//
//    @Test
//    public void testScalarHandler(){
////        String sql = "select count(*) from `user`";
////        Connection connection =  ConnectionManager.getConnection();
////        QueryRunner queryRunner = new QueryRunner();
////        try {
////            Long count = queryRunner.query(connection,sql,new ScalarHandler<Long>());
////            Assert.assertEquals(new Long(5),count);
////            System.out.println(count);
////        } catch (SQLException e) {
////            throw new DataAccessException("数据统计出错",e);
////        } finally {
////            ConnectionManager.close(connection);
////        }
//
//        String sql = "select count(*) from `user`";
//        Long count = dbHelper.queryUser(sql,new ScalarHandler<Long>());
//        Assert.assertEquals(new Long(5),count);
//        System.out.println(count);
//    }
//
//    @Test
//    public  void testColumListHandler(){
////        String sql = "select `name` from `user`";
////        Connection connection = ConnectionManager.getConnection();
////        QueryRunner queryRunner = new QueryRunner();
////        try {
////            List<String> nameList = queryRunner.query(connection,sql,new ColumnListHandler<String>());
////            for(int i = 0;i<nameList.size();i++){
////                System.out.println(nameList.get(i));
////            }
////        } catch (SQLException e) {
////            throw new DataAccessException("数据输出异常",e);
////        }
//
//        String sql = "select name from `user`";
//        List<String> nameList = dbHelper.queryUser(sql,new ColumnListHandler<String>());
//        for(String name : nameList){
//            System.out.println(name);
//        }
//        for(int i = 0;i<nameList.size();i++){
//            System.out.println(nameList.get(i));
//        }
//        Iterator iterator = nameList.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//    }
}
