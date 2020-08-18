package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.dynamic.FibonacciNumberDynamic;

public class FibonacciNumberTest {

    @Test
    public void testRecursion() {
        FibonacciNumber fib = new FibonacciNumberDynamic();
        test(fib);
    }

    public void test (FibonacciNumber fib) {
        int run = fib.run(1);
        Assert.assertTrue(run == 1);
        int run2 = fib.run(2);
        Assert.assertTrue(run2 == 1);
        int run3 = fib.run(3);
        Assert.assertTrue(run3 == 2);
        int run4 = fib.run(4);
        int run5 = fib.run(678);
        Assert.assertTrue(run4 == 3);
        System.out.println(run5);
//        String substring = String.valueOf(run5).substring(String.valueOf(run5).length() - 6);
//        System.out.println(substring);
    }
    
}
