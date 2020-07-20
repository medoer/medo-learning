package medo.algorithm.queue;

import java.util.LinkedList;

import medo.algorithm.SlidingWindowMaximum;

public class SlidingWindowMaximumWithQueue implements SlidingWindowMaximum {

    @Override
    public int[] run(int k, int[] nums) {
        validParams(k, nums);
        int index = 0;
        // 结果集长度为 n - k
        int[] result = new int[nums.length + 1 - k];
        LinkedList<Integer> deq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && deq.peekFirst() <= i - k) {
                deq.removeFirst();
            }
            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) {
                deq.removeLast();
            }
            deq.addLast(i);
            if (i >= k - 1) {
                result[index++] = nums[deq.peekFirst()];
            }
        }
        return result;
    }

}
