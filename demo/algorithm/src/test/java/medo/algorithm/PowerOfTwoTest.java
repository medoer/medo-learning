package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.basic.PowerOfTwoIterate;
import medo.algorithm.bit.PowerOfTwoBit;
import medo.algorithm.recursion.PowerOfTwoRecursion;

public class PowerOfTwoTest {

    @Test
    public void testBit() {
        PowerOfTwo powerOfTwo = new PowerOfTwoBit();
        test(powerOfTwo);
    }

    @Test
    public void testIterate() {
        PowerOfTwo powerOfTwo = new PowerOfTwoIterate();
        test(powerOfTwo);
    }

    @Test
    public void testRecursion() {
        PowerOfTwo powerOfTwo = new PowerOfTwoRecursion();
        test(powerOfTwo);
    }

    public void test(PowerOfTwo powerOfTwo) {
        Assert.assertFalse(powerOfTwo.run(0));
        Assert.assertTrue(powerOfTwo.run(1));
        Assert.assertTrue(powerOfTwo.run(2));
        Assert.assertFalse(powerOfTwo.run(3));
        Assert.assertTrue(powerOfTwo.run(8));
    }
}
