package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

/**
 * Validate Binary Search Tree
 */
public class _98 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left != null && root.left.val > root.val) {
            return false;
        }

        if(root.right != null && root.right.val < root.val) {
            return false;
        }

        if(!isValidBST(root.left) || !isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}