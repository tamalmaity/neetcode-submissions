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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode nxt = head.next;
        while (nxt != null)
        {
            ListNode tmp = nxt.next;
            nxt.next = head;
            head.next = prev;
            prev = head;
            head = nxt;
            nxt = tmp;
        }
        return head;
    }
}
