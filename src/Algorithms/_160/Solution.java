package Algorithms._160;


import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Set<ListNode> setA = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            setA.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if (setA.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }
}