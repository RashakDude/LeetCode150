import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode temp = new ListNode(0);
        ListNode p = temp;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                p.next = node1;
                node1 = node1.next;
            } else {
                p.next = node2;
                node2 = node2.next;
            }
            p = p.next;
        }
        if (node1 != null) p.next = node1;
        if (node2 != null) p.next = node2;
        return temp.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(slow);
        return merge(node1, node2);
    }
}
