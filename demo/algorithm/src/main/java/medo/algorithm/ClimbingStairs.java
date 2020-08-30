package medo.algorithm;

/**
 * 70. Climbing Stairs.<br>
 * 每一步爬一个或两个阶梯，有几种方法可以爬上楼梯。
 * 
 * @author bryce
 *
 */
public interface ClimbingStairs {

    int run(int n);

    default void validParams(int n) {
    }

}
