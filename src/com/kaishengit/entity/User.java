package com.kaishengit.entity;

/**
 * Created by Administrator on 2016/6/8.
 */
public class User {

    private Integer id;
    private String name;
    private String password;

    public User(Integer id,String name , String password){
        this.password = password;
        this.id= id;
        this.name = name ;
    }

    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
