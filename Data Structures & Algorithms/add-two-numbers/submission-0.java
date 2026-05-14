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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = new ListNode(-1);
        ans.next = null;
        ListNode tmp = ans;

        while (l1!=null || l2!=null || carry!=0){
            int val = (l1==null?0:l1.val) + (l2==null?0:l2.val) + carry;
            ListNode create = new ListNode(val%10);
            carry = val/10;
            tmp.next = create;
            create.next = null;
            tmp = create;
            l1 = (l1==null)?null:l1.next;
            l2 = (l2==null)?null:l2.next;
        }
        return ans.next;
    }
}
