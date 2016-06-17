package com.kaishengit.dbutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2016/6/16.
 */
public class ByteCountToDisplaySize {

    Logger logger = LoggerFactory.getLogger(ByteCountToDisplaySize.class);
    public static String byteCountToDisplaySize(Long size){
        if(size<1024){
            return String.valueOf(size)+"B";
        }

        if(new Double(size)/1024>=1&&new Double(size)/1024<1024){
            System.out.println(String.valueOf(size/1024)+"KB");
            return String.valueOf(new Double(size)/1024)+"KB";
        }

        if(new Double(size)/(1024*1024)>=1&&new Double(size)/(1024*1024)<=1024){
            return String.valueOf(new Double(size)/(1024*1024))+"MB";
        }

        if(new Double(size)/(1024*1024*1024)>=1){
            return String.valueOf(new Double(size)/(1024*1024*1024))+"GB";
        }
        return null;
    }

}
