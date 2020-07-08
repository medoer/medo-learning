package medo.algorithm.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import medo.algorithm.ThreeSum;

public class ThreeSumHashSet implements ThreeSum{

    @Override
    public List<List<Integer>> run(int[] nums) {
        validParams(nums);
        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();
        Set<Integer> cache = new HashSet<>();
        label: for (int i = 0; i < nums.length - 1; i++) {
            cache.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                int target = - (nums[i] + nums[j]);
                if (cache.contains(target)) {
                    result.add(Arrays.asList(target, nums[i], nums[j]));
                    continue label;
                }
            }
        }
        return new ArrayList<>(result);
    }

}
