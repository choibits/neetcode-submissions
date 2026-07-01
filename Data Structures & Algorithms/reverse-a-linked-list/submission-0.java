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
        // edge cases
        // if the list is null, then we would just return null
        if (head == null) return null;

        // in this case, there is no tail value to start at
        // and there is no prev values
        // need pointers for those

        // Loop through the list
        // Example Input: head = [0,1,2,3]
        // 0.next would be null, 0.prev would be 1
        // set a temp value 1.next would be 0
        // 2.next would be 1
        // 3.next would be 2
        // idea is we want to reverse the pointers as we go through the list

        ListNode current = head; // current is 0
        ListNode prev = null; // prev is null
        ListNode next = current.next; // next is 1

        while (current != null) { // loop until list is finished
            current.next = prev; 
            prev = current; 
            current = next; 
            if (next != null) {
                next = current.next; 
            }
        }
        
        // ==== Before
        // current = 0 -> 1 -> ... null
        // prev = null
        // next = 1 -> 2 -> 3 -> null

        // ==== Cycle 1
        // 0 -> null
        // prev = 0 -> null
        // current = 1 -> 2->3...
        // next = 2->3...

        // ==== Cycle 2
        // current = 1 ->2-> 3 -> null
        // current.next (1 -> 0-> null)
        // prev = 1 -> 0 -> null
        // current = 2-> 3-> null
        // next = 3-> null

        // ==== Cycle 3
        // current = 2-> 3-> null
        // current = 2-> 1 -> 0 -> null
        // prev = 2-> 1 -> 0 -> null
        // current = 3 -> null
        // next = null

        // need to make sure the head is point next to null then return?
        // need to return the tail...?
        return prev;
    }
}
