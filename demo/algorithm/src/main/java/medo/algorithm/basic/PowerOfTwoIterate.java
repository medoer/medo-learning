package medo.algorithm.basic;

import medo.algorithm.PowerOfTwo;

/**
 * 循环：n模2==0，即为偶数，n除2。最后2次幂的数一定为2^0 = 1的结果，否则false。
 * 
 * @author: bryce
 * @date: 2020-08-18
 */
public class PowerOfTwoIterate implements PowerOfTwo {

    @Override
    public boolean run(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }

}
