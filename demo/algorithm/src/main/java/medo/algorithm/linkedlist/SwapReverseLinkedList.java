package medo.algorithm.linkedlist;

import medo.algorithm.ReverseLinkedList;

public class SwapReverseLinkedList implements ReverseLinkedList {

    @Override
    public ListNode run(ListNode head) {
        ListNode current = head;
        ListNode result = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = result;
            result = current;
            current = next;
        }
        return result;
    }

}
