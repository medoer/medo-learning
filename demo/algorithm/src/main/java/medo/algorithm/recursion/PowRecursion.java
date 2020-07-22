package medo.algorithm.recursion;

import medo.algorithm.Pow;

/**
 * 分治。会出现堆栈溢出。
 * @author bryce
 *
 */
public class PowRecursion implements Pow {

    @Override
    public int run(int x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / run(x, -n);
        }
        if (n % 2 > 0) {
            return x * run(x, n - 1);
        }
        return run(x * x, n/2);
    }

}
