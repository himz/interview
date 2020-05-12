package leetcode.tree;

import common.TreeNode;

/**
 * Maximum depth of a binary patterns.tree
 */
public class _104 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(isLeafNode(root)) {
            return 1;
        }
        int leftVal = maxDepth(root.left);
        int rightVal = maxDepth(root.right);
        return leftVal > rightVal ? leftVal + 1 : rightVal + 1;
    }

    private boolean isLeafNode(TreeNode node) {
        if(node != null && node.left == null && node.right == null) {
            return true;
        } else {
            return false;
        }
    }
}