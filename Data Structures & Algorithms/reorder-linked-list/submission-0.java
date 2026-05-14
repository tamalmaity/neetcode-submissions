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
    public void reorderList(ListNode head) {
        if (head.next == null) return;
        ListNode slow = head, fast = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null, fut;
        while (curr!=null){
            fut = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fut;
        }
        ListNode second = prev, first = head;
        ListNode firstNxt, secondNxt;
        while (second!=null){
            firstNxt = first.next;
            secondNxt = second.next;
            first.next = second;
            second.next = firstNxt;
            first = firstNxt;
            second = secondNxt;
        }
    }
}
