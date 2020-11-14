package medo.algorithm;

import medo.algorithm.basic.RomanToIntegerImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: yangcj
 * @Date: 2020/11/14 13:34
 */
public class RomanToIntegerTest {

    @Test
    public void testRomanToInteger() {
        RomanToInteger romanToInteger = new RomanToIntegerImpl();
        int four = romanToInteger.romanToInteger("IV");
        Assert.assertEquals(4, four);

        int six = romanToInteger.romanToInteger("VI");
        Assert.assertEquals(6, six);

        int five = romanToInteger.romanToInteger("V");
        Assert.assertEquals(5, five);
    }

}
