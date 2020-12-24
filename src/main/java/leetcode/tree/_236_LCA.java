package leetcode.tree;

import common.TreeNode;
/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */

/**
 * Algo: 1) If root == p,q it is the lca!.
 *       2) iterate on both sides.
 *       3) If both left/right return non null, current node is the lca, else lca is the non null element.
 *
 *       Assumption - both p,q exist in the tree. If not, make sure to do a search before doing thie lca code.
 */
public class _236_LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return  lca(root, p,q);
    }

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode  q) {
        if(root == null) {
            return null;
        }

        if(root == p || root == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }

        if(left != null) {
            return left;
        } else {
            return right;
        }

    }
}