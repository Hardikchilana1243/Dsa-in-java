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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return solve(root , root.val);
    }
    public int solve(TreeNode root , int max) {
        if(root == null ) return 0;
        int count = 0;
        if(max <= root.val) count = 1;
        max = Math.max(max,root.val);
        count += solve(root.left , max);
        count += solve(root.right , max);
        return count;
    }
}