package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.basic.DialBase;

public class DialTest {
    
    @Test
    public void test() {
        String[] keys = new String[] {
                "5", "8", "6", "0", "6", "3", "3", "5", "5", "4", "0"
        };
        Dial dial = new DialBase();
        int run = dial.run(keys);
        Assert.assertTrue(run == 16);
        String a = "";
        byte[] bytes = a.getBytes();
        
    }

}
