package Algorithms._141;


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode head1 = head;
        ListNode head2 = head;
        while (true) {
            if (head1.next == null || head2.next == null || head2.next.next == null) return false;
            head1 = head1.next;
            head2 = head2.next.next;
            if (head1 == head2) return true;
        }

    }
}