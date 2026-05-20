class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int s1 = size(l1);
        int s2 = size(l2);

        // ensure l1 is longer
        if (s2 > s1) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode head = l1;
        ListNode prev = null;

        int carry = 0;

        while (l1 != null) {
            int sum = l1.val + carry;

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            l1.val = sum % 10;
            carry = sum / 10;

            prev = l1;
            l1 = l1.next;
        }

        if (carry != 0) {
            prev.next = new ListNode(carry);
        }

        return head;
    }

    private int size(ListNode node) {
        int s = 0;

        while (node != null) {
            s++;
            node = node.next;
        }

        return s;
    }
}