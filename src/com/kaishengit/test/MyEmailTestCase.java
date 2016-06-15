package com.kaishengit.test;

import com.kaishengit.dbutils.EmailUtil;
import org.apache.commons.mail.*;
import org.junit.Test;

/**
 * Created by Administrator on 2016/6/14.
 */
public class MyEmailTestCase {

    @Test
    public void testEmail(){
        SimpleEmail simpleEmail = new SimpleEmail();

        simpleEmail.setHostName("smtp.163.com");
        simpleEmail.setSmtpPort(25);
        simpleEmail.setCharset("UTF-8");
        simpleEmail.setAuthentication("prmaker","y1593812");

        try{
            simpleEmail.setFrom("prmaker@163.com");
            simpleEmail.setSubject("下午来我办公室一趟！");
            simpleEmail.setMsg("hello!");
            simpleEmail.addTo("734520467@qq.com");
            simpleEmail.send();
        }catch (EmailException ex){
            throw new RuntimeException("发送失败",ex);
        }
    }

    @Test
    public void testHtml(){
        HtmlEmail htmlEmail = new HtmlEmail();
        htmlEmail.setHostName("smtp.163.com");
        htmlEmail.setSmtpPort(25);
        htmlEmail.setCharset("UTF-8");
        htmlEmail.setAuthentication("prmaker","y1593812");


        try {
            htmlEmail.setFrom("prmaker@163.com");
            htmlEmail.setSubject("下午去我家看看");
            htmlEmail.setMsg("<h1>hello!</h1>");
            htmlEmail.addTo("734520467@qq.com");

            htmlEmail.send();
        } catch (EmailException e) {
            throw new RuntimeException("发送异常",e);
        }
    }

    @Test
    public void testAttach(){

        MultiPartEmail multiPartEmail = new MultiPartEmail();
        multiPartEmail.setHostName("smtp.163.com");
        multiPartEmail.setSmtpPort(25);
        multiPartEmail.setCharset("UTF-8");
        multiPartEmail.setAuthentication("prmaker","y1593812");

        EmailAttachment emailAttachment = new EmailAttachment();
        emailAttachment.setPath("D:/logback.log");

        try {
            multiPartEmail.attach(emailAttachment);
            multiPartEmail.setFrom("prmaker@163.com");
            multiPartEmail.setSubject("晚上回我家吃饭！");
            multiPartEmail.setMsg("hello");
            multiPartEmail.addTo("734520467@qq.com");
            multiPartEmail.send();
        } catch (EmailException e) {
            throw new RuntimeException("发送错误",e);
        }
    }

    @Test
    public void emailUtilTest(){
        EmailUtil.sendEmail("登录提醒","<h2>您的账号在我网站登录</h2>","734520467@qq.com");
    }
}
