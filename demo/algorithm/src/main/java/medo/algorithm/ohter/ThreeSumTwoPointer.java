package medo.algorithm.ohter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import medo.algorithm.ThreeSum;

public class ThreeSumTwoPointer implements ThreeSum{

    @Override
    public List<List<Integer>> run(int[] nums) {
        validParams(nums);
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            // 已经对数组进行了升序排序，对于大于 0 的数据不可能存在三数之和等于 0 。
            if (target < 0) {
                break;
            }
            // 判断是否有重复数据
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    while(j < k && nums[j] == nums[j + 1]) {
                        j = j + 1;
                    }
                } else if (sum > 0) {
                    while(j < k && nums[k] == nums[k - 1]) {
                        k = k - 1;
                    }
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // 相临元素与当前元素相同则跳过
                    while(j < k && nums[j] == nums[j + 1]) {
                        j = j + 1;
                    }
                    while(j < k && nums[k] == nums[k - 1]) {
                        k = k - 1;
                    }
                }
            }
        }
        return result;
    }

}
