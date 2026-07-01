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
    public boolean isPalindrome(ListNode head) {
        // array list to store values
        List<Integer> arr = new ArrayList<>();
        ListNode curr = head;

        // loop through linked list (until it's null or you reach the end)
        while (curr != null) {
            // add the value to the array
            arr.add(curr.val);
            // move pointer to next
            curr = curr.next;
        }

        // Input: head = [1,2,3,2,1]
        // you'd need to know the length of the array to figure out how many times
        // for example, with this length of 5... 
        // the odd numbers you don't need to cmpare the middle number.
        // 5 / 2 = 2.5 round to 2? 
        // start with index = 0 compared to length-1

        // instead of the number of comparisons I should use the indices
        int comparisons = arr.size() / 2; // this is int l=0
        int endIndex = arr.size() - 1; // this is r = arr.size()-1
        // then you can do while (l<r) and keep iterating up and down

        for (int i = 0; i < comparisons; i++) {
            // use GET not [] 
            if (arr.get(i) != arr.get(endIndex)) return false;
            endIndex -= 1;
        }
        return true;

    }
}