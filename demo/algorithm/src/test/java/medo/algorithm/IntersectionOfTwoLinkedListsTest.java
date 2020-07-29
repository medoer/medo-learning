package medo.algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

import medo.algorithm.IntersectionOfTwoLinkedLists.ListNode;
import medo.algorithm.basic.IntersectionOfTwoLinkedListsIterate;
import medo.algorithm.hash.IntersectionOfTwoLinkedListsMap;

public class IntersectionOfTwoLinkedListsTest {

    @Test
    public void basic() {
        IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedListsIterate();
        test(intersectionOfTwoLinkedLists);
    }

    @Test
    public void hash() {
        IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedListsMap();
        test(intersectionOfTwoLinkedLists);
    }

    private void test(IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        assertFalse(intersectionOfTwoLinkedLists.run(node1, node2));
        node2.next.next.next = node1.next;
        assertTrue(intersectionOfTwoLinkedLists.run(node1, node2));
    }

}
