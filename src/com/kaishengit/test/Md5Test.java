package com.kaishengit.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/14.
 */
public class Md5Test {

    @Test
    public void testMd5() throws IOException {
        //e10adc3949ba59abbe56e057f20f883e

        //salt 9b4c51bb4a423eaf4987eeace6523e35
        String password = "111111";
        String salt = "adsfsadf";
        password = DigestUtils.md5Hex(password);
        System.out.println(password);
    }

    @Test
    public void testSha(){
        //7c4a8d09ca3762af61e59520943dc26494f8941b

        //salt 882495efa0ae217b589b27f104ee0f49669658b5
        String password = "123456";
        String salt = "adsfsadf";
        password = DigestUtils.sha1Hex(password+salt);
        System.out.println(password);
    }

    @Test
    public void checkFileMd5() throws IOException {
        //6ed0219810f09b4de36c9cdf4a8f4107
        //6ed0219810f09b4de36c9cdf4a8f4107
        FileInputStream inputStream = new FileInputStream("D:/logback 2.log");
        String code = DigestUtils.md5Hex(inputStream);
        System.out.println(code);
    }

    @Test
    public void checkFileSha() throws IOException {
        //33b1fde0572e7bd8d9dac6eb9331915a02bb637a
        //33b1fde0572e7bd8d9dac6eb9331915a02bb637a
        FileInputStream inputStream = new FileInputStream("D:/logback 2.log");
        String code = DigestUtils.shaHex(inputStream);
        System.out.println(code);
    }
}
