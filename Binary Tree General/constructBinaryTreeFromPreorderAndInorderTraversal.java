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

    private int preorderIndex = 0;

    public TreeNode helper(int[] preorder, HashMap<Integer, Integer> map, int start, int end) {
        if (start > end) return null;
        int pval = preorder[preorderIndex];
        int inorderIndex = map.get(pval);
        TreeNode root = new TreeNode(pval);
        preorderIndex++;
        root.left = helper(preorder, map, start, inorderIndex-1);
        root.right = helper(preorder, map, inorderIndex+1, end);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = inorder.length;
        for (int i = 0; i < len; i++) map.put(inorder[i], i);
        return helper(preorder, map, 0, len-1);
    }
}