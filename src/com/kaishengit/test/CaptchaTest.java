package com.kaishengit.test;

import org.junit.Test;
import org.patchca.color.RandomColorFactory;
import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2016/6/13.
 */
public class CaptchaTest {

    @Test
    public void testCaptcha() throws IOException {
//        ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
//        cs.setColorFactory(new SingleColorFactory(new Color(163, 22, 24)));
//        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
//
//        RandomWordFactory randomWordFactory = new RandomWordFactory();
//        randomWordFactory.setMinLength(4);
//        randomWordFactory.setMaxLength(8);
//        randomWordFactory.setCharacters("1234567890abcdef");
//        cs.setWordFactory(randomWordFactory);
//
//        FileOutputStream outputStream = new FileOutputStream("D:/captcha.png");
//        EncoderHelper.getChallangeAndWriteImage(cs,"png",outputStream);

        ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(239, 38, 21)));
        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));

        RandomWordFactory randomWordFactory = new RandomWordFactory();
        randomWordFactory.setMinLength(4);
        randomWordFactory.setMaxLength(8);
        randomWordFactory.setCharacters("1234567890");
        cs.setWordFactory(randomWordFactory);

        FileOutputStream outputStream = new FileOutputStream("D:/captcha.gif");
        EncoderHelper.getChallangeAndWriteImage(cs,"gif",outputStream);


    }
}
