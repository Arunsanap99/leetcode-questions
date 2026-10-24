
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;  // 1. Save next node
            curr.next = prev;  // 2. Reverse the link
            prev = curr;       // 3. Move prev
            curr = next;       // 4. Move curr
        }

        return prev;
    }
}
