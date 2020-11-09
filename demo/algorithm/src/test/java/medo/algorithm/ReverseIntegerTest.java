package medo.algorithm;

import medo.algorithm.basic.ReverseIntegerImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: yangcj
 * @Date: 2020/11/9 13:23
 */
public class ReverseIntegerTest {

    @Test
    public void testInverseInteger() {
        ReverseInteger reverseInteger = new ReverseIntegerImpl();
        int reverse = reverseInteger.reverse(1999999999);
        Assert.assertEquals(reverse, 0);
        int reverse2 = reverseInteger.reverse(123);
        Assert.assertEquals(reverse2, 321);
    }

}
