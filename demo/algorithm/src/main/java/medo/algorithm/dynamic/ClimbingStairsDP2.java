package medo.algorithm.dynamic;

import medo.algorithm.ClimbingStairs;

public class ClimbingStairsDP2 implements ClimbingStairs {

    @Override
    public int run(int n) {
        if (n <= 2) {
            return n;
        }
        // 第一步
        int first = 1;
        // 第二步
        int second = 2;
        int count = 0;
        for (int i = 2; i < n; i++) {
            count = first + second;
            first = second;
            second = count;
        }
        return count;
    }

}
