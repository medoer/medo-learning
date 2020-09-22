package medo.algorithm.dynamic;

import medo.algorithm.MaxDiffArray;

/**
 * 求右边减去左边的最大值，右子数组最大值减去当前值可得当前最大差值，迭代致第一个元素即可获得最终值。
 * 
 * @author: bryce
 * @date: 2020-09-22
 */
public class MaxDiffArrDP implements MaxDiffArray {

    @Override
    public int run(int[] arr) {
        if (arr == null || arr.length <= 1) {
            throw new RuntimeException();
        }
        // 当前最大差值
        int diff = Integer.MIN_VALUE;
        // 右子数组最大值
        int max = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            diff = Math.max(diff, max - arr[i]);
            // 更新最大值，供下次循环使用
            max = Math.max(max, arr[i]);
        }
        return diff;
    }

}
