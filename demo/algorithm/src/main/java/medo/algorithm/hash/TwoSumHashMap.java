package medo.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

import medo.algorithm.TwoSum;

public class TwoSumHashMap implements TwoSum {

    @Override
    public int[] run(int[] nums, int target) {
        validParams(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int expectValue = target - nums[i];
            if (map.containsKey(expectValue)) {
                return new int[] { i, map.get(expectValue) };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }

}
