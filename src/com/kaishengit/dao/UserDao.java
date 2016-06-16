package com.kaishengit.dao;

import com.kaishengit.dbutils.DbHelp;
import com.kaishengit.entity.User;
import org.apache.commons.dbutils.handlers.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/13.
 */
public class UserDao {

    DbHelp dbHelper = new DbHelp();

    public void insertUser(String name, String password) {
        String sql = "insert into `user` (name,password) value (?,?);";
        dbHelper.updateUser(sql, name, password);
    }

    public void updateUser(String name, String password) {
        String sql = "update `user` set password = ? where name = ?";
        dbHelper.updateUser(sql, password, name);
    }

    public void deleteUserById(Integer id) {
        String sql = "delete from `user` where id = ?";
        dbHelper.updateUser(sql, id);
    }


    public User findById(Integer id) {
        String sql = "select * from `user` where id=?";
        User user = dbHelper.queryUser(sql, new BeanHandler<>(User.class), id);
        System.out.println(user);
        return user;
    }

    public User findByName(String name) {
        String sql = "select * from `user` where name = ?";
        return dbHelper.queryUser(sql, new BeanHandler<>(User.class), name);
    }

    public List<User> findAll() {
        String sql = "select * from `user`";
        List<User> list = dbHelper.queryUser(sql, new BeanListHandler<>(User.class));
        for (User user : list) {
            System.out.println(user);
        }
        return list;
    }

    public Map<String, Object> findByIdMap(Integer id) {
        String sql = "select * from `user` where id = ?";
        Map<String, Object> map = dbHelper.queryUser(sql, new MapHandler(), id);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        return map;
    }

    public List<Map<String, Object>> findAllMapList() {
        String sql = "select * from `user`";
        List<Map<String, Object>> resultList = dbHelper.queryUser(sql, new MapListHandler());
        for (int i = 0; i < resultList.size(); i++) {
            for (Map.Entry<String, Object> entry : resultList.get(i).entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
        return resultList;
    }

    public Long countUser() {
        String sql = "select count(*) from `user`";
        return dbHelper.queryUser(sql, new ScalarHandler<Long>());
    }

    public List<String> nameList() {
        String sql = "select name from `user`";
        return dbHelper.queryUser(sql, new ColumnListHandler<String>());
    }
}
