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

class Solution {
    public TreeNode invertTree(TreeNode root) {
        // inverting the binary tree looks like we are swapping the child nodes
    // the process for doing this looks like we'll need to repeatedly swap the left and right
    // child nodes 

    // root = 3
    //      2   1

    if (root == null) return null; // base case and edge case

    // if (root.left == null && root.right == null) return;

    // process the children first
    TreeNode temp = root.left; // save the left node
    root.left = root.right; // update the left node to the right node
    root.right = temp;  // update to the right node to the saved left node temp

    //call method on both child nodes to swap
    invertTree(root.left);
    invertTree(root.right);

    // this return won't be reached until
    return root;

    }
}
