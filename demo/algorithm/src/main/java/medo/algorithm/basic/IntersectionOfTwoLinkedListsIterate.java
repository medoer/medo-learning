package medo.algorithm.basic;

import medo.algorithm.IntersectionOfTwoLinkedLists;

/**
 * 时间复杂度 log(mn)。
 * 
 * @author: bryce
 * @date: 2020-07-29
 */
public class IntersectionOfTwoLinkedListsIterate implements IntersectionOfTwoLinkedLists{

    @Override
    public boolean run(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return false;
        }
        ListNode current1 = node1;
        while (current1 != null) {
            ListNode current2 = node2;
            while (current2 != null) {
                if (current1.equals(current2)) {
                    return true;
                }
                current2 = current2.next;
            }
            current1 = current1.next;
        }
        return false;
    }

}
