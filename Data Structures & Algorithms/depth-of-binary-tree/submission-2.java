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
    public int maxDepth(TreeNode root) {
            // create stack where each entry is a node and a depth
            Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
            // add the root to the stack with a depth 1
            stack.push(new Pair<>(root,1));
            int res = 0; // stores the max depth

            while (!stack.isEmpty()) { // process until no nodes left on stack
                // pop the item off the top of the stack
                Pair<TreeNode, Integer> current = stack.pop();
                // Extract the node from the pair
                TreeNode node = current.getKey();
                // Extract the depth assoiated with the node
                int depth = current.getValue();
                if (node != null) { // skip processing if node is null
                    // update the maximum depth found so far if this node's depth is larger
                    res = Math.max(res, depth);
                    // when you're adding the children - you'll need to increment the depth from the parent node
                    // Push the left child onto the stack with its depth incremented by 1.
                    stack.push(new Pair<>(node.left, depth + 1));
                    stack.push(new Pair<>(node.right, depth + 1));
                }
            }
            return res;
        
    }
}
