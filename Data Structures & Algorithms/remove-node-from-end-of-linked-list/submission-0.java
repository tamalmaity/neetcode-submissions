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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = 0;
        ListNode tmp = head;
        while(tmp!=null){ 
            tmp = tmp.next;
            sz++;
        }
        if (sz==n) return head.next;
        int traverse = sz-(n+1);
        tmp = head;
        while (traverse != 0){
            tmp = tmp.next;
            traverse--;
        }
        tmp.next = tmp.next.next;
        return head;
    }
}
