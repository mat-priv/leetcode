package Algorithms._206;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head.next;
        head.next = null;
        return reversNode(head, temp);

    }

    public ListNode reversNode(ListNode prev, ListNode current) {

        if (current.next == null) {
            current.next = prev;
            return current;
        }

        ListNode temp = current.next;
        current.next = prev;

        return reversNode(current, temp);
    }
}
