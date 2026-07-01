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

// recursive depth first search
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        // up the depth, but how to store the depth variable
        // is there a depth variable?

        // check both the left and the right side for the depth
        // int leftDepth = 1 + maxDepth(root.left);
        // int rightDepth = 1 + maxDepth(root.right);
        // if (leftDepth > rightDepth) {
        //     return leftDepth;
        // } else {
        //     return rightDepth;
        // }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

        // return max of the left or right subtree
        // which ever is larger would be the depth for one node

        // call stack: (last in first out)
        // maxDepth(20) -> return 1 + (1, 1) -> return 2
        // maxDepth(9) -> return 1 + Math.max(maxDepth(null), maxDepth(null)) -> 1+0 -> return 1
        // maxDepth(3) -> return 1 + Math.max(maxDepth(9), Math.max(maxDepth(20))) -> return 3 because 1+ (2)

        // right side is 2
        // left side is 1

        // 2 > 1
    }
}
