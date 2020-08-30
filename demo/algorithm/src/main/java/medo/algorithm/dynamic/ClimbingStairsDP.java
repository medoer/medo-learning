package medo.algorithm.dynamic;

import medo.algorithm.ClimbingStairs;

public class ClimbingStairsDP implements ClimbingStairs{

    @Override
    public int run(int n) {
        if (n <= 2) {
            return n;
        }
        int[] cache = new int[n];
        cache[0] = 1;
        cache[1] = 2;
        for (int i = 2; i < n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n - 1];
    }

}
