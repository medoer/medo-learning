package medo.algorithm.queue;

import java.util.PriorityQueue;

import medo.algorithm.KthLargestElement;

public class KthLargestElementByPriorityQueue implements KthLargestElement {

    private PriorityQueue<Integer> priorityQueues;
    private int k;

    public KthLargestElementByPriorityQueue(int k, int[] nums) {
        this.k = k;
        this.priorityQueues = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            run(nums[i]);
        }
    }

    @Override
    public int run(int val) {
        if (priorityQueues.size() < k) {
            priorityQueues.add(val);
        } else if (priorityQueues.peek() < val) {
            priorityQueues.poll();
            priorityQueues.add(val);
        }
        return priorityQueues.peek();
    }

}
