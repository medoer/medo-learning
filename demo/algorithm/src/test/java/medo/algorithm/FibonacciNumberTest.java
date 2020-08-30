package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.dynamic.FibonacciNumberDynamic;
import medo.algorithm.recursion.FibonacciNumerRecursion;

public class FibonacciNumberTest {

    @Test
    public void testDynamic() {
        FibonacciNumber fib = new FibonacciNumberDynamic();
        test(fib);
    }

    @Test
    public void testRecursion() {
        FibonacciNumber fib = new FibonacciNumerRecursion();
        test(fib);
    }

    public void test(FibonacciNumber fib) {
        int run = fib.run(1);
        Assert.assertTrue(run == 1);
        int run2 = fib.run(2);
        Assert.assertTrue(run2 == 1);
        int run3 = fib.run(3);
        Assert.assertTrue(run3 == 2);
        int run4 = fib.run(4);
        Assert.assertTrue(run4 == 3);
        int run5 = fib.run(5);
        Assert.assertTrue(run5 == 5);
    }

}
