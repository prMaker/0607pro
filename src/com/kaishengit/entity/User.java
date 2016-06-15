package com.kaishengit.entity;

/**
 * Created by Administrator on 2016/6/8.
 */
public class User {

    private Integer id;
    private String name;
    private String password;
    private String adress;

    public User(Integer id, String name , String password, String adress){
        this.password = password;
        this.adress = adress;
        this.id= id;
        this.name = name ;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public User(){}

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
