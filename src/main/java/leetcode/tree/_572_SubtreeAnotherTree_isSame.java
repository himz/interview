package leetcode.tree;

import common.TreeNode;

/**
 * Subtree of Another Tree
 * Easy
 *
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *
 * Given tree t:
 *
 *    4
 *   / \
 *  1   2
 *
 * Return true, because t has the same structure and node values with a subtree of s.
 *
 *
 *
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 *
 * Given tree t:
 *
 *    4
 *   / \
 *  1   2
 *
 * Return false.
 *
 *
 *
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
public class _572_SubtreeAnotherTree_isSame {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) {
            return false;
        }

        if(isSubHelper(s, t)) {
            return true;
        }


        return isSubtree(s.left, t)|| isSubtree(s.right, t);
    }

    public boolean isSubHelper(TreeNode s, TreeNode t) {

        if (s == null && t == null) return true;
        if (s == null || t == null) return false;


        return (s.val == t.val ? true: false) && isSubHelper(s.left, t.left) && isSubHelper(s.right, t.right);
    }
}