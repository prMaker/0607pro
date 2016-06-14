package com.kaishengit.dbutils;

/**
 * Created by Administrator on 2016/6/14.
 */

import org.apache.commons.mail.HtmlEmail;

/**
 * 发送邮件
 */
public class EmailUtil {

    public void sendEmail(String name) {

        HtmlEmail htmlEmail = new HtmlEmail();
        htmlEmail.setHostName(Config.get("mail.hostname"));
        htmlEmail.setSmtpPort(Integer.parseInt(Config.get("mail.port"));
        htmlEmail.setCharset(Config.get("mail.charaset"));
        htmlEmail.setAuthentication(Config.get("mail.username"),Config.get("mail.password"));

        htmlEmail.setFrom(Config.get("mail.from"));
        htmlEmail.setSubject("登录提醒");
        htmlEmail.setMsg(name + "在"++"登录了服务器");

    }


}
