package medo.algorithm;

/**
 * 206. Reverse Linked List.
 * 
 * @author bryce
 *
 */
public interface ReverseLinkedList {

    public class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    ListNode run(ListNode head);

}
