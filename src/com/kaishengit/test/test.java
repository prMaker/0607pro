package com.kaishengit.test;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Administrator on 2016/6/7.
 */
public class test {
    TestSource ts = new TestSource();
    @Test
    public void testLong(){
        assertEquals(1,ts.re(new Long(1)));
    }
    @Test
    public void testnull(){
        assertNotNull(ts.tnull(1));
    }
    @Test
    public void testExce(){
        ts.save(2);
    }
}
