package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.dynamic.ClimbingStairsDP;
import medo.algorithm.dynamic.ClimbingStairsDP2;

public class ClimbingStairsTest {

    @Test
    public void testDynamic() {
        ClimbingStairs climbingStairsDP = new ClimbingStairsDP();
        test(climbingStairsDP);
    }

    @Test
    public void testDynamic2() {
        ClimbingStairs climbingStairsDP = new ClimbingStairsDP2();
        test(climbingStairsDP);
    }

    public void test(ClimbingStairs fib) {
        int run = fib.run(1);
        Assert.assertTrue(run == 1);
        int run2 = fib.run(2);
        Assert.assertTrue(run2 == 2);
        int run3 = fib.run(3);
        Assert.assertTrue(run3 == 3);
        int run4 = fib.run(4);
        Assert.assertTrue(run4 == 5);
        int run5 = fib.run(5);
        Assert.assertTrue(run5 == 8);
    }

}
