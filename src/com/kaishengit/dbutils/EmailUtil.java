package com.kaishengit.dbutils;

/**
 * Created by Administrator on 2016/6/14.
 */

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发送邮件
 * @author prmaker
 */
public class EmailUtil {


    private static Logger logger = LoggerFactory.getLogger(EmailUtil.class);
    /**
     * 发送电子邮件
     * @param subject 邮件主题
     * @param html 邮件html内容
     * @param adress 邮件地址
     */
    public static void sendEmail(String subject,String html,String adress) {

        HtmlEmail htmlEmail = new HtmlEmail();
        htmlEmail.setHostName(Config.get("mail.hostname"));
        htmlEmail.setSmtpPort(Integer.parseInt(Config.get("mail.port","25")));
        htmlEmail.setCharset(Config.get("mail.charaset"));
        htmlEmail.setAuthentication(Config.get("mail.username"),Config.get("mail.password"));

        try {
            htmlEmail.setFrom(Config.get("mail.from"));
            htmlEmail.setSubject(subject);
            htmlEmail.setMsg(html);
            htmlEmail.addTo(adress);
            htmlEmail.send();

            logger.info("发送{}邮件成功",html);
        } catch (EmailException e) {
            logger.info("发送{}邮件失败",html);
            throw new RuntimeException("发送邮件异常",e);
        }

    }


}
