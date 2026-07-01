/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// recursive dpeth first search
class Solution {
    public int maxDepth(TreeNode root) {
        // create a queue to do breadth first search
        // LL is a common concrete class used for queue
        Queue<TreeNode> q = new LinkedList<>();

        // base case, if there is a root, add it to the queue
        if (root != null) {
            q.add(root);
        }
        // if root is null, queue stays empty which will make answer zero

        // counts the levels of trees we've processed
        int level = 0;

        while (!q.isEmpty()) { // loop as long as nodes left to process, or queue is not empty
            int size = q.size(); // captures how many nodes are in the current level

            for (int i = 0; i < size; i++) { // iterate through number of nodes in the level
            // Remove the front node from the queue and store it in node. (poll() returns and removes the head of the queue.)
                TreeNode node = q.poll(); // remove the parent
                if (node.left != null) { // replace with child on left if it exists
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            level++; // level has been fully processed
        }
        // if queue is empty, then the while loop finishes and it means all the levels have been processed 
        return level;
    }
}
