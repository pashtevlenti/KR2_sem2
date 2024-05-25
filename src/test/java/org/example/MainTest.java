package org.example;

import org.junit.Assert;
import org.junit.Test;


public class MainTest {
    @Test
    public void checkTestArray(){
        Assert.assertEquals(Main.check(new byte[]{5,6,1,3,8,2}),1); //101,110,1,11,1000,10 -> 9 -> 1
    }
    @Test
    public void checkTestZero(){
        Assert.assertEquals(Main.check(new byte[]{0,0,0,0,0,0,}),0); //0
    }
    @Test
    public void checkTestNull(){
        Assert.assertEquals(Main.check(new byte[]{}),0); //0
    }
}
