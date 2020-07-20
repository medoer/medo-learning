package medo.algorithm;

/**
 * 239. Sliding Window Maximum.
 * 
 * @author bryce
 *
 */
public interface SlidingWindowMaximum {

    int[] run(int k, int[] nums);

    default void validParams(int k, int[] nums) {
        if (k <= 0 || nums == null || nums.length < k) {
            throw new IllegalArgumentException();
        }
    }
}
