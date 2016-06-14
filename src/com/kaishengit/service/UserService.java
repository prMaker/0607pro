package com.kaishengit.service;

import com.kaishengit.dao.UserDao;
import com.kaishengit.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/6/14.
 */

/**
 * 对user进行操作
 */
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);
    private UserDao userDao = new UserDao();

    /**
     * 用户登录进行操作
     * @param name 用户名
     * @param password 用户密码
     * @return user对象
     */
    public User login(String name , String password){
        User user = userDao.findByName(name);
        if(user!=null&&user.getPassword().equals(password)){

            logger.info("{}登录系统",user.getName());
            HtmlEmail htmlEmail = new HtmlEmail();
            htmlEmail.setHostName("smtp.163.com");
            htmlEmail.setSmtpPort(25);
            htmlEmail.setCharset("UTF-8");
            htmlEmail.setAuthentication("prmaker","y1593812");

            htmlEmail.setFrom("prmaker@163.com");
            htmlEmail.setSubject("登录提醒");
            htmlEmail.setMsg("登录系统");

            return user;
        }
        return null;
    }




}
