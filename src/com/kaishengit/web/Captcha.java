package com.kaishengit.web;

import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016/6/13.
 */
@WebServlet("/captcha.png")
public class Captcha extends HttpServlet{

    Logger logger = LoggerFactory.getLogger(Captcha.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(253, 31, 28)));
        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));

        RandomWordFactory randomWordFactory = new RandomWordFactory();
        randomWordFactory.setMinLength(4);
        randomWordFactory.setMaxLength(8);
        randomWordFactory.setCharacters("0123456789");
        cs.setWordFactory(randomWordFactory);

        OutputStream outputStream = resp.getOutputStream();
        String captcha = EncoderHelper.getChallangeAndWriteImage(cs,"png", outputStream);

        req.getSession().setAttribute("captcha",captcha);

        outputStream.flush();
        outputStream.close();
    }
}
