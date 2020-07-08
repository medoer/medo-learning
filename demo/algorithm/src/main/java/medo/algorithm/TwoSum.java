package medo.algorithm;

/**
 * 1. Two Sum.
 * @author bryce
 *
 */
public interface TwoSum {

    int[] run(int[] nums, int target);

    default void validParams(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
    }
}
