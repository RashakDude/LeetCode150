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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        int reverse = count / k;
        temp = dummy;
        while (reverse > 0) {
            ListNode tail = head;
            int m = k;
            ListNode next = null;
            while (m > 0) {
                ListNode newNode = head.next;
                head.next = next;
                next = head;
                head = newNode;
                m--;
            }
            temp.next = next;
            temp = tail;
            reverse--;
        }
        temp.next = head;
        return dummy.next;
    }
}