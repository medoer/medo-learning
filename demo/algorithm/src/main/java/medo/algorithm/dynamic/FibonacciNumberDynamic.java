package medo.algorithm.dynamic;

import medo.algorithm.FibonacciNumber;

public class FibonacciNumberDynamic implements FibonacciNumber {

    @Override
    public int run(int n) {
        if (n <= 1) {
            return n;
        }
        return memoize(n);
    }

    public int memoize(int n) {
        int[] cache = new int[n + 1];
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
            String result = String.valueOf(cache[i]);
            result = result.length() > 6 ? result.substring(result.length() - 6) : result;
            cache[i] = Integer.valueOf(result);
        }
        return cache[n];
    }

}