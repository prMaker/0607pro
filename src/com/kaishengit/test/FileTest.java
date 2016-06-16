package com.kaishengit.test;

import org.junit.Test;

import java.io.File;

/**
 * Created by Administrator on 2016/6/16.
 */
public class FileTest {

    @Test
    public  void  file(){
        File file = new File("D:/fileDemo");
        if(!file.exists()){
            file.mkdir();
        }
    }
}
