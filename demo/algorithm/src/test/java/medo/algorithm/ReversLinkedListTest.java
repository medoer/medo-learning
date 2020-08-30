package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.ReverseLinkedList.ListNode;
import medo.algorithm.linkedlist.SwapReverseLinkedList;

public class ReversLinkedListTest {

    @Test
    public void testStack() {
        ReverseLinkedList list = new SwapReverseLinkedList();
        ReverseLinkedList.ListNode head = new ListNode(1);
        ReverseLinkedList.ListNode listNode2 = new ListNode(2);
        head.next = listNode2;
        listNode2.next = new ListNode(3);
        ListNode run = list.run(head);
        Assert.assertTrue(run.val == 3);
        Assert.assertTrue(run.next.val == 2);
    }

}
