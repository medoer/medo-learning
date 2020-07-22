package medo.algorithm.recursion;

import medo.algorithm.Factorial;

public class FactorialRecursion implements Factorial {

    @Override
    public int run(int n) {
        validParams(n);
        if (n <= 1) {
            return 1;
        }
        return n * run(n - 1);
    }

}
