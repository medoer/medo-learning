package medo.algorithm.basic;

import medo.algorithm.TwoSum;

public class TwoSumIterate implements TwoSum {

    @Override
    public int[] run(int[] nums, int target) {
        validParams(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{ i, j };
                }
            }
        }
        return new int[] {};
    }

}
