package medo.algorithm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import medo.algorithm.recursion.FactorialRecursion;

public class FactorialTest {

    @Test(expected = IllegalArgumentException.class)
    public void testArg() {
        Factorial factorialRecursion = new FactorialRecursion();
        factorialRecursion.run(0);
    }

    @Test
    public void testRecursion() {
        Factorial factorialRecursion = new FactorialRecursion();
        int run = factorialRecursion.run(4);
        assertTrue(run == 24);
    }

}
