package com.kaishengit.service;

import com.kaishengit.dao.UserDao;
import com.kaishengit.dbutils.EmailUtil;
import com.kaishengit.entity.User;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/6/14.
 */

/**
 * 对user进行操作
 */
public class UserService {


    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    private static UserDao userDao = new UserDao();
    private static final String SALT = "sdfsadfsadfjslkc544";

    /**
     * 用户登录进行操作
     *
     * @param name     用户名
     * @param password 用户密码
     * @return user对象
     */
    public User login(final String name, String password) {
        final User user = userDao.findByName(name);
//        password = DigestUtils.md5Hex(password);
        if (user != null && user.getPassword().equals(password)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    EmailUtil.sendEmail("登录提醒", "<h3>您的账号" + name + "在" + DateTime.now().toString("yyyy-MM-dd HH-mm-ss") + "登陆了系统</h3>", user.getAdress());
                }
            }).start();
            logger.info("{}登陆了系统", name);
            return user;
        }
        return null;
    }


}
