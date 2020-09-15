package medo.algorithm.linkedlist;

import medo.algorithm.ReverseLinkedList;

public class SwapReverseLinkedList implements ReverseLinkedList {

    @Override
    public ListNode run(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = result;
            result = head;
            head = next;
        }
        return result;
    }

}
