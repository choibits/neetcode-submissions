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
    public boolean hasCycle(ListNode head) {
        // edge cases
        if (head == null) return false;

        // we don't know the length
        // but we know by where the node is in memory whether it is the same node

        // loop through the nodes and check whether they are equal to each other
        // cycling next for each node
        ListNode slow = head;
        
        // could compare by creating another node to compare that goes faster
        ListNode fast = head;

        // could create another node to see whether there's an infinite loop?


        // note: the below does not work as a stop condition because if fast.next is null,
        // then fast.next.next will throw an NPE
        // slow.next != null || fast.next.next != null
        while (fast != null && fast.next != null) { // make sure the one ahead is not null
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true; // this only compares the current node to the next node...
        }

        // loop 1: slow = 2, fast = 3
        // loop 2: slow = 3, fast = 2
        // loop 3: slow = 4, fast = 4
        
        // return a boolean
        return false;
    }
}
