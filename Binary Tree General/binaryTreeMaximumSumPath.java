import java.util.*;

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
    public int helper(TreeNode root, TreeNode res) {
        if(root == null) return 0;
        int lh = Math.max(0, helper(root.left, res));
        int rh = Math.max(0, helper(root.right, res));
        res.val = Math.max(res.val, Math.max((lh+rh+root.val),Math.max(root.val,Math.max((lh+root.val),(rh+root.val)))));
        return (root.val + Math.max(lh,rh));
    }

    public int maxPathSum(TreeNode root) {
        TreeNode res = new TreeNode(Integer.MIN_VALUE);
        helper(root, res);
        return res.val < root.val ? root.val : res.val;
    }
}