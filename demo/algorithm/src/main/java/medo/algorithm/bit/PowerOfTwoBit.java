package medo.algorithm.bit;

import medo.algorithm.PowerOfTwo;

/**
 * n: 1, 2, 4, 6
 * n: 1000 n - 1: 0111 n & (n - 1) == 0
 * 
 * @author: bryce
 * @date: 2020-08-18
 */
public class PowerOfTwoBit implements PowerOfTwo{

    @Override
    public boolean run(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
