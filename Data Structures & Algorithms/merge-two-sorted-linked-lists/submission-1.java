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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // edge case:
        if (list1 == null && list2 == null) return null;

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        // Input: list1 = [1,2,4], list2 = [1,3,5]
        // Output: [1,1,2,3,4,5]

        // curr =  [dummy head,1,2,4], list1 = [2,4, null], list2 = [1,3,5, null]
        // curr = [1,2,4], list1 = [2,4 null], list2 = [1,3,5, null]
        // curr = [1,->1,3,5], list1 = [4,null], list2 = [3,5,null]
        // curr = [1,1,->2,4,null], list1 = [4, null], list2 = [5, null]
        // curr = [1,1,2,->3,5,null], list1 = [null], list2 = [5, null]
        // curr = [1,1,2,3,-> 4,null], list1=null, list2 = null
        // curr = [1,1,2,3,4,->5, null], 

        // dummyHead = [null -> 1,2,4-> null]
        // dummyHead = [null -> 1,1,3,5 -> null]
        // dummyHead = [null-> 1,1,2,4-> null]
        // dummyHead = [null-> 1,1,2,3,4,null]
        // dummyHead = [null-> 1,1,2,3,4,5,null]


        // pick one list to start as the head based on which is less
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;

        // loop through list and compare at each node until both lists are null
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        // need to add some kind of null check... to see which one to add last
        if (list1 != null) {
            curr.next = list1;
            // list2 = list2.next; // don't need to move pointers anymore
            // curr = curr.next;
        } else {
            curr.next = list2;
            // list1 = list1.next;
            // curr = curr.next;
        }

        // return head of list chosen as the head
        return dummyHead.next;
    }
}