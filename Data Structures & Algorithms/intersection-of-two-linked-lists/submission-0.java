/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // pointers to store original heads
        ListNode tempA = headA;
        ListNode tempB = headB;

        // edge cases
        if (tempA == null) return null;
        if (tempB == null) return null;

        // the nodes will point to a place in memory,
        // so if they are equal to each other we know they are the same node

        // you can't actually iterate at the same rate
        // becuase if they're not equidistant from the head they would never touch

        // could put one node going faster than the other
        // but the issue would be re iterating through the list
       
       // while you're not at the end of the list
       // iterate and push A up by 1
       // iterate and push B up by 1
       // if you do reach the end of the list, start again at headA / headB

       while (tempA != tempB) {
        if (tempA == null) {
            tempA = headB;
        } else {
            tempA = tempA.next;
        }
        if (tempB == null) {
            tempB = headA;
        } else {
            tempB = tempB.next;
        }

       }

        //restart the list

        // Example:
        // Input: intersectVal = 8, 
        // listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
    

        // return the intersected node
        return tempA;
    }
}