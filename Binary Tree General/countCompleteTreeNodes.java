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
    public static void inorder(TreeNode root, AtomicInteger count) {
        if (root == null) return;
        inorder(root.left, count);
        count.set(count.get() + 1);
        inorder(root.right, count);
    }

    public int countNodes(TreeNode root) {
        AtomicInteger res = new AtomicInteger(0);
        inorder(root, res);
        return res.get();
    }
}