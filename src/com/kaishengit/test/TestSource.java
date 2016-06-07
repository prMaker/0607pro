package com.kaishengit.test;

/**
 * Created by Administrator on 2016/6/7.
 */
public class TestSource {

    public int re(Long i){
        if(i.equals(1L)){
            return 1;
        }
        return 0;
    }

    public Object tnull(int i){
        if(i==1){
            return new Object();
        }
        return null;
    }

    public void save(int i){
        if(i==1){
            throw new RuntimeException();
        }
    }

}
