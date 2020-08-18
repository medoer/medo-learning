package medo.algorithm.recursion;

import medo.algorithm.PowerOfTwo;

public class PowerOfTwoRecursion implements PowerOfTwo{

    @Override
    public boolean run(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0 || n % 2 != 0) {
            return false;
        }
        n = n/2;
        return run(n);
    }

}
