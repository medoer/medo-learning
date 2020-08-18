package medo.algorithm.recursion;

import medo.algorithm.FibonacciNumber;

/**
 * 检查整数 N，如果 N 小于等于 1，则返回 N。 <br> 
 * 否则，通过递归关系：F_{n} = F_{n-1} + F_{n-2}F n ​ =F n−1 ​
 * +F n−2 ​ 调用自身。 直到所有计算返回结果得到答案。
 * 
 * @author: bryce
 * @date: 2020-08-18
 */
public class FibonacciNumerRecursion implements FibonacciNumber {

    @Override
    public int run(int n) {
        if (n <= 1) {
            return n;
        }
        return run(n - 1) + run(n - 2);
    }

}
