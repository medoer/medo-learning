package medo.algorithm;

/**
 * 160. Intersection of Two Linked Lists
 * 
 * @author: bryce
 * @date: 2020-07-29
 */
public interface IntersectionOfTwoLinkedLists {

    public class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    boolean run(ListNode node1, ListNode node2);

}
