package com.kaishengit.test;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/6/13.
 */
public class Log4jTestCase {

    @Test
    public void testLog(){
        Logger logger = LoggerFactory.getLogger(Log4jTestCase.class); //Logger.getLogger(Log4jTestCase.class);

        String name="Alex";
        String bookName="重构";
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("{}借阅了{}",name,bookName);
        logger.warn("warn message");
        logger.error("error message");
        //logger.fatal("fatal message");

    }



}
