package medo.algorithm;

import java.util.List;

/**
 * 15. 3Sum.
 * @author bryce
 *
 */
public interface ThreeSum {

    List<List<Integer>> run(int[] nums);

    default void validParams(int[] nums) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException();
        }
    }
}
