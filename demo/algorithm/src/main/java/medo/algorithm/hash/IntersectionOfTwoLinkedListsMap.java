package medo.algorithm.hash;

import java.util.HashSet;
import java.util.Set;

import medo.algorithm.IntersectionOfTwoLinkedLists;

/**
 * 时间复杂度 log(m + n)。
 * 
 * @author: bryce
 * @date: 2020-07-29
 */
public class IntersectionOfTwoLinkedListsMap implements IntersectionOfTwoLinkedLists{

    @Override
    public boolean run(ListNode node1, ListNode node2) {
        Set<ListNode> set = new HashSet<>();
        ListNode current1 = node1;
        while (current1 != null) {
            set.add(current1);
            current1 = current1.next;
        }
        ListNode current2 = node2;
        while (current2 != null) {
            if (set.contains(current2)) {
                return true;
            }
            current2 = current2.next;
        }
        return false;
    }

}
