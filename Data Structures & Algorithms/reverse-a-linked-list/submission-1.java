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
        if (head == null) return null;

        ListNode pre = null, p1 = head, p2;

        while(p1 != null) {
            p2 = p1.next; // use p2 to save the p1.next
            p1.next = pre; // reverse the pointer for p1
            pre = p1; // save p1 in pre for next loop
            p1 = p2; // set p1 as p2 for next loop
        }
        return pre;
    }
}
